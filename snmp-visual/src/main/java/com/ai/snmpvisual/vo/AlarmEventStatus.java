package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@ApiModel
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class AlarmEventStatus {

    @ApiModelProperty(notes = "告警数量")
    private int alarmNum;
    @ApiModelProperty(notes = "致命告警数量")
    private int motalAlarmNum;
    @ApiModelProperty(notes = "严重告警数量")
    private int severeAlarmNum;
    @ApiModelProperty(notes = "一般告警数量")
    private int nomalAlarmNum;
    @ApiModelProperty(notes = "未定义数量")
    private int undefinedNum;

}
