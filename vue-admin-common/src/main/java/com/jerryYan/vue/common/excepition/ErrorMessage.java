package com.jerryYan.vue.common.excepition;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * <p/>
 * Created by jerryYan on 15/11/26.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ErrorMessage {

    private final int code;
    private final String msg;

    public ErrorMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ErrorMessage(String msg) {
        this.code = 1000;
        this.msg = msg;
    }

    public ErrorMessage(BaseException ex) {
        this.code = ex.code();
        this.msg = ex.msg();
    }
}