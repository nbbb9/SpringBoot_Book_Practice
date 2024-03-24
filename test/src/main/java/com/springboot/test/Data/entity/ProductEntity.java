package com.springboot.test.Data.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity//책 p.108
@Table(name="product")
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString(exclude = "name")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}