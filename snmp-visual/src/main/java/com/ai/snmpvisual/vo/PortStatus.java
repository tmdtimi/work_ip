package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortStatus {

    @ApiModelProperty(notes = "总端口数")
    private int amountDev;
    @ApiModelProperty(notes = "正常运行的端口数")
    private int nomalDev;
    @ApiModelProperty(notes = "异常运行的端口数")
    private int abNomalDev;
}
