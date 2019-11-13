package com.effective.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.effective.bean.tongdun.task.TaskItemResultDTO;
import com.effective.service.IMyService;
import com.effective.service.transaction.IKvService;
import com.effective.service.transaction.IPermissionTransactionService;
import com.effective.service.transaction.KvTestServiceImpl;

import scala.util.Sorting;

@Controller
@RequestMapping(value = "/")
public class MyController {

    @Resource
    private IKvService kvService;
    @Resource
    private KvTestServiceImpl kvTestServiceImpl;
    @Resource(name =  "permissionTransactionService")
	private IPermissionTransactionService permissionTransactionService;
    
    @Resource
    private IMyService myService;

    @RequestMapping(value = "imagePage")
    public String gotoPage(){
//    		permissionTransactionService.loadPermissionDefinitions();
        return "image";
    }
    
    @RequestMapping(value = "/kvInsert", method = RequestMethod.GET)
    public String kvInsert(HttpServletRequest request) {
        kvTestServiceImpl.insert();
        return "kv";
    }

    @RequestMapping(value = "/gotoKv", method = RequestMethod.GET)
    public String gotoPage(HttpServletRequest request) {
        kvService.insert();
        return "kv";
    }

    @RequestMapping(value = "/session/op", method = RequestMethod.GET)
    public String op(HttpServletRequest request) throws Exception {

        kvService.insert2();

        return "kv";
    }
    
    @RequestMapping(value = "/apiImport", method = RequestMethod.GET)
    @ResponseBody
    public String apiImport(String customerName, String phoneNum, String partnerCode, Boolean test, String url) {
    		return myService.apiImport(customerName, phoneNum, partnerCode, test, url);
    }
    
    @RequestMapping(value = "/getItem", method = RequestMethod.GET)
    @ResponseBody
    public String getItem(Integer taskBatchUuid, String taskItemUuid, String url) {
    		return myService.getItem(taskBatchUuid, taskItemUuid, url);
    }
    
    @RequestMapping(value = "/downloadVoiceRecord", method = RequestMethod.GET)
    @ResponseBody
    public String downloadVoiceRecord(String fileId, String partnerCode, String url) {
    		return myService.downloadVoiceRecord(fileId, partnerCode, url);
    }
    
    @RequestMapping(value = "/tongdun/callback", method = RequestMethod.POST)
    @ResponseBody
    public String callBack(HttpServletRequest request, @RequestBody TaskItemResultDTO result) {
    		
    		System.out.println("callback:" + JSON.toJSONString(result)); 
    		JSONObject object = new JSONObject();
    		object.put("success", true);
    		return object.toJSONString();
    }

}
