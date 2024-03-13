package com.lianlianpay.openapi.mch.v1.isign;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class IsignApplyResult {
    private String ret_code;
    private String ret_msg;
    private String mch_id;
    private String txn_seqno;
    private String token;
}
