package com.lianlianpay.openapi.mch.v1.creditpay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StageApplyResult {
    private String ret_code;
    private String ret_msg;
    private String mch_id;
    private String txn_seqno;
    private String platform_txno;
    private String order_amount;
    private String token;
}
