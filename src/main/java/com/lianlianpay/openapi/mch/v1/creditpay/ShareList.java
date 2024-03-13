package com.lianlianpay.openapi.mch.v1.creditpay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ShareList {
    private String share_uid;
    private String share_memo;
    private Double share_amount;
}
