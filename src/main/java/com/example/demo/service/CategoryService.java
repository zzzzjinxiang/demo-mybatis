package com.example.demo.service;

import com.example.demo.DAO.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findCategoryTypeIn(List<Integer> categoryType);
    ProductCategory save(ProductCategory productCategory);

}
