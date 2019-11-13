package com.effective.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private CloseableHttpClient client = null;

    public static final HttpClientUtil getInstance() {
        return HttpClientUtil.InstanceHolder.instance;
    }

    public HttpClientUtil() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setDefaultMaxPerRoute(30);
        cm.setMaxTotal(300);
        RequestConfig config = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
        this.client = HttpClients.custom().setSSLSocketFactory(SSLConnectionSocketFactory.getSocketFactory()).setDefaultRequestConfig(config).setConnectionManager(cm).build();
    }

    public String get(String url, NameValuePair[] nameValuePairs) {
        return this.get(url, Arrays.asList(nameValuePairs));
    }

    public String get(String url, List<NameValuePair> nameValuePairs) {
        StringBuffer buf = new StringBuffer();

        for(int i = 0; i < nameValuePairs.size(); ++i) {
            buf.append(i == 0 ? "?" : "&");

            try {
                buf.append(((NameValuePair)nameValuePairs.get(i)).getName()).append("=").append(URLEncoder.encode(((NameValuePair)nameValuePairs.get(i)).getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException var6) {
                logger.error( "URL {} 编码时发生错误", Arrays.asList(url, var6), "urlEncode");
                return null;
            }
        }

        return this.getString(url + buf.toString());
    }

    private String getString(String url) {
        logger.info( "请求的url: {}", Arrays.asList(url), "httpGet");
        String result = null;
        CloseableHttpResponse response = null;

        try {
            HttpGet getMethod = new HttpGet(url);
            getMethod.setHeader("Content-Encoding", "UTF-8");
            response = this.client.execute(getMethod);
            int statusCode = response.getStatusLine().getStatusCode();
            if (200 != statusCode) {
                logger.error( "请求URL {} 时返回的statusCode为 {}", Arrays.asList(url, statusCode), "httpGet");
            }

            result = EntityUtils.toString(response.getEntity());
            logger.info( "服务端返回的response: {}", Arrays.asList(result), "httpGet");
            EntityUtils.consume(response.getEntity());
        } catch (IOException var14) {
            logger.error( "请求URL {} 时发生错误", Arrays.asList(url, var14), "httpGet");
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException var13) {
                    logger.error( "关闭响应流出现错误: {} ", Arrays.asList(var13.getMessage(), var13), "httpGet");
                }
            }

        }

        return result;
    }

    public String post(String url, NameValuePair[] nameValuePairs) {
        return this.post(url, Arrays.asList(nameValuePairs));
    }

    public String post(String url, List<NameValuePair> nameValuePairs) {
        logger.info( "请求的url:{}, nameValuePairs: {}", Arrays.asList(url, JSON.toJSONString(nameValuePairs)), "httpPost");
        String result = null;
        CloseableHttpResponse response = null;

        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            response = this.client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (200 != statusCode) {
                logger.error( "请求URL {} 时返回的statusCode为 {}", Arrays.asList(url, statusCode), "httpPost");
            }

            result = EntityUtils.toString(response.getEntity(), "UTF-8");
            logger.info( "服务端返回的response: {}", Arrays.asList(result), "httpPost");
            EntityUtils.consume(response.getEntity());
        } catch (IOException var15) {
            logger.error( "请求URL {} 时发生错误", Arrays.asList(url, var15), "httpPost");
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException var14) {
                    logger.error( "关闭响应流出现错误: {} ", Arrays.asList(var14.getMessage(), var14), "httpPost");
                }
            }

        }

        return result;
    }

    public String postJson(String url, Object jsonObject) {
        logger.info( "请求的url: {}, 报文体: {}", Arrays.asList(url, JSON.toJSONString(jsonObject)), "httpPostJson");
        String result = null;
        CloseableHttpResponse response = null;

        try {
            HttpEntity entity = new StringEntity(JSON.toJSONString(jsonObject, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect}), Charset.forName("UTF-8"));
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.setEntity(entity);
            response = this.client.execute(httpPost);
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

    public boolean downloadFile(String url, File destFile) {
        logger.info( "请求的url: {}, 文件名: {}", Arrays.asList(url, destFile.getName()), "httpDownload");
        CloseableHttpResponse response = null;

        boolean var5;
        try {
            HttpGet getMethod = new HttpGet(url);
            response = this.client.execute(getMethod);
            int statusCode = response.getStatusLine().getStatusCode();
            if (200 != statusCode) {
                logger.error( "请求URL {} 时返回的statusCode为 {}", Arrays.asList(url, statusCode), "httpDownload");
                boolean var21 = false;
                return var21;
            }

            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            response.getEntity().writeTo(fileOutputStream);
            boolean var7 = true;
            return var7;
        } catch (IOException var18) {
            logger.error( "请求URL {} 时发生错误", Arrays.asList(url, var18), "httpDownload");
            var5 = false;
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException var17) {
                    logger.error( "关闭响应流出现错误: {} ", Arrays.asList(var17.getMessage(), var17), "httpDownload");
                }
            }

        }

        return var5;
    }

    private static class InstanceHolder {
        private static final HttpClientUtil instance = new HttpClientUtil();

        private InstanceHolder() {
        }
    }
}
