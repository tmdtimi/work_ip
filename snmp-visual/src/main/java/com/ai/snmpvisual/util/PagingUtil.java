package com.ai.snmpvisual.util;

import java.util.List;
import java.util.Objects;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/7/9 15:21
 */
public class PagingUtil<T> {

    public static <T> PageRsp<T> GeneratePageRsp(List<T> result,
                                                 Integer totalElements,
                                                 Integer currentPage,
                                                 Integer pageSize)
            throws Exception{


        PageRsp<T> pageRsp = new PageRsp<>();
        pageRsp.setResults(result);
        pageRsp.setTotalElements(totalElements);
        pageRsp.setTotalPages(currentPage==null?1:
                (totalElements/pageSize) + (totalElements%pageSize == 0?0:1));
        pageRsp.setCurrentPage(currentPage==null?0:
                currentPage>pageRsp.getTotalPages()?
                        pageRsp.getTotalPages():
                        currentPage);
        return pageRsp;
    }

    public static void validatePageParam(Integer currentPage,Integer pageSize) throws Exception{

        if(Objects.isNull(currentPage) != Objects.isNull(pageSize)){
            throw new RuntimeException("分页参数错误");
        }

        if(currentPage != null && currentPage < 0 && pageSize <= 0){
            throw new RuntimeException("分页参数错误");
        }
    }

}
