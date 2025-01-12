package com.springboot.jpa.Data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
    private String name;
    private int price;
    private int stock;
}
