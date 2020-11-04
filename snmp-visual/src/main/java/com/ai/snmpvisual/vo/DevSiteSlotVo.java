package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/10/28 19:25
 */
@Data
@ApiModel
@AllArgsConstructor
public class DevSiteSlotVo {

    @ApiModelProperty(notes = "机房位置")
    private String devSite;
    @ApiModelProperty(notes = "设备IP")
    private String devIp;
    @ApiModelProperty(notes = "设备 + 端口")
    private List<DevSlot> devSlots;

}
