package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/10/15 13:44
 */
@Data
@ApiModel
@AllArgsConstructor
public class IpPortsReq {

    @ApiModelProperty(notes = "设备IP")
    private String dev_ip;
    @ApiModelProperty(notes = "端口名称")
    private List<String> if_names;
    @ApiModelProperty(notes = "端口状态")
    private String oper_status;
    @ApiModelProperty(notes = "设备名称")
    private String sys_name;

}
