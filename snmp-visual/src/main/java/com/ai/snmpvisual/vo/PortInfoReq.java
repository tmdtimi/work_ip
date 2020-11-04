package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: LIJY
 * @Description: 查询端口信息的入参
 * @Date: 2020/10/9 12:26
 */
@Data
@ApiModel
@AllArgsConstructor
public class PortInfoReq {

    @ApiModelProperty(notes = "设备IP")
    private String dev_ip;
    @ApiModelProperty(notes = "端口名称")
    private String if_name;
    @ApiModelProperty(notes = "端口状态")
    private String oper_status;
    @ApiModelProperty(notes = "设备名称")
    private String sys_name;

    public PortInfoReq() {

    }
}
