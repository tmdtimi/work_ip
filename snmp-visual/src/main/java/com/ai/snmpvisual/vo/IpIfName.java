package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/9/15 10:39
 */
@Data
@ApiModel
public class IpIfName {
    @ApiModelProperty(notes = "设备IP")
    private String ip;
    @ApiModelProperty(notes = "设备端口")
    private List<String> ifName;
}
