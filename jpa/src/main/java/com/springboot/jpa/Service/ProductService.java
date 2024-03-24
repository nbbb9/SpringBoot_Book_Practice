package com.springboot.jpa.Service;

import com.springboot.jpa.Data.dto.ProductDTO;
import com.springboot.jpa.Data.dto.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO getProduct(Long number);
    ProductResponseDTO saveProduct(ProductDTO productDTO);
    ProductResponseDTO changeProductName(Long number, String name)throws Exception;
    void deleteProduct(Long number) throws Exception;
}
