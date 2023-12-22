package com.bushrdd.bushrddwebserver.utils;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

import java.util.HashMap;
import java.util.Map;

public class Result {

    public static String OK() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "OK");
        return JSONObject.toJSONString(map);
    }

    // public static String OK(List<Songs> songs) {
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("code", 200);
    //     map.put("message", "OK");
    //     map.put("data", songs);
    //     return JSONObject.toJSONString(map);
    // }

    public static String OK(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "OK");
        map.put("data", data);
        return JSONObject.toJSONString(map, JSONWriter.Feature.WriteMapNullValue);
    }



    public static String ERROR() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("message", "error");
        return JSONObject.toJSONString(map);
    }

    public static String ERROR(String error) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 400);
        map.put("message", error);
        return JSONObject.toJSONString(map);
    }
}
