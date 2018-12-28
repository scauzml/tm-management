package com.springboot.mybatisplus.exception;


import com.springboot.mybatisplus.emun.RestStatus;
import com.springboot.mybatisplus.util.FastJsonUtils;
import com.springboot.mybatisplus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class RestException extends RuntimeException {

    public static RestException UNAUTHORIZED = new RestException(-401, "非法操作，权限不足");
    public static RestException NOT_FOUND = new RestException(-404, "内容不存在");
    protected Logger logger = LoggerFactory.getLogger(RestException.class);
    private Integer code = -2;  //异常代码
    private String msg;         //异常提示
    private String error;       //异常错误

    public RestException(Exception e) {
        super(e.getMessage());
        setError(e);
    }

    public RestException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RestException(String msg, Exception e) {
        super(msg);
        this.msg = msg;
        setError(e);
    }

    public RestException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public RestException(Integer code, String msg, String error) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.error = error;
    }

    public RestException(Integer code, String msg, Exception e) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getError() {
        return error;
    }

    public Map<String, Object> asMap() {
        Map map = new HashMap<String, Object>();
        map.put("code", this.code);
        map.put("msg", this.msg);
        if (error != null) {
            map.put("error", this.error);
        }
        return map;
    }

    public String asString() {
        return FastJsonUtils.toString(this.asMap());
    }

    public boolean isError() {
        return this.code.equals(RestStatus.ERROR.code);
    }

    private void setError(Exception e) {
        logger.error("系统异常", e);
        e.printStackTrace();
        this.code = RestStatus.ERROR.code;
        if (this.msg == null) {
            this.msg = RestStatus.ERROR.msg;
        }
        this.error = StringUtils.toString(e);
    }

}