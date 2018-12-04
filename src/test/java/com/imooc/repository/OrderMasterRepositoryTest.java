package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import com.imooc.enums.OrderStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: xyx
 * @Date: 2018-11-30 00:41
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private String openid = "iasasdasdkj214nbsad";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345670");
        orderMaster.setBuyerName("xuyan");
        orderMaster.setBuyerOpenid("iasasdasdkj214nbsad");
        orderMaster.setBuyerPhone("15154520349");
        orderMaster.setBuyerAddress("imooc.com");
        orderMaster.setOrderAmount(new BigDecimal(9.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());

        orderMaster = repository.save(orderMaster);
        Assert.assertEquals("xuyan", orderMaster.getBuyerName());
    }

    @Test
    public void findByBuyerOpenidTest() {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderMaster> result = repository.findByBuyerOpenid(openid, request);
        System.out.println(result.getTotalElements());

    }
}