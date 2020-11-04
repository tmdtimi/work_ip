package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/8/3 21:20
 */
@Getter
@Setter
@ApiModel
@ToString
public class ViewH3cSysnameCpuMemorySlot {

    @ApiModelProperty(notes = "设备ip")
    private String devIp;

    @ApiModelProperty(notes = "系统名")
    private String sysName;

    @ApiModelProperty(notes = "槽位索引")
    private String idx;

    @ApiModelProperty(notes = "槽位名称")
    private String entPhysicalName;

    @ApiModelProperty(notes = "CPU")
    private String h3cCpu;

    @ApiModelProperty(notes = "内存")
    private String h3cMemory;

}
