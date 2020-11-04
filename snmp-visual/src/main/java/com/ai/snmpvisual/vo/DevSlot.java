package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/10/28 19:26
 */
@Data
@ApiModel
@AllArgsConstructor
public class DevSlot {

    @ApiModelProperty(notes = "设备IP")
    private String devIp;
    @ApiModelProperty(notes = "单板名称")
    private List<String> slotDesc;
}
