package com.lianlianpay.openapi.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lianlianpay.openapi.client.LLianPayClient;
import com.lianlianpay.openapi.config.LLianPayConstant;
import com.lianlianpay.openapi.mch.v1.CardInfo;
import com.lianlianpay.openapi.mch.v1.isign.IsignApplyParams;
import com.lianlianpay.openapi.mch.v1.isign.IsignApplyResult;
import com.lianlianpay.openapi.mch.v1.isign.IsignVerifyParams;
import com.lianlianpay.openapi.security.LLianPayMultiPaymentSignature;
import com.lianlianpay.openapi.utils.LLianPayDateUtils;

public class IsignApplyDemo {
    public static void main(String[] args) {
        String timestamp = LLianPayDateUtils.getTimestamp();
        IsignApplyParams params = new IsignApplyParams();
        params.setMch_id(LLianPayConstant.MCHID);
        params.setUser_id("");
        params.setTxn_seqno("LLianPayTest-MP-" + timestamp);
        params.setTxn_time(timestamp);

        // 输入银行卡四要素信息
        CardInfo cardInfo = new CardInfo();
        cardInfo.setId_type("IDCARD");
        cardInfo.setId_no(LLianPayMultiPaymentSignature.getInstance().localEncrypt(""));
        cardInfo.setAcct_name(LLianPayMultiPaymentSignature.getInstance().localEncrypt(""));
        cardInfo.setBind_phone(LLianPayMultiPaymentSignature.getInstance().localEncrypt(""));
        cardInfo.setCard_no(LLianPayMultiPaymentSignature.getInstance().localEncrypt(""));
        params.setCard_info(cardInfo);

        String url = "https://test.lianlianpay-inc.com/mch/v1/isign/apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        IsignApplyResult isignApplyResult = JSONObject.parseObject(resultJsonStr, IsignApplyResult.class);
        System.out.println(isignApplyResult);

        //测试环境实际不下发短信，输入任意6位短信验证码
        String verifyCode = "123456";
        if (!"".equals(isignApplyResult.getToken())) {
            IsignVerifyParams verifyParams = new IsignVerifyParams();
            verifyParams.setToken(isignApplyResult.getToken());
            verifyParams.setMch_id(LLianPayConstant.MCHID);
            verifyParams.setUser_id("");
            verifyParams.setVerify_code(verifyCode);

            String url1 = "https://test.lianlianpay-inc.com/mch/v1/isign/verify";
            LLianPayClient lLianPayClient1 = new LLianPayClient();
            String resultJsonStr1 = lLianPayClient1.sendRequest(url1, JSON.toJSONString(verifyParams));
            System.out.println(resultJsonStr1);
        }
    }
}
