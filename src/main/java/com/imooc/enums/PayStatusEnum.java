package com.imooc.enums;

import lombok.Getter;

/**
 * @Author: xyx
 * @Date: 2018-11-30 00:27
 * @Version 1.0
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "未支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
