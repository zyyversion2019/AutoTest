package com.zyy.testauto.cases;

import com.alibaba.fastjson.JSONObject;
import com.zyy.testauto.config.TestConfig;
import com.zyy.testauto.model.AddUserCase;
import com.zyy.testauto.model.GetUserCase;
import com.zyy.testauto.model.LoginCase;
import com.zyy.testauto.model.User;
import com.zyy.testauto.utils.DatabaseUtil;
import com.zyy.testauto.utils.HttpClientUtils;
import com.zyy.testauto.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Log4j2
public class GetUserTest {

    @Test(dependsOnGroups = "loginTrue")
    public void getUserInfo() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserCase getUserCase=session.selectOne("selectGetUserCaseByCaseName","getUserById");
        String reqUrl= TestConfig.systemUrl+getUserCase.getUri();
        //接口获取用户信息
        JSONObject object= JSONObject.parseObject(getUserCase.getParams());
        String res=HttpClientUtils.excutePostWithCookies(reqUrl,object);
        log.info("接口返回信息：{}",res);
        // 数据库直接查询用户信息
        User user=session.selectOne(getUserCase.getExpected(),object);
        log.info("数据库直查返回信息：{}",JSONObject.toJSONString(user));

        boolean rescampare=JsonUtils.jsonEquals(res,JSONObject.toJSONString(user));
        Assert.assertTrue(rescampare);

    }


}
