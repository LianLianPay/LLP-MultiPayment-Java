package com.lianlianpay.openapi.mch.v1.creditpay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StageVerifyParams {
    private String mch_id;
    private String txn_seqno;
    private String verify_code;
    private String token;
}
