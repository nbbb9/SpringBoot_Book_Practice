package com.springboot.test.Controller;

import com.springboot.test.Data.dto.ChangeProductNameDTO;
import com.springboot.test.Data.dto.ProductDTO;
import com.springboot.test.Data.dto.ProductResponseDTO;
import com.springboot.test.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService  productService){
        this.productService = productService;
    }//생성자를 사용한 의존성 주입(DI)

    @GetMapping("/get")//---------검색-----------//
    public ResponseEntity<ProductResponseDTO> getProduct(Long number){
        ProductResponseDTO productResponseDTO = productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @PostMapping("/post")//---------생성-----------//
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductResponseDTO productResponseDTO = productService.saveProduct(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @PutMapping("/put")//---------업데이트-----------//
    public ResponseEntity<ProductResponseDTO> changeProductName(@RequestBody ChangeProductNameDTO changeProductNameDTO)throws Exception{
        ProductResponseDTO productResponseDTO = productService.changeProductName(changeProductNameDTO.getNumber(), changeProductNameDTO.getName());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @DeleteMapping("/delete")//---------삭제-----------//
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}//class end
