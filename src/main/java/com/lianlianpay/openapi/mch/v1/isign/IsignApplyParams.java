package com.lianlianpay.openapi.mch.v1.isign;

import com.lianlianpay.openapi.mch.v1.CardInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class IsignApplyParams {
    private String mch_id;
    private String user_id;
    private String txn_seqno;
    private String txn_time;
    private String pay_type;
    private String extend_info;
    private CardInfo card_info;
}
