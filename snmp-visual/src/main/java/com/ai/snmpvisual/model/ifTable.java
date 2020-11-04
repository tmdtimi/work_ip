package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: WUBO
 * @Description: ifTable
 * @Date: 2020/9/8
 */
@Getter
@Setter
@ToString
@ApiModel
public class ifTable {

    @ApiModelProperty(notes = "设备IP")
    private String devIp;

    @ApiModelProperty(notes = "槽位索引")
    private String idx;

    @ApiModelProperty(notes = "索引")
    private String ifIndex;

    @ApiModelProperty(notes = "描述")
    private String ifDescr;

    @ApiModelProperty(notes = "iftype")
    private String ifTye;

    @ApiModelProperty(notes = "ifMtu")
    private String ifMtu;

    @ApiModelProperty(notes = "ifSpeed")
    private String ifSpeed;

    @ApiModelProperty(notes = "物理Address")
    private String ifPhysAddress;

    @ApiModelProperty(notes = "端口状态标志位1")
    private String ifAdminStatus;

    @ApiModelProperty(notes = "端口状态标志位2")
    private String ifOperStatus;

    @ApiModelProperty(notes = "最后修改时间")
    private String ifLastChange;

    @ApiModelProperty(notes = "创建时间")
    private String createTime;

    @ApiModelProperty(notes = "更新时间")
    private String updateTime;

    @ApiModelProperty(notes = "删除时间")
    private String deleteTime;


}
