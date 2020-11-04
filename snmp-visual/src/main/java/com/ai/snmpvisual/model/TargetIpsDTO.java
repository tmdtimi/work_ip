package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/7/6 15:21
 */
@ApiModel
@Getter
@Setter
public class TargetIpsDTO {

    /**
     * 厂商标志:
     * 0 - 全厂家ip，查询的时候使用
     * 1 - 华为
     * 2 - 思科
     * 3 - 其他
     *
     */
    @ApiModelProperty(notes = "厂家编号", required = true)
    private int factoryNo;

    /**
     * 设备IP
     */
    @ApiModelProperty(notes = "设备IP列表", required = true)
    private List<String> devList;


}
