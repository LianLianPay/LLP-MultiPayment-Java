package com.lianlianpay.openapi.mch.v1.creditpay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class DeviceInfo {
    // 设备标识码
    private String device_id;
    /*
    设备类型，扫码枪：SMQ
    收款盒子：BOX
    POS机：POS
    个人电脑：PC
    平板电脑：PAD
    手机：PHONE
     */
    private String device_type;
    // 设备IP
    private String device_ip;
    // 设备GPS
    private String device_gps;
    // 设备IMEI
    private String device_imei;
    // 设备IMSI
    private String device_imsi;
    // 设备ICCID
    private String device_iccid;
    // 设备WIFIMAC
    private String device_wifimac;
    // 设备MAC
    private String device_mac;
}
