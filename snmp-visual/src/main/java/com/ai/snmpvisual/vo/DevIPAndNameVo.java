package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/8/25 15:40
 */
@Data
@ApiModel
public class DevIPAndNameVo {

    @ApiModelProperty(notes = "设备IP")
    private String devIp;
    @ApiModelProperty(notes = "设备名称")
    private String sysName;

}
