package com.recommend.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommonsUtil {
    public static String getToken() {
        return UUID.randomUUID().toString();
    }
}
