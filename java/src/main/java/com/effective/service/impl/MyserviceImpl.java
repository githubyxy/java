package com.effective.service.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.kafka.common.protocol.types.Field.Str;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.effective.service.IMyService;

@Service
public class MyserviceImpl implements IMyService {
	
	private static final Logger logger = LoggerFactory.getLogger(MyserviceImpl.class);

	@Override
	public String apiImport(String customerName, String phoneNum, String partnerCode, Boolean test, String url) {
		// TODO Auto-generated method stub
		String mapping ="/openapi/task/batchImport/v1";
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("task_uuid", "c70e62427d6c4971bc7774e594e85b94");
		jsonObject.put("upload_mode", "ALL_SUCCESS");
//		jsonObject.put("test", test);
		
		JSONArray array = new JSONArray();
		JSONObject data = new JSONObject();
		data.put("customerName", customerName);
		data.put("phoneNum", phoneNum);
		array.add(data);
		jsonObject.put("data", array);
		
		String result = sendHttpPost(url + mapping, partnerCode, jsonObject);
		
		JSONObject resultData = (JSONObject) JSONObject.parseObject(result).get("data");
		Integer taskBatchUUid = resultData.getInteger("task_batch_uuid");
		checkTaskBatchUuid(taskBatchUUid);
		
		JSONArray successDataList = resultData.getJSONArray("success_data_list");
		String taskItemUuid = successDataList.getJSONObject(0).getString("task_item_uuid");
		checkTaskItemUuid(taskItemUuid);
		
		return result;
	}

	private void checkTaskItemUuid(String taskItemUuid) {
		// TODO Auto-generated method stub
		
	}

	private void checkTaskBatchUuid(Integer taskBatchUUid) {
		// TODO Auto-generated method stub
		
	}

	private String sendHttpPost(String url, String partnerCode, JSONObject jsonObject) {
        String result = null;
        CloseableHttpResponse response = null;
        
        CloseableHttpClient client = initClient();

        try {
            HttpEntity entity = new StringEntity(JSON.toJSONString(jsonObject, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect}), Charset.forName("UTF-8"));
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.addHeader("x-access-key", partnerCode);
            httpPost.addHeader("x-secret-key", "ba1c4d40074b4160a44233b709fe268c");
            httpPost.setEntity(entity);
            response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (200 != statusCode) {
                logger.error( "请求URL {} 时返回的statusCode为 {}", Arrays.asList(url, statusCode), "httpPostJson");
            }

            result = EntityUtils.toString(response.getEntity(), "UTF-8");
            logger.info( "服务端返回的response: {}", Arrays.asList(result), "httpPostJson");
            EntityUtils.consume(response.getEntity());
        } catch (IOException var16) {
            logger.error("请求URL{}时发生错误", url, var16);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException var15) {
                    logger.error( "关闭响应流出现错误: {} ", Arrays.asList(var15.getMessage(), var15), "httpPostJson");
                }
            }

        }

        return result;
	}

	private CloseableHttpClient initClient() {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setDefaultMaxPerRoute(30);
        cm.setMaxTotal(300);
        RequestConfig config = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
        return HttpClients.custom().setSSLSocketFactory(SSLConnectionSocketFactory.getSocketFactory()).setDefaultRequestConfig(config).setConnectionManager(cm).build();
	}

	@Override
	public String downloadVoiceRecord(String fileId, String partnerCode, String url) {
		// TODO Auto-generated method stub
		
		String mapping ="/hertz/voice/record/v1";
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileId", fileId);
		
		long currentTimeMillis = System.currentTimeMillis();
		String result = sendHttpPost(url + mapping, partnerCode, jsonObject);
		System.out.println("耗时：" + (System.currentTimeMillis() - currentTimeMillis));
		
		return result;
	}

	@Override
	public String getItem(Integer taskBatchUuid, String taskItemUuid, String url) {
		// TODO Auto-generated method stub
		
		
		return null;
		
	}

//    @Resource
//    private CustomerMapper customerMapper;

//    @Override
//    public Customer getCustomer() {
//        Customer customer = customerMapper.selectByPrimaryKey(1);
//        return customer;
//    }

}
