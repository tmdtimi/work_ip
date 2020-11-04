package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: WUBO
 * @Description: devPing
 * @Date: 2020/9/8
 */
@Getter
@Setter
@ToString
@ApiModel
public class devPing {

    @ApiModelProperty(notes = "设备IP")
    private String devIp;

    @ApiModelProperty(notes = "连通性")
    private String connectivity;

    @ApiModelProperty(notes = "创建时间")
    private String createTime;

    @ApiModelProperty(notes = "更新时间")
    private String updateTime;
}
