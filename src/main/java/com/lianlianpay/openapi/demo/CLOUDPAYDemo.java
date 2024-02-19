package com.lianlianpay.openapi.demo;

import com.alibaba.fastjson.JSON;
import com.lianlianpay.openapi.client.LLianPayClient;
import com.lianlianpay.openapi.config.LLianPayConstant;
import com.lianlianpay.openapi.mch.v1.*;
import com.lianlianpay.openapi.utils.LLianPayDateUtils;

/**
 * 云闪付APP Demo
 */
public class CLOUDPAYDemo {
    public static void main(String[] args) {
        MultiPayParams params = new MultiPayParams();
        String timestamp = LLianPayDateUtils.getTimestamp();
        params.setMch_id(LLianPayConstant.MCHID);
        params.setUser_id("LLianPay-MP-Test-12345");
        params.setBusi_type("100001");
        params.setTxn_seqno("LLianPay-MP-" + timestamp);
        params.setTxn_time(timestamp);
        params.setOrder_amount(0.01);
        params.setNotify_url("https://test.lianlianpay/notify");
        params.setExtend_info("");

        PayMethodInfo payMethodInfo = new PayMethodInfo();
        payMethodInfo.setPay_type("CLOUDPAY_APP");
        payMethodInfo.setAmount("0.01");
        params.setPay_method_infos(new PayMethodInfo[]{payMethodInfo});

        PayeeInfo payeeInfo = new PayeeInfo();
        payeeInfo.setPayee_uid(LLianPayConstant.MCHID);
        payeeInfo.setPayee_type("MCH");
        payeeInfo.setPayee_accttype("MCHOWN");
        payeeInfo.setPayee_amount("0.01");
        params.setPayee_infos(new PayeeInfo[]{payeeInfo});

        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoods_id("1234");
        params.setGoods_info(new GoodsInfo[]{goodsInfo});

        RiskInfo riskInfo = new RiskInfo();
        riskInfo.setIp_addr("60.191.76.226");
        params.setRisk_info(riskInfo);

        String url = "https://openapi.lianlianpay.com/mch/v1/ipay/createpay";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        MultiPayResult createPayResult = JSON.parseObject(resultJsonStr, MultiPayResult.class);
        System.out.println(createPayResult);
    }
}
