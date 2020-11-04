package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MonitorPortStatus {

    @ApiModelProperty(notes = "端口总数量")
    private int portNum;
    @ApiModelProperty(notes = "关注端口数量")
    private int focusPortNum;
    @ApiModelProperty(notes = "端口状态up数量")
    private int upPortNum;
    @ApiModelProperty(notes = "端口状态down数量")
    private int downPortNum;
    @ApiModelProperty(notes = "端口状态abnomal数量")
    private int abnomalPortNum;
    @ApiModelProperty(notes = "上行带宽利用率超过阈值数量")
    private int inOverThreshodNum;
    @ApiModelProperty(notes = "下行带宽利用率超过阈值数量")
    private int outOverThreshodNum;
    @ApiModelProperty(notes = "监控持续时间")
    private String timeDiff;


}
