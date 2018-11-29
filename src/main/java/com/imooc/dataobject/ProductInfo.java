package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author: xyx
 * @Date: 2018-11-29 13:29
 * @Version 1.0
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private String productDescription;

    private Integer productStock;

    private String productIcon;

    /**
     * 状态 0正常 1下架
     */
    private Integer productStatus;

    private Integer categoryType;


}
