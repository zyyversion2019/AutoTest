package com.zyy.testauto.utils;

import com.alibaba.fastjson.JSONObject;
import com.zyy.testauto.config.TestConfig;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

@Log4j2
public class HttpClientUtils {


    public static String  excutePost(String reqUrl, JSONObject params) throws IOException {
        log.info("请求地址：{}；请求参数：{}",reqUrl,params.toJSONString());
        HttpPost post=new HttpPost(reqUrl);
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(params.toString(),"utf-8");
        post.setEntity(entity);
        HttpResponse response= TestConfig.httpClient.execute(post);
        String res = EntityUtils.toString(response.getEntity(),"utf-8");
        TestConfig.cookieStore=TestConfig.httpClient.getCookieStore();
        log.info("请求返回信息：{}",res);
        return res;

    }
    public static String  excutePostWithCookies(String reqUrl, JSONObject params) throws IOException {
        log.info("请求地址：{}；请求参数：{}",reqUrl,params.toJSONString());
        HttpPost post=new HttpPost(reqUrl);
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(params.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.httpClient.setCookieStore(TestConfig.cookieStore);
        HttpResponse response= TestConfig.httpClient.execute(post);
        String res = EntityUtils.toString(response.getEntity(),"utf-8");
        log.info("请求返回信息：{}",res);
        return res;

    }
    public static String  excutePostNoCookies(String reqUrl, JSONObject params) throws IOException {
        log.info("请求地址：{}；请求参数：{}",reqUrl,params.toJSONString());
        HttpPost post=new HttpPost(reqUrl);
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(params.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.httpClient.getCookieStore().clear();
        HttpResponse response= TestConfig.httpClient.execute(post);
        String res = EntityUtils.toString(response.getEntity(),"utf-8");
        TestConfig.cookieStore=TestConfig.httpClient.getCookieStore();
        log.info("请求返回信息：{}",res);
        return res;

    }



}
