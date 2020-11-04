package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel
@Data
@AllArgsConstructor
public class AlarmEventInfo {

    @ApiModelProperty(notes = "事件描述 ip_slot或ip_ifName")
    private String eventDesc;

    @ApiModelProperty(notes = "事件信息")
    private String eventMsg;

}
