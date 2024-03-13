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
        params.setUser_id("chunqiu-test-aabbcc");
        params.setTxn_seqno("LLianPayTest-MP-" + timestamp);
        params.setTxn_time(timestamp);

        CardInfo cardInfo = new CardInfo();
        cardInfo.setId_type("IDCARD");
        cardInfo.setId_no(LLianPayMultiPaymentSignature.getInstance().localEncrypt("430381200102077799"));
        cardInfo.setAcct_name(LLianPayMultiPaymentSignature.getInstance().localEncrypt("董思奇"));
        cardInfo.setBind_phone(LLianPayMultiPaymentSignature.getInstance().localEncrypt("13208002572"));
        cardInfo.setCard_no(LLianPayMultiPaymentSignature.getInstance().localEncrypt("6225766629655392"));
        params.setCard_info(cardInfo);

        String url = "https://test.lianlianpay-inc.com/mch/v1/isign/apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        IsignApplyResult isignApplyResult = JSONObject.parseObject(resultJsonStr, IsignApplyResult.class);
        System.out.println(isignApplyResult);
        String verifyCode = "123456";
        if (!"".equals(isignApplyResult.getToken())) {
            IsignVerifyParams verifyParams = new IsignVerifyParams();
            verifyParams.setToken(isignApplyResult.getToken());
            verifyParams.setMch_id(LLianPayConstant.MCHID);
            verifyParams.setUser_id("chunqiu-test-aabbcc");
            verifyParams.setVerify_code(verifyCode);

            String url1 = "https://test.lianlianpay-inc.com/mch/v1/isign/verify";
            LLianPayClient lLianPayClient1 = new LLianPayClient();
            String resultJsonStr1 = lLianPayClient1.sendRequest(url1, JSON.toJSONString(verifyParams));
            System.out.println(resultJsonStr1);
        }
    }
}
