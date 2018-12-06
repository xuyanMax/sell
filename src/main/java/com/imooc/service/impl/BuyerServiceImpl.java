package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xyx
 * @Date: 2018-12-06 09:04
 * @Version 1.0
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {
        return checkOrderOwner(openId, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到该订单");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    public OrderDTO checkOrderOwner(String openId, String orderId) {

        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            log.error("【查询订单】orderDTO为空");
            return null;
        }

        //判断是否为自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openId)) {
            log.error("【查询订单】订单的openid不一致. openid={}, orderDTO={}", openId, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
