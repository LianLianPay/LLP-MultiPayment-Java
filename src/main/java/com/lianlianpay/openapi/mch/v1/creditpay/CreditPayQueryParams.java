package com.lianlianpay.openapi.mch.v1.creditpay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CreditPayQueryParams {
    private String mch_id;
    private String txn_seqno;
}
