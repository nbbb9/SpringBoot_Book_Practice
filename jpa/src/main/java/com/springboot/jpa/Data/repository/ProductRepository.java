package com.springboot.jpa.Data.repository;

import com.springboot.jpa.Data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    //해당 Repository로 JpaRepository의 다양한 메서드를 사용할 수 있다.

}
