package com.jerryYan.vue.internal.controller;

import com.jerryYan.vue.common.entity.JsonResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Created by ys on 2016-11-07
 */
@RestController
@RequestMapping(path = "")
public class WelcomeController {

    public static String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    @GetMapping(path = "")
    public JsonResponseEntity<Map<String, Object>> home() {
        JsonResponseEntity<Map<String, Object>> response = new JsonResponseEntity<>();

        Map<String, Object> info = new HashMap<>();
        info.put("version", "1.0.0");
        info.put("desc", "vue admin 管理平台");
        info.put("time", startTime);

        response.setData(info);
        return response;
    }

}
