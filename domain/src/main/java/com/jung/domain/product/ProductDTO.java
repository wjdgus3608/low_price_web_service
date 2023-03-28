package com.jung.domain.product;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class ProductDTO {
    int responseCode;
    String responseMessage;

    public static List<Product> jsonToProductList(String json) {
        List<Product> list = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        log.log(Level.ALL,json);
        try {
            obj = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            log.log(Level.ALL,e);
            e.printStackTrace();
        }
        JSONArray jsonArray = (JSONArray) obj.get("items");
        for(Object cur:jsonArray){
            JSONObject object = (JSONObject) cur;
            Product product = Product.builder()
                    .productId((long)object.get("productId"))
                    .productName((String)object.get("title"))
                    .productLink((String)object.get("link"))
                    .productImg((String)object.get("image"))
                    .lPrice((long)object.get("lprice"))
                    .maker((String)object.get("maker"))
                    .brand((String)object.get("brand"))
                    .build();
            list.add(product);
        }
        return list;
    }
}
