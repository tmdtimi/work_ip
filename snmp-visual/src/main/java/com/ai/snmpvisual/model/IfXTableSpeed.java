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
 * @Date: 2020/7/24 14:17
 */
@Getter
@Setter
@ToString
@ApiModel
public class IfXTableSpeed {

    @ApiModelProperty(notes = "接口趋势")
    private List<Speed> ifXTableSpeed;

}
