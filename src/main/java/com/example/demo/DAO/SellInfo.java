package com.example.demo.DAO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class SellInfo {

    @Id
    private String sellId;

    private String username;

    private String password;

    private String openid;


    private Date createTime;
    private Date updateTime;
}
