package com.example.demo.DAO.mapper;

import com.example.demo.DAO.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;
    @Test
    public void insertByMap() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("categoryName","外卖ge");
        map.put("categoryType",200);
        int result = mapper.insertByMap(map);
        assertNotEquals(0,result);
    }
    @Test
    public void insertByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("新食堂一楼");
        productCategory.setCategoryType(4);
        int result = mapper.insertByObject(productCategory);
        assertEquals(1,result);
    }
    @Test
    public void findByCategoryType(){
        ProductCategory productCategory = mapper.findByCategoryType(4);
        assertNotNull(productCategory);
    }
    @Test
    public void findByCategoryName(){
        List<ProductCategory> productCategory = mapper.findByCategoryName("test1");
        assertNotEquals(0,productCategory.size());
    }

    @Test
    public void updateByCategoryType(){
        int res = mapper.updateByCategoryType("老食堂二楼",3);
        assertNotEquals(0,res);
    }

    @Test
    public void updateByCategoryName(){
        int res = mapper.updateByCategoryName("外卖ge",5);
        assertNotEquals(0,res);
    }

    @Test
    public void updateByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("新食堂二楼");
        productCategory.setCategoryType(2);
        int res = mapper.updateByObject(productCategory);
        assertNotEquals(0,res);
    }

    @Test
    public void deleteByCategoryType(){
        int res = mapper.deleteByCategoryType(1);
        assertNotEquals(0,res);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory res = mapper.selectByCategoryType(3);
        assertNotNull(res);
    }
}