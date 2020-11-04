package com.ai.snmpvisual.controller;

import com.ai.snmpvisual.model.ViewTrendIfXTable;
import com.ai.snmpvisual.service.ViewService;
import com.ai.snmpvisual.util.ResponseUtil;
import com.ai.snmpvisual.vo.DevIPAndNameVo;
import com.ai.snmpvisual.vo.GetIfNameReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ai.snmpvisual.util.StatusCodeUtil.*;
import static com.ai.snmpvisual.util.StatusCodeUtil.RESULT_MESSAGE_SUCCESS;

/**
 * @author: LIJY
 * @Description: 用于查询信息的接口
 * @Date: 2020/8/25 15:22
 */
@Api(tags = "用于查询信息的接口API")
@Slf4j
@RestController
public class QueryInfoController {

    @Autowired
    ViewService viewService;

    @ApiOperation(value = "查询设备的名称和ip")
    @PostMapping("/getDevIpAndName")
    public ResponseUtil<DevIPAndNameVo> getDevIpAndName() {

        List<DevIPAndNameVo> list = viewService.getDevIpAndName();
        ResponseUtil responseUtil = new ResponseUtil();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();
        if (null == list) {
            meta.setCode(RESULT_CODE_FAILURE);
            meta.setMessage(RESULT_MESSAGE_FAILURE);
        } else {
            meta.setCode(RESULT_CODE_SUCCESS);
            meta.setMessage(RESULT_MESSAGE_SUCCESS);
            responseUtil.setData(list);
        }
        responseUtil.setMeta(meta);

        log.info("查询设备的名称和ip--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "查询端口名称")
    @PostMapping("/getIfNameByIpOrSysName")
    public ResponseUtil getIfNameByIpOrSysName(@RequestBody GetIfNameReq getIfNameReq) {
        log.info("查询端口名称--请求：getIfNameReq: " + getIfNameReq);
        String devIp = getIfNameReq.getDevIp();
        String sysName = getIfNameReq.getSysName();
        List<String> ifNames = viewService.getIfNameByIpOrSysName(sysName, devIp);
        ResponseUtil responseUtil = new ResponseUtil();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();
        if (null == ifNames) {
            meta.setCode(RESULT_CODE_FAILURE);
            meta.setMessage(RESULT_MESSAGE_FAILURE);
        } else {
            meta.setCode(RESULT_CODE_SUCCESS);
            meta.setMessage(RESULT_MESSAGE_SUCCESS);
            responseUtil.setData(ifNames);
        }
        responseUtil.setMeta(meta);

        log.info("查询端口名称--结果" + responseUtil);
        return responseUtil;
    }


}
