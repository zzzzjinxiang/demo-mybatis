package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface SecKillService {

    String querySecKillProductInfo(String productId);
    void orderProductMockDiffUser(String productId);
}
