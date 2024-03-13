package com.lianlianpay.openapi.mch.v1.creditpay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ShareInfo {
    private ShareList[] share_list;
}
