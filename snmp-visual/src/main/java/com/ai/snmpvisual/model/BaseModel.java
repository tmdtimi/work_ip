package com.ai.snmpvisual.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author:guwei
 * @Date:2020/6/8 15:58
 */

@Getter
@Setter
public abstract class BaseModel {

    //设备ip地址，联合主键
    public String devIp;

    //mib index，联合主键
    public String idx;

    @JsonIgnore
    public Date createTime;

    @JsonIgnore
    public Date updateTime;

    //预留给软删除是使用
    @JsonIgnore
    public Date deleteTime;

    @Override
    public String toString() {
        return "BaseModel{" +
                "devIp='" + devIp + '\'' +
                ", index='" + idx + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteTime=" + deleteTime +
                '}' + " ";
    }

}
