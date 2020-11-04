package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: LIJY
 * @Description: 端口信息
 * @Date: 2020/7/31 10:58
 */
@Getter
@Setter
@ToString
@ApiModel
public class ViewPortInfo {

    @ApiModelProperty(notes = "设备名称")
    private String sysName;
    @ApiModelProperty(notes = "设备IP")
    private String ip;
    @ApiModelProperty(notes = "端口名称")
    private String ifName;
    @ApiModelProperty(notes = "流入流量")
    private String inOctets;
    @ApiModelProperty(notes = "流出流量")
    private String outOctets;
    @ApiModelProperty(notes = "端口状态admin")
    private String adminStatus;
    @ApiModelProperty(notes = "端口状态oper")
    private String operStatus;
    @ApiModelProperty(notes = "更新时间")
    private String time;
    @ApiModelProperty(notes = "带宽")
    private String bandwith;

}
