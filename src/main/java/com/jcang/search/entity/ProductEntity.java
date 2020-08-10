package com.jcang.search.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Indexed(index = "product")
@Table(name = "product")
public class ProductEntity {

    @Id
    private String id;

    @Field
    private String name;

    private BigDecimal pricePerUom;

    private Integer quantity;

    private String uom;

    private int manufacturedYear;

    private Instant createdOn;

    public ProductEntity() {
        this.id = UUID.randomUUID().toString();
    }

}