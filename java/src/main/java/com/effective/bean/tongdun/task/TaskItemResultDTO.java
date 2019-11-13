package com.effective.bean.tongdun.task;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author yuxiaoyu
 *
 */
public class TaskItemResultDTO implements Serializable {

    private static final long serialVersionUID = 2938452128877553573L;

    @JSONField(name = "task_name")
    private String task_name;

    @JSONField(name = "task_uuid")
    private String task_uuid;


    @JSONField(name = "task_batch_uuid")
    private Integer task_batch_uuid;

    @JSONField(name = "task_item_uuid")
    private String task_item_uuid;

    @JSONField(name = "task_item_completed")
    private Boolean task_ttem_completed;

    @JSONField(name = "tag_code")
    private String tag_code;

    @JSONField(name = "tag_desc")
    private String tag_desc;

    @JSONField(name = "voice_record")
    private List<VoiceResponseDTO> voice_record;

    @JSONField(name = "sms_record")
    private SmsResponseDTO sms_record;

    @JSONField(name = "input_params")
    private JSONObject input_params;

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_uuid() {
		return task_uuid;
	}

	public void setTask_uuid(String task_uuid) {
		this.task_uuid = task_uuid;
	}

	public Integer getTask_batch_uuid() {
		return task_batch_uuid;
	}

	public void setTask_batch_uuid(Integer task_batch_uuid) {
		this.task_batch_uuid = task_batch_uuid;
	}

	public String getTask_item_uuid() {
		return task_item_uuid;
	}

	public void setTask_item_uuid(String task_item_uuid) {
		this.task_item_uuid = task_item_uuid;
	}

	public Boolean getTask_ttem_completed() {
		return task_ttem_completed;
	}

	public void setTask_ttem_completed(Boolean task_ttem_completed) {
		this.task_ttem_completed = task_ttem_completed;
	}

	public String getTag_code() {
		return tag_code;
	}

	public void setTag_code(String tag_code) {
		this.tag_code = tag_code;
	}

	public String getTag_desc() {
		return tag_desc;
	}

	public void setTag_desc(String tag_desc) {
		this.tag_desc = tag_desc;
	}

	public List<VoiceResponseDTO> getVoice_record() {
		return voice_record;
	}

	public void setVoice_record(List<VoiceResponseDTO> voice_record) {
		this.voice_record = voice_record;
	}

	public SmsResponseDTO getSms_record() {
		return sms_record;
	}

	public void setSms_record(SmsResponseDTO sms_record) {
		this.sms_record = sms_record;
	}

	public JSONObject getInput_params() {
		return input_params;
	}

	public void setInput_params(JSONObject input_params) {
		this.input_params = input_params;
	}

    
}
