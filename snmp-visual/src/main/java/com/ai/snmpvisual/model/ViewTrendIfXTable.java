package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: GZ
 * @Description: TODO
 * @Date: 2020/7/8 10:08
 */
@Getter
@Setter
@ApiModel
public class ViewTrendIfXTable {

    /**
     * 设备ip
     */
    @ApiModelProperty(notes = "设备ip")
    private String ip;

    @ApiModelProperty(notes = "接口索引")
    private String ifIndex;

    @ApiModelProperty(notes = "由本地设备分配的接口名")
    private String ifName;

    @ApiModelProperty(notes = "接口当前带宽的估计值")
    private String bandwith;

    @ApiModelProperty(notes = "接口上接收到的字节总数")
    private String inOctets;

    @ApiModelProperty(notes = "接口发送的字节总数")
    private String outOctets;

    @ApiModelProperty(notes = "更新时间")
    private String time;

    @Override
    public String toString() {
        return "ViewTrendIfXTable{" +
                "ip='" + ip + '\'' +
                ", ifIndex='" + ifIndex + '\'' +
                ", ifName='" + ifName + '\'' +
                ", bandwith='" + bandwith + '\'' +
                ", inOctets='" + inOctets + '\'' +
                ", outOctets='" + outOctets + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
