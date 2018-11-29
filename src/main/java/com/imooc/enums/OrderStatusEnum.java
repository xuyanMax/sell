package com.imooc.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Author: xyx
 * @Date: 2018-11-30 00:23
 * @Version 1.0
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
