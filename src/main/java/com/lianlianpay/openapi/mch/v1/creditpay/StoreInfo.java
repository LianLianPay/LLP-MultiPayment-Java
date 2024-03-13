package com.lianlianpay.openapi.mch.v1.creditpay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StoreInfo {
    // 门店id
    private String store_id;
    // 门店名称
    private String store_name;
    // 行政区编码
    private String area_code;
    // 门店地址
    private String store_addr;
    // 收银员编号
    private String cashier_no;
}
