package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @Author: xyx
 * @Date: 2018-12-06 09:01
 * @Version 1.0
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openId, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openId, String orderId);
}
