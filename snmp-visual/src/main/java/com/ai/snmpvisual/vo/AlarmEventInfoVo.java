package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@ApiModel
@Data
@NoArgsConstructor
public class AlarmEventInfoVo {

    @ApiModelProperty(notes = "告警事件数量")
    private int alarmEventNum;

    public AlarmEventInfoVo(List<AlarmEventInfo> alarmInfos) {
        this.alarmEventNum=alarmInfos.size();
    }
}
