package com.example.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    public ProductCategory() {
    }
//    private Date createTime;
//    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
