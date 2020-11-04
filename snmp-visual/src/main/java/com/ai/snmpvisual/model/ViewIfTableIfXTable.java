package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: GZ
 * @Description: TODO
 * @Date: 2020/7/8 10:08
 */
@Getter
@Setter
@ApiModel
public class ViewIfTableIfXTable {

    /**
     * 设备ip
     */
    @ApiModelProperty(notes = "设备ip")
    private String devIp;

    @ApiModelProperty(notes = "槽位索引")
    private String idx;


    @ApiModelProperty(notes = "接口索引")
    private String ifIndex;


    @ApiModelProperty(notes = "描述接口的字符串")
    private String ifDescr;


    @ApiModelProperty(notes = "由本地设备分配的接口名")
    private String ifName;


    @ApiModelProperty(notes = "接口类型")
    private String ifType;


    @ApiModelProperty(notes = "接口当前带宽的估计值")
    private String bandWith;


    @ApiModelProperty(notes = "接口的协议子层对应的接口地址")
    private String ifPhysAddress;

    @ApiModelProperty(notes = "接口的理想状态")
    private String ifAdminStatus;

    @ApiModelProperty(notes = "当前接口的操作状态")
    private String ifOperStatus;

    @ApiModelProperty(notes = "接口进入当前运行状态的系统时间")
    private String ifLastChange;

    @Override
    public String toString() {
        return "ViewIfTableIfXTable{" +
                "devIp='" + devIp + '\'' +
                ", idx='" + idx + '\'' +
                ", ifIndex='" + ifIndex + '\'' +
                ", ifDescr='" + ifDescr + '\'' +
                ", ifName='" + ifName + '\'' +
                ", ifType='" + ifType + '\'' +
                ", bandWith='" + bandWith + '\'' +
                ", ifPhysAddress='" + ifPhysAddress + '\'' +
                ", ifAdminStatus='" + ifAdminStatus + '\'' +
                ", ifOperStatus='" + ifOperStatus + '\'' +
                ", ifLastChange='" + ifLastChange + '\'' +
                '}';
    }
}
