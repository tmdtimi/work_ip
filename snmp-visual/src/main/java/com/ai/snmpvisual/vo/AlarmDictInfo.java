package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@NoArgsConstructor
public class AlarmDictInfo {


    @ApiModelProperty(notes = "告警程度")
    private int severity;

    @ApiModelProperty(notes = "未定义告警数")
    private int undefiendNum;


}
