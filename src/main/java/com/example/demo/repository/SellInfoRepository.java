package com.example.demo.repository;

import com.example.demo.DAO.SellInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellInfoRepository extends JpaRepository<SellInfo,String > {

    SellInfo findByOpenid(String openid);
}
