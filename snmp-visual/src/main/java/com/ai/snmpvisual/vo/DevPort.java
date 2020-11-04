package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/10/15 18:54
 */
@Data
@ApiModel
@AllArgsConstructor
public class DevPort {

    @ApiModelProperty(notes = "设备IP")
    private String devIp;
    @ApiModelProperty(notes = "端口名")
    private List<String> portName;

}
