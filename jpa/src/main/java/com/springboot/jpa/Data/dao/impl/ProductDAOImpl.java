package com.springboot.jpa.Data.dao.impl;

import com.springboot.jpa.Data.dao.ProductDAO;
import com.springboot.jpa.Data.entity.ProductEntity;
import com.springboot.jpa.Data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {
    private final ProductRepository productRepository;//데이터베이스에 접근하기 위해 Repositoryinterface를 사용해 의존성을 주입받는다.

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {//생성자를 통한 의존성 주입
        this.productRepository = productRepository;
    }
    @Override
    public ProductEntity insertProduct(ProductEntity productEntity) {
        ProductEntity saveProduct = productRepository.save(productEntity);
        return saveProduct;
    }
    @Override
    public ProductEntity selectProduct(Long number) {
        ProductEntity selectedProduct = productRepository.getById(number);
        //Repository에서 단건 조회를 위한 기본 메서드로는 getById() & findbyId() 두가지가 있다._p.119
        return selectedProduct;
    }

    @Override
    public ProductEntity updateProductName(Long number, String name) throws Exception {
        Optional<ProductEntity> selectedProduct = productRepository.findById(number);
        ProductEntity updatedProduct;
        if(selectedProduct.isPresent()){
            ProductEntity productEntity = selectedProduct.get();
            productEntity.setName(name);
            productEntity.setUpdatedAt(LocalDateTime.now());
            updatedProduct = productRepository.save(productEntity);
        }else{
            throw new Exception();
        }
        return updatedProduct;
    }
    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<ProductEntity> selectedProduct = productRepository.findById(number);
        if(selectedProduct.isPresent()){
            ProductEntity productEntity = selectedProduct.get();
            productRepository.delete(productEntity);
        }else{
          throw new Exception();
        }
    }
}//class end
