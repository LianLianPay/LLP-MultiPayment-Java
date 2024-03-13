package com.lianlianpay.openapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.openapi.client.LLianPayClient;
import com.lianlianpay.openapi.config.LLianPayConstant;
import com.lianlianpay.openapi.mch.v1.creditpay.CreditPayQueryParams;

public class CreditPayQueryDemo {
    public static void main(String[] args) {

        CreditPayQueryParams params = new CreditPayQueryParams();
        params.setMch_id(LLianPayConstant.MCHID);
        params.setTxn_seqno("LLianPay-Test-20240313110530");

        String url = "https://test.lianlianpay-inc.com/query/v1/creditpay/pay/query";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        System.out.println(resultJsonStr);

    }
}
