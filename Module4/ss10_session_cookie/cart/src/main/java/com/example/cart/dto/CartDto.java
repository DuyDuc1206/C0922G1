package com.example.cart.dto;

import com.example.cart.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> products) {
        this.productMap = products;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.productMap = products;
    }


    private boolean checkItemInCart(ProductDto productDto) {
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId().equals(productDto.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto productDto) {
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId().equals(productDto.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(ProductDto productDto) {
        if (!checkItemInCart(productDto)){
            productMap.put(productDto,1);
        } else {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
            Integer newQuantity = itemEntry.getValue() + 1;
            productMap.replace(itemEntry.getKey(),newQuantity);
        }
    }


}

