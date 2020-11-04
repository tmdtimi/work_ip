package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/10/15 10:39
 */
@Data
@ApiModel
@AllArgsConstructor
public class ViewSiteDevPortRsp {

    @ApiModelProperty(notes = "设备名称")
    private String sysName;
    @ApiModelProperty(notes = "设备IP")
    private String ip;
    @ApiModelProperty(notes = "端口名称")
    private String ifName;
    @ApiModelProperty(notes = "流入流量")
    private String inOctets;
    @ApiModelProperty(notes = "流出流量")
    private String outOctets;
    @ApiModelProperty(notes = "端口状态")
    private String portStatus;
    @ApiModelProperty(notes = "更新时间")
    private String time;
    @ApiModelProperty(notes = "流入带宽利用率")
    private String useRateIn;
    @ApiModelProperty(notes = "流出带宽利用率")
    private String useRateOut;
    @ApiModelProperty(notes = "带宽")
    private String bandwith;



}
