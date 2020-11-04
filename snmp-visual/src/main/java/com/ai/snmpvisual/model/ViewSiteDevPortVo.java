package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/10/15 10:21
 */
@ApiModel
@Data
public class ViewSiteDevPortVo {

    @ApiModelProperty(notes = "机房位置")
    private String devSite;
    @ApiModelProperty(notes = "设备IP")
    private String devIp;
    @ApiModelProperty(notes = "设备状态")
    private String devStatus;
    @ApiModelProperty(notes = "设备名")
    private String devName;
    @ApiModelProperty(notes = "端口名")
    private String portName;
    @ApiModelProperty(notes = "端口状态")
    private String portStatus;

}
