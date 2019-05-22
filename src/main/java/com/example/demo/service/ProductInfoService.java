package com.example.demo.service;

import com.example.demo.DAO.ProductInfo;
import com.example.demo.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    List<ProductInfo> findUpAll();
    ProductInfo findOne(String productId);
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    void increaseStock(List<CartDTO> cartDTOList);
    void decreaseStock(List<CartDTO> cartDTOList);
}
