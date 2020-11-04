package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/8/6 15:47
 */
@Setter
@Getter
@ToString
@ApiModel
public class Device {

    @ApiModelProperty(notes = "名称")
    private String sysName;
    @ApiModelProperty(notes = "设备IP")
    private String devIp;
    @ApiModelProperty(notes = "槽位索引")
    private String idx;
    @ApiModelProperty(notes = "单板描述")
    private String slotDesc;
    @ApiModelProperty(notes = "单板的运行状态")
    private String operStatus;
    @ApiModelProperty(notes = "CPU使用")
    private String cpuDevDuty;
    @ApiModelProperty(notes = "华为设备的存储器模块总量超过4G的总大小")
    private String hwMemoryDevSize64;
    @ApiModelProperty(notes = "华为设备的超过4G的情况下的存储器的空闲大小")
    private String hwMemoryDevFree64;
    @ApiModelProperty(notes = "新华三设备的内存使用")
    private String h3cMemory;
    @ApiModelProperty(notes = "中兴设备总内存")
    private String zteTotalMemory;
    @ApiModelProperty(notes = "中兴设备已用内存")
    private String zteUsedMemory;



}
