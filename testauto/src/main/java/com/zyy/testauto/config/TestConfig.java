package com.zyy.testauto.config;

import lombok.Data;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;


@Data
public class TestConfig {

    public static String systemUrl;

    public static DefaultHttpClient httpClient;

    public static CookieStore cookieStore;

}
