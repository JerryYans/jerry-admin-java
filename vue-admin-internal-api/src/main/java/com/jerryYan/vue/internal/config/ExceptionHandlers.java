package com.jerryYan.vue.internal.config;

import com.jerryYan.vue.common.entity.JsonResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlers {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public JsonResponseEntity exceptionHandler(Exception ex){
        JsonResponseEntity entity;
        if (ex instanceof MissingServletRequestParameterException){
            String msg = ((MissingServletRequestParameterException) ex).getParameterName();
            entity = new JsonResponseEntity(101, String.format("[%s]字段不能为空", msg));
        }else if (ex instanceof NoHandlerFoundException){
            entity = new JsonResponseEntity(102, "Not Found");
        }else {
            entity = new JsonResponseEntity(100, "内部错误");
        }
        return entity;
    }

}
