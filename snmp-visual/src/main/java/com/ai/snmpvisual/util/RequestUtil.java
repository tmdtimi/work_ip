package com.ai.snmpvisual.util;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @author: LIJY
 * @Description: POST请求通用类型
 * @Date: 2020/7/9 14:51
 */
public class RequestUtil {

    private JSONPObject requestInfo;
    private String pageNum;
    private String pageSize;

    public JSONPObject getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(JSONPObject requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "RequestUtil{" +
                "requestInfo=" + requestInfo +
                ", pageNum='" + pageNum + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
