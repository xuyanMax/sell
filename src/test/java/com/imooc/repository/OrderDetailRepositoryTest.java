package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: xyx
 * @Date: 2018-11-30 01:02
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456811");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductIcon("http://xyxxx.jpg");
        orderDetail.setProductId("11111114");
        orderDetail.setProductName("龙虾烧烤");
        orderDetail.setProductPrice(new BigDecimal(288.2));
        orderDetail.setProductQuantity(34);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderIdTest() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("11111112");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}