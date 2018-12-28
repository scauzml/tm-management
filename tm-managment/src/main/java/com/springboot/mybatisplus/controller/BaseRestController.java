package com.springboot.mybatisplus.controller;


import com.google.common.collect.Lists;
import com.springboot.mybatisplus.exception.RestException;
import com.springboot.mybatisplus.util.StringUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * Rest Controller基类
 */
public abstract class BaseRestController extends BaseController {

    @ExceptionHandler(RestException.class)
    public RestException processApiException(RestException e) {
        return e;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public RestException processApiException(MethodArgumentNotValidException e) {
        List<String> msgList = Lists.newArrayList();
        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            msgList.add(objectError.getDefaultMessage());
        }
        return new RestException(StringUtils.toString(msgList));
    }

    @ExceptionHandler({BindException.class})
    public RestException doBindException(BindException e) {
        List<String> msgList = Lists.newArrayList();
        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            msgList.add(objectError.getDefaultMessage());
        }
        return new RestException(StringUtils.toString(msgList));
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public RestException doHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String msg = e.getMessage();
        if (msg.startsWith("JSON parse error")) {
            String start = "field : ";
            String end = ";";
            msg = "字段[" + msg.substring(msg.indexOf(start) + start.length(), msg.indexOf(end)) + "]解析出错";
        }
        return new RestException(msg, e);
    }

//    @ExceptionHandler(Exception.class)
//    public RestException processException(Exception e) {
//        return new RestException(e);
//    }

}