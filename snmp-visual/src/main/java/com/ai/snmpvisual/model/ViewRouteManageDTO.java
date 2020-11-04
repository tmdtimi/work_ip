package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: LIJY
 * @Description: 路由管理的入参
 * @Date: 2020/8/7 19:05
 */
@Getter
@Setter
@ToString
@ApiModel
public class ViewRouteManageDTO {

    @ApiModelProperty(notes = "目的IP地址")
    private String destIp;
    @ApiModelProperty(notes = "开始时间")
    private String startTime;
    @ApiModelProperty(notes = "结束时间")
    private String endTime;
}
