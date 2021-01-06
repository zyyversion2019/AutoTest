package com.zyy.testauto.cases;

import com.alibaba.fastjson.JSONObject;
import com.zyy.testauto.config.SysConfig;
import com.zyy.testauto.config.TestConfig;
import com.zyy.testauto.model.LoginCase;
import com.zyy.testauto.utils.DatabaseUtil;
import com.zyy.testauto.utils.HttpClientUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

@Log4j2
public class LoginTest {


    @BeforeTest(groups = "loginTrue")
    public void init(){
        log.info("这是初始静态变量方法");
        TestConfig.httpClient=new DefaultHttpClient();
        TestConfig.systemUrl= SysConfig.getSysUrl();
    }

    @Test(groups = "loginTrue")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("selectByCaseName","loginTrue");
//        根据用例名称获取用例数据
        String reqUrl= TestConfig.systemUrl+loginCase.getUri();
        JSONObject params=new JSONObject();
        params.put("userName",loginCase.getUsername());
        params.put("password",loginCase.getPassword());
        String res=HttpClientUtils.excutePost(reqUrl,params);
        Assert.assertEquals(res,loginCase.getExpected());
    }

    @Test(enabled = false)
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("selectByCaseName","loginFalse");
//        根据用例名称获取用例数据
        String reqUrl= TestConfig.systemUrl+loginCase.getUri();
        JSONObject params=new JSONObject();
        params.put("userName",loginCase.getUsername());
        params.put("password",loginCase.getPassword());
        String res=HttpClientUtils.excutePostNoCookies(reqUrl,params);
        Assert.assertEquals(res,loginCase.getExpected());
    }



}
