package com.jerryYan.vue.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by jerryYan on 17/6/8.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponseEntity<T> {

    private int code;
    private String msg;
    private T data;

    public JsonResponseEntity() {
        this.code = 0;
    }

    public JsonResponseEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResponseEntity(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
