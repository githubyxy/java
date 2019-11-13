package com.effective.service;

public interface IMyService {

	String apiImport(String customerName, String phoneNum, String partnerCode, Boolean test, String url);

	String downloadVoiceRecord(String fileId, String partnerCode, String url);

	String getItem(Integer taskBatchUuid, String taskItemUuid, String url);

}
