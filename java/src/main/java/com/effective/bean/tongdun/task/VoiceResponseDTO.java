package com.effective.bean.tongdun.task;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author yuxiaoyu
 *
 */
public class VoiceResponseDTO implements Serializable {

    private static final long serialVersionUID = -1925952976156596919L;

    @JSONField(name = "customer_phone")
    private String customer_phone;

    @JSONField(name = "start_time")
    private String start_time;

    @JSONField(name = "call_type")
    private String call_type;

    @JSONField(name = "call_status")
    private String call_status;

    @JSONField(name = "duration")
    private Integer duration;

    @JSONField(name = "tag_list")
    private List<String> tag_list;

    @JSONField(name = "file_id")
    private String file_id;

    @JSONField(name = "interactions")
    private List<InteractionDTO> interactions;

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

	public String getCall_type() {
		return call_type;
	}

	public void setCall_type(String call_type) {
		this.call_type = call_type;
	}

	public String getCall_status() {
		return call_status;
	}

	public void setCall_status(String call_status) {
		this.call_status = call_status;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public List<String> getTag_list() {
		return tag_list;
	}

	public void setTag_list(List<String> tag_list) {
		this.tag_list = tag_list;
	}

	public String getFile_id() {
		return file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public List<InteractionDTO> getInteractions() {
		return interactions;
	}

	public void setInteractions(List<InteractionDTO> interactions) {
		this.interactions = interactions;
	}

   
}

