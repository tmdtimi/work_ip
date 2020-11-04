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
public class DeviceStatus {

    @ApiModelProperty(notes = "设备总数目")
    private int amount;
    @ApiModelProperty(notes = "正常设备数")
    private int nomalDev;
    @ApiModelProperty(notes = "异常设备数")
    private int abNomalDev;

}
