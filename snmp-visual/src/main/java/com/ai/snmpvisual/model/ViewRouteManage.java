package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: LIJY
 * @Description: 路由管理
 * @Date: 2020/8/7 18:55
 */
@Getter
@Setter
@ToString
@ApiModel
public class ViewRouteManage {
    @ApiModelProperty(notes = "目的IP地址")
    private String destIp;
    @ApiModelProperty(notes = "目的IP掩码")
    private String mask;
    @ApiModelProperty(notes = "TOS")
    private String tos;
    @ApiModelProperty(notes = "下一跳地址")
    private String nextHop;
    @ApiModelProperty(notes = "路由类型")
    private String routeType;
    @ApiModelProperty(notes = "路由学习机制")
    private String routeProto;
    @ApiModelProperty(notes = "出接口索引")
    private String ifName;
    @ApiModelProperty(notes = "下一跳自系统号")
    private String nextHopAS;
    @ApiModelProperty(notes = "路由metric")
    private String routeMetric;
    @ApiModelProperty(notes = "时间")
    private String time;

}
