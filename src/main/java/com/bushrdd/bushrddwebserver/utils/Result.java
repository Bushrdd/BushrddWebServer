package com.bushrdd.bushrddwebserver.utils;

import com.alibaba.fastjson2.JSONObject;
import com.bushrdd.bushrddwebserver.pojo.Songs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    public static String OK() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "OK");
        return JSONObject.toJSONString(map);
    }

    public static String OK(List<Songs> songs) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "OK");
        map.put("data", songs);
        return JSONObject.toJSONString(map);
    }
}
