package com.springboot.test.Data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChangeProductNameDTO {
    private Long number;
    private String name;
}
