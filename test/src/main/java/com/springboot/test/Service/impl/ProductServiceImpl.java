package com.springboot.test.Service.impl;


import com.springboot.test.Data.dto.ProductDTO;
import com.springboot.test.Data.dto.ProductResponseDTO;
import com.springboot.test.Data.entity.ProductEntity;
import com.springboot.test.Data.repository.ProductRepository;
import com.springboot.test.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override//-------------조회------------------//
    public ProductResponseDTO getProduct(Long number) {
        LOGGER.info("[getProduct] input number : {}", number);
        ProductEntity productEntity = productRepository.findById(number).get();

        LOGGER.info("[getProduct] product number : {}, name : {}", productEntity.getNumber(), productEntity.getName());

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        //DTO에 담는 과정
        productResponseDTO.setNumber(productEntity.getNumber());
        productResponseDTO.setName(productEntity.getName());
        productResponseDTO.setPrice(productEntity.getPrice());
        productResponseDTO.setStock(productEntity.getStock());
        //DTO 객체를 반환
        return productResponseDTO;
    }
    @Override//-------------저장-------------------//
    public ProductResponseDTO saveProduct(ProductDTO productDTO) {
        LOGGER.info("[saveProduct] productDTO : {}", productDTO.toString());
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setStock(productDTO.getStock());

        ProductEntity savedProduct = productRepository.save(productEntity);
        LOGGER.info("[saveProduct] saveProduct : {}", savedProduct);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        //DTO에 담는 과정
        productResponseDTO.setNumber(savedProduct.getNumber());
        productResponseDTO.setName(savedProduct.getName());
        productResponseDTO.setPrice(savedProduct.getPrice());
        productResponseDTO.setStock(savedProduct.getStock());
        //DTO 객체를 반환
        return productResponseDTO;
    }
    @Override//-----------------업데이트------------------//
    public ProductResponseDTO changeProductName(Long number, String name){
        ProductEntity foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        ProductEntity changedProduct = productRepository.save(foundProduct);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        //DTO에 담는 과정
        productResponseDTO.setNumber(changedProduct.getNumber());
        productResponseDTO.setName(changedProduct.getName());
        productResponseDTO.setPrice(changedProduct.getPrice());
        productResponseDTO.setStock(changedProduct.getStock());
        //DTO 객체를 반환
        return productResponseDTO;
    }
    @Override//-----------------삭제------------------//
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
    }

}//class end
