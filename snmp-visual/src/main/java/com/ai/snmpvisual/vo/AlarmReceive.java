package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlarmReceive {


    @ApiModelProperty(notes = "告警id")
    private String alarmId;

    @ApiModelProperty(notes = "严重程度标志位")
    private String severity;
}
