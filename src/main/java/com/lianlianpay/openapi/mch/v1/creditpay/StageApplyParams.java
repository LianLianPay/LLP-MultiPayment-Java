package com.lianlianpay.openapi.mch.v1.creditpay;

import com.lianlianpay.openapi.mch.v1.CardInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StageApplyParams {
    private String mch_id;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    private Double order_amount;
    private String order_info;
    private String notify_url;
    private String pay_expire;
    private String pay_type;
    private String user_ip;
    private String discount_mode;
    private StageInfo stage_info;
    private GoodsInfo goods_info;
    private DeviceInfo device_info;
    private StoreInfo store_info;
    private ShareInfo share_info;
    private CardInfo card_info;
    private String risk_info;
    private String extend_info;
}
