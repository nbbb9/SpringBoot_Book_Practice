package com.springboot.jpa.Service.impl;

import com.springboot.jpa.Data.dao.ProductDAO;
import com.springboot.jpa.Data.dto.ProductDTO;
import com.springboot.jpa.Data.dto.ProductResponseDTO;
import com.springboot.jpa.Data.entity.ProductEntity;
import com.springboot.jpa.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }
    @Override//--------------조회------------------//
    public ProductResponseDTO getProduct(Long number) {
        ProductEntity productEntity = productDAO.selectProduct(number);
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
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setStock(productDTO.getStock());
        productEntity.setCreatedAt(LocalDateTime.now());
        productEntity.setUpdatedAt(LocalDateTime.now());
        //DAO는 Interface이므로 추상메서드만 구현되어 있지만, 다형성으로 인해 DAOImpl에 구현된 메서드를 불러올 수 있다.
        ProductEntity savedProduct = productDAO.insertProduct(productEntity);
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
    public ProductResponseDTO changeProductName(Long number, String name) throws Exception {
        ProductEntity changedProduct = productDAO.updateProductName(number, name);
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
        productDAO.deleteProduct(number);
    }
}//class end
