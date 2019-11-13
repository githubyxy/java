package com.effective.bean.tongdun.task;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 
 * @author yuxiaoyu
 *
 */
public class SmsResponseDTO implements Serializable {

    private static final long serialVersionUID = 6309341590961531616L;

    @JSONField(name = "customer_phone")
    private String customer_phone;

    @JSONField(name = "start_time")
    private String start_time;

    @JSONField(name = "sms_content")
    private String sms_content;

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getSms_content() {
		return sms_content;
	}

	public void setSms_content(String sms_content) {
		this.sms_content = sms_content;
	}

    
}
