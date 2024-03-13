package com.lianlianpay.openapi.mch.v1.isign;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class IsignVerifyParams {
    private String mch_id;
    private String user_id;
    private String token;
    private String verify_code;
}
