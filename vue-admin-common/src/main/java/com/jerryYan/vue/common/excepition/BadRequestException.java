package com.jerryYan.vue.common.excepition;

/**
 * <p/>
 * Created by jerryYan on 15/12/1.
 */
public class BadRequestException extends BaseException {

    public BadRequestException() {
        super(1001, "错误的请求格式", null);
    }

    public BadRequestException(int code , String msg){
        super(code,msg);
    }
}
