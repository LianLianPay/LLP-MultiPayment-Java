package com.lianlianpay.openapi.demo;

import com.lianlianpay.openapi.security.LLianPayMultiPaymentSignature;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 异步通知Demo
 *
 * 异步通知是连连给商户接口上传的notify_url字段下发http post请求
 * 商户需要开发接受异步通知的服务
 */


/*@Slf4j
@RestController
public class NotifyControllerDemo {
    @Autowired
    NotifyService notifyService;

    @RequestMapping(method = RequestMethod.POST, value = "/notify")
    public String llianPayMessageNotify(HttpServletRequest request) {
        // 从请求头中获取签名值
        String signature = request.getHeader("Signature-Data");
        BufferedReader reader = null;
        try {
            // 从请求体中获取异步通知内容
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            log.info("[接收来自连连下发的异步通知] 签名值为：" + signature);
            log.info("[接收来自连连下发的异步通知] 签名源串为：" + stringBuilder.toString());

            // 先进行验签，确保通知是连连发送的
            if (LLianPayMultiPaymentSignature.getInstance().checkSign(stringBuilder.toString(), signature)) {
                // 验签通过，异步方式处理系统业务逻辑，不建议同步处理业务逻辑，可能导致连连这边等待响应超时
                log.info("验签通过！！！");

                // 返回Success，响应本次异步通知已经成功（正确响应连连异步通知的字符串）
                return "Success";
            } else {
                // 验签失败，进行预警。
                log.error("验签失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        // 没有其他意义，异步通知响应连连这边只认"Success"，返回非"Success"，连连会进行重发
        return "error";
    }
}*/
