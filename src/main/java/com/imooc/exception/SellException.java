package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * @Author: xyx
 * @Date: 2018-12-02 23:42
 * @Version 1.0
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }

    public SellException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
