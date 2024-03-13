package com.lianlianpay.openapi.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lianlianpay.openapi.client.LLianPayClient;
import com.lianlianpay.openapi.config.LLianPayConstant;
import com.lianlianpay.openapi.mch.v1.CardInfo;
import com.lianlianpay.openapi.mch.v1.creditpay.*;
import com.lianlianpay.openapi.utils.LLianPayDateUtils;

/**
 * 要先做签约绑卡，获取协议号，后进行分期支付
 */
public class StageApplyDemo {
    public static void main(String[] args) {
        String timestamp = LLianPayDateUtils.getTimestamp();
        StageApplyParams params = new StageApplyParams();
        params.setMch_id(LLianPayConstant.MCHID);
        params.setUser_id("");
        params.setTxn_seqno("LLianPay-Test-" + timestamp);
        params.setTxn_time(timestamp);
        params.setOrder_amount(4000.00);
        params.setNotify_url("ABC");
        params.setPay_type("CREDIT_STAGES_PAY");
        params.setUser_ip("127.0.0.1");
        params.setDiscount_mode("merchant");

        CardInfo card_info = new CardInfo();
        // 填写信用卡鉴权接口鉴权成后的协议号
        card_info.setAgree_no("");
        params.setCard_info(card_info);

        StageInfo stageInfo = new StageInfo();
        stageInfo.setStage_num("12");
        stageInfo.setSupport_bank_code("01050000");
        params.setStage_info(stageInfo);

        String url = "https://test.lianlianpay-inc.com/mpay-openapi/v1/creditpay/stage/apply";
        LLianPayClient lLianPayClient = new LLianPayClient();
        String resultJsonStr = lLianPayClient.sendRequest(url, JSON.toJSONString(params));
        StageApplyResult stageApplyResult = JSONObject.parseObject(resultJsonStr, StageApplyResult.class);

        //测试环境实际不下发短信，输入任意6位短信验证码
        String verifyCode = "123456";
        if (!"".equals(stageApplyResult.getToken())) {
            StageVerifyParams verifyParams = new StageVerifyParams();
            verifyParams.setMch_id(stageApplyResult.getMch_id());
            verifyParams.setTxn_seqno(stageApplyResult.getTxn_seqno());
            verifyParams.setVerify_code(verifyCode);
            verifyParams.setToken(stageApplyResult.getToken());

            String verifyUrl = "https://test.lianlianpay-inc.com/mpay-openapi/v1/creditpay/stage/verify";
            String resultJsonStr2 = new LLianPayClient().sendRequest(verifyUrl, JSON.toJSONString(verifyParams));
            StageVerifyResult stageVerifyResult = JSONObject.parseObject(resultJsonStr2, StageVerifyResult.class);
            System.out.println(resultJsonStr2);

        }
    }
}
