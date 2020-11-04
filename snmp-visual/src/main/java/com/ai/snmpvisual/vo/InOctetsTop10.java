package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class InOctetsTop10 {

    @ApiModelProperty(notes = "主机名称")
    private String sysName;

    @ApiModelProperty(notes = "设备IP")
    private String ip;

    @ApiModelProperty(notes = "设备名称")
    private String ifName;

    @ApiModelProperty(notes = "端口带宽上行利用率")
    private String devDuty;


}
