package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/8/11 11:13
 */
@Getter
@Setter
@ApiModel
@ToString
public class ViewInterfaceNameIp {

    @ApiModelProperty(notes = "设备IP")
    private String devIp;
    @ApiModelProperty(notes = "端口名称")
    private String ifName;
    @ApiModelProperty(notes = "ip地址")
    private String ipAddr;
    @ApiModelProperty(notes = "掩码")
    private String mask;
}
