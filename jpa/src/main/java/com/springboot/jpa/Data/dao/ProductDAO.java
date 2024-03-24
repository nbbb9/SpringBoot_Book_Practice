package com.springboot.jpa.Data.dao;

import com.springboot.jpa.Data.entity.ProductEntity;

public interface ProductDAO {
    //기본적인 CRUD를 구현하기 위한 추상 메서드 정의
    ProductEntity insertProduct(ProductEntity productEntity);
    ProductEntity selectProduct(Long number);
    ProductEntity updateProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}//interface end
