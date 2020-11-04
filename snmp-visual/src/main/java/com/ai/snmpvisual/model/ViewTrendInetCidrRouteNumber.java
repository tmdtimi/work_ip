package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: GZ
 * @Description: TODO
 * @Date: 2020/7/8 10:08
 */
@Getter
@Setter
@ApiModel
public class ViewTrendInetCidrRouteNumber {

    /**
     * 设备ip
     */
    @ApiModelProperty(notes = "设备ip")
    private String ip;

    @ApiModelProperty(notes = "当前inetCidrRouteTable有效表项的数量")
    private String routeNum;

    @ApiModelProperty(notes = "更新时间")
    private String time;


}
