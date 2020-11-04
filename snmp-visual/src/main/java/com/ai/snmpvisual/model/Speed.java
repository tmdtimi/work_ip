package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/7/24 14:25
 */
@Setter
@Getter
@ToString
@ApiModel
public class Speed {

    @ApiModelProperty(notes = "接口带宽利用率(入)")
    List<String> useRateIn;
    @ApiModelProperty(notes = "接口带宽利用率(出)")
    List<String> useRateOut;
    @ApiModelProperty(notes = "接口速率(入)")
    List<String> speedRateIn;
    @ApiModelProperty(notes = "接口速率(出)")
    List<String> speedRateOut;
    @ApiModelProperty(notes = "时间")
    List<String> time;
}
