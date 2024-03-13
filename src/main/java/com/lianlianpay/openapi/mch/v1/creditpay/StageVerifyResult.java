package com.lianlianpay.openapi.mch.v1.creditpay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StageVerifyResult {
    private String ret_code;
    private String ret_msg;
    private String mch_id;
    private String txn_status;
    private String txn_seqno;
    private String platform_txno;
    private String order_amount;
    private String account_date;
    private String order_info;
    private String pay_type;
    private String agree_no;
    private String stage_num;
}
