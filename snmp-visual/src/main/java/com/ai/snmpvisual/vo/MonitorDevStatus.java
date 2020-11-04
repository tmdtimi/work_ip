package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
@AllArgsConstructor
public class MonitorDevStatus {

    @ApiModelProperty(notes = "设备数量")
    private int connectivity;

    @ApiModelProperty(notes = "创建时间")
    private Date createDate;


}
