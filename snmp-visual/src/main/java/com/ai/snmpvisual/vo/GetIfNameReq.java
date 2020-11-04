package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/10/12 10:01
 */
@Data
@ApiModel
public class GetIfNameReq {

    @ApiModelProperty(notes = "设备名称")
    private String sysName;

    @ApiModelProperty(notes = "设备IP")
    private String devIp;

}
