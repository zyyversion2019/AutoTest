package com.zyy.testauto.cases;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class UpdateUserTest {

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
