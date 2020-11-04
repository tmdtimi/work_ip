package com.ai.snmpvisual.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author: LIJY
 * @Description: 分页工具类
 * @Date: 2020/7/9 15:17
 */
@Getter
@Setter
@ToString
@ApiModel
public class PageRsp<T> {

    @ApiModelProperty(notes = "总页数", required = true)
    private Integer totalPages;
    @ApiModelProperty(notes = "当前页", required = true)
    private Integer currentPage;
    @ApiModelProperty(notes = "总数量", required = true)
    private Integer totalElements;
    @ApiModelProperty(notes = "结果集")
    private List<T> results;


}
