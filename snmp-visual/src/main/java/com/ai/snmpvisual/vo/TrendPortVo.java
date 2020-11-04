package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/9/15 10:33
 */
@Data
@ApiModel
public class TrendPortVo {
    @ApiModelProperty(notes = "开始时间")
    private String start_time;
    @ApiModelProperty(notes = "结束时间")
    private String end_time;
    @ApiModelProperty(notes = "ip_端口")
    private List<IpIfName> ip_ifName;
}

