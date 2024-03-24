package com.springboot.test.Service;


import com.springboot.test.Data.dto.ProductDTO;
import com.springboot.test.Data.dto.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO getProduct(Long number);
    ProductResponseDTO saveProduct(ProductDTO productDTO);
    ProductResponseDTO changeProductName(Long number, String name)throws Exception;
    void deleteProduct(Long number) throws Exception;
}
