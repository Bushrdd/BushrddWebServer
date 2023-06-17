package com.bushrdd.bushrddwebserver.utils;

import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Result {

    public static String OK() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "OK");
        return JSONObject.toJSONString(map);
    }
}
