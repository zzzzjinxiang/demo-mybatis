package com.example.demo.DAO.daoStock;

import com.example.demo.DAO.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ProductCategoryDao {
    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String,Object> map){
        return mapper.insertByMap(map);
    }
}
