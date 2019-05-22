package com.example.demo.service.Impl;

import com.example.demo.DAO.ProductCategory;
import com.example.demo.DAO.daoStock.ProductCategoryDao;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Autowired
    private ProductCategoryDao dao;//mybatis操作

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory productCategory = categoryRepository.findById(categoryId).orElse(null);
        return productCategory;
    }

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @Override
    public List<ProductCategory> findCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> categoryList = categoryRepository.findByCategoryTypeIn(categoryTypeList);
        return categoryList;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }
}
