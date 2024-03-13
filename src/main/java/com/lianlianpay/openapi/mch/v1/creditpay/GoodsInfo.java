package com.lianlianpay.openapi.mch.v1.creditpay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class GoodsInfo {
    // 商品编码
    private String goods_id;
    // 商品名称
    private String goods_name;
    // 商品类目
    private String goods_category;
    // 商品数量
    private Integer goods_quantity;
    // 商品单价
    private Double goods_price;
    // 商品描述
    private String goods_body;
}
