package com.jung.service;

import com.jung.domain.product.Product;
import com.jung.domain.product.ProductRepository;
import com.jung.domain.product.SearchInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final NaverApiService naverApiService;
    private final ProductRepository productRepository;
    public List<Product> searchProduct(SearchInfo searchInfo){
        List<Product> products = productRepository.findByKeyword(searchInfo.getQuery());
        if(products.size()!=0){
            return products;
        }
        return naverApiService.callApi(searchInfo);
    }
}
