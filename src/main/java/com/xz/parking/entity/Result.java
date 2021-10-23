package com.xz.parking.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xz
 * @Date: 2021/10/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    //指定字段顺序
    @JSONField(ordinal = 1)
    private Integer code;
    @JSONField(ordinal = 2)
    private String msg;
    @JSONField(ordinal = 7)
    private Object data;

    /**
     * 成功静态方法
     */
    public static Result ok(Object data) {
        Result r = new Result();
        r.setCode(ResultCode.SUCCESS);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    /**
     * 失败静态方法
     */
    public static Result failed(Object data) {
        Result r = new Result();
        r.setCode(ResultCode.ERROR);
        r.setMsg("failed");
        r.setData(data);
        return r;
    }

    public Result code(Integer code) {
        this.code = code;
        return this;
    }

    public Result msg(String msg) {
        this.msg = msg;
        return this;
    }
}
