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
public class ResultPage extends Result {
    @JSONField(ordinal = 3)
    private Long count;
    @JSONField(ordinal = 4)
    private Integer totalPage;
    @JSONField(ordinal = 5)
    private Integer currentPage;
    @JSONField(ordinal = 6)
    private Integer size;

    /**
     * 成功静态方法
     */
    public static ResultPage ok(Object data) {
        ResultPage r = new ResultPage();
        r.setCode(ResultCode.SUCCESS);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    /**
     * 失败静态方法
     */
    public static ResultPage failed(Object data) {
        ResultPage r = new ResultPage();
        r.setCode(ResultCode.SUCCESS);
        r.setMsg("failed");
        r.setData(data);
        return r;
    }

    public ResultPage total(Long total) {
        this.count = total;
        return this;
    }

    public ResultPage totalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public ResultPage currentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public ResultPage pageSize(Integer pageSize) {
        this.size = pageSize;
        return this;
    }

}
