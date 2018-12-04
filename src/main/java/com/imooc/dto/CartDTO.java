package com.imooc.dto;

import lombok.Data;

/**
 * @Author: xyx
 * @Date: 2018-12-04 07:21
 * @Version 1.0
 */
@Data
public class CartDTO {
    /** 商品Id. */
    private String productId;

    /** 数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
