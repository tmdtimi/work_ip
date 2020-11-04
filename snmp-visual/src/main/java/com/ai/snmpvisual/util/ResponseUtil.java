package com.ai.snmpvisual.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static com.ai.snmpvisual.util.StatusCodeUtil.*;
import static com.ai.snmpvisual.util.StatusCodeUtil.RESULT_MESSAGE_SUCCESS;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/7/9 17:29
 */
@ApiModel
@Getter
@Setter
@ToString
public class ResponseUtil<T> {

    @ApiModelProperty(notes = "元数据", required = true)
    private Meta meta;
    @ApiModelProperty(notes = "返回结果", required = true)
    private T data;

    public static <R> ResponseUtil<R> generate(R t){

        ResponseUtil<R> responseUtil = new ResponseUtil<>();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();

        if(null == t){
            meta.setCode(RESULT_CODE_FAILURE);
            meta.setMessage(RESULT_MESSAGE_FAILURE);
        }else{
            meta.setCode(RESULT_CODE_SUCCESS);
            meta.setMessage(RESULT_MESSAGE_SUCCESS);
            responseUtil.setData(t);
        }
        responseUtil.setMeta(meta);
        return responseUtil;

    }


    public static class Meta {
        @ApiModelProperty(notes = "结果状态码")
        private String code;
        @ApiModelProperty(notes = "结果信息")
        private String Message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            Message = message;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "code='" + code + '\'' +
                    ", Message='" + Message + '\'' +
                    '}';
        }
    }

}
