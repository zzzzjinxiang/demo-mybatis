package com.example.demo.service.Impl;

import com.example.demo.enums.SellException;
import com.example.demo.service.RedisLock;
import com.example.demo.service.SecKillService;
import com.example.demo.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SecKillServiceImpl implements SecKillService {

    private static final int TIMEOUT = 10*1000;

    @Autowired
    private RedisLock redisLock;


    static Map<String,Integer> products;
    static Map<String,Integer> stock;
    static Map<String,String> orders;
    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123",1000);
        stock.put("123",1000);
    }
    private String queryMap(String productId){
        return "特殊活动"
                + products.get(productId)
                + "还剩" + stock.get(productId)
                + "- 活跃量已达"
                + orders.size();
    }

    @Override
    public String querySecKillProductInfo(String productId) {
        return this.queryMap(productId);
    }

    @Override
    public void orderProductMockDiffUser(String productId)
    {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if(!redisLock.lock(productId,String.valueOf(time))){
            throw new SellException(101,"访问量过大请稍后再试");
        }

        int stockNum = stock.get(productId);
        if(stockNum==0){
            throw new SellException(100,"结束");
        }else{
            orders.put(KeyUtil.getUniqueKey(),productId);
            stockNum = stockNum-1;
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }

        //解锁
        redisLock.unlock(productId,String.valueOf(time));
    }
}
