package com.ai.snmpvisual.vo;

import com.ai.snmpvisual.model.Device;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
* CPUTop10工具类
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel
public class CPUTop10Device {

    @ApiModelProperty(notes = "设备名称")
    private String sysName;

    @ApiModelProperty(notes = "设备ip")
    private String devIp;

    @ApiModelProperty(notes = "单板描述")
    private String slotDesc;

    @ApiModelProperty(notes = "CPU使用率")
    private String devDuty;

    public CPUTop10Device(Device device){
        this.sysName=device.getSysName();
        this.devIp=device.getDevIp();
        this.slotDesc=device.getSlotDesc();
        this.devDuty=device.getCpuDevDuty();
    }

}
