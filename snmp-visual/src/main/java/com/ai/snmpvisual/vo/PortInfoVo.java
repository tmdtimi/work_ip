package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel
@AllArgsConstructor
public class PortInfoVo {

    @ApiModelProperty(notes = "设备名称")
    private String sysName;

    @ApiModelProperty(notes = "设备IP")
    private String ip;

    @ApiModelProperty(notes = "端口名称")
    private String ifName;


}
