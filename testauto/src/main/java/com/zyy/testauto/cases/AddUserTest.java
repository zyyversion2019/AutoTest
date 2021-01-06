package com.zyy.testauto.cases;

import com.zyy.testauto.config.SysConfig;
import com.zyy.testauto.config.TestConfig;
import lombok.extern.log4j.Log4j2;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;

@Log4j2
public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue")
    public void getUserInfo(){

    }
    @Test(dependsOnGroups = "loginTrue")
    public void addUser(){

    }
    @Test(dependsOnGroups = "loginTrue")
    public void updateUser(){

    }
    @Test(dependsOnGroups = "loginTrue")
    public void delUser(){

    }
}
