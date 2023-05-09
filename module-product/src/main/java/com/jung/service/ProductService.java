package com.jung.service;

import com.jung.domain.product.Product;
import com.jung.domain.product.ProductRepository;
import com.jung.domain.product.Products;
import com.jung.domain.product.SearchInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductService {
    private final NaverApiService naverApiService;
    private final ProductRepository productRepository;
    private final RedisTemplate<String,Object> redisTemplate;
    public List<Product> searchProduct(SearchInfo searchInfo){
        log.info("keyword "+searchInfo.getQuery());
        Optional<Products> products = productRepository.findById(searchInfo.getQuery());
        if(products.isPresent()){
            log.info("cache called! ");

            return products.get().getProductList();
        }
        return callApiAndSaveCache(searchInfo);
    }

    private List<Product> callApiAndSaveCache(SearchInfo searchInfo){
        List<Product> searchedProducts = naverApiService.callApi(searchInfo);
        Products resultProducts = Products.builder()
                .keyword(searchInfo.getQuery())
                .productList(searchedProducts)
                .build();
        productRepository.save(resultProducts);
        log.info("api called! "+searchedProducts.size());
        return searchedProducts;
    }
}
