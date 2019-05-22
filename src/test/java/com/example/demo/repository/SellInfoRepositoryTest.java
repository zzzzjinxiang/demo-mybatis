package com.example.demo.repository;

import com.example.demo.dataobject.SellInfo;
import com.example.demo.util.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellInfoRepositoryTest {

    @Autowired
    private SellInfoRepository sellInfoRepository;

    @Test
    public void save(){
        SellInfo sellInfo = new SellInfo();
        sellInfo.setOpenid("abc");
        sellInfo.setUsername("老王");
        sellInfo.setPassword("123456");
        sellInfo.setSellId(KeyUtil.getUniqueKey());

        SellInfo res = sellInfoRepository.save(sellInfo);
        assertNotNull(res);
    }

    @Test
    public void findByOpenid(){
        SellInfo res = sellInfoRepository.findByOpenid("abc");
        assertEquals("abc",res.getOpenid());
    }

}