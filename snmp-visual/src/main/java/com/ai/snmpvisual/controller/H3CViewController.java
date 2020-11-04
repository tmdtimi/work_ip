package com.ai.snmpvisual.controller;

import com.ai.snmpvisual.model.*;
import com.ai.snmpvisual.service.H3CViewService;
import com.ai.snmpvisual.service.ViewService;
import com.ai.snmpvisual.util.PageRsp;
import com.ai.snmpvisual.util.PagingUtil;
import com.ai.snmpvisual.util.ResponseUtil;
import com.ai.snmpvisual.vo.DevSitePortVo;
import com.ai.snmpvisual.vo.DevSiteSlotVo;
import com.ai.snmpvisual.vo.DeviceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.ai.snmpvisual.util.StatusCodeUtil.*;
import static com.ai.snmpvisual.util.StatusCodeUtil.RESULT_MESSAGE_SUCCESS;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/8/3 20:49
 */
@Api(tags = "采集目标设备IP的操作API 新华三")
@Slf4j
@RestController
public class H3CViewController {

    @Autowired
    H3CViewService h3CViewService;

    @Autowired
    ViewService viewService;

    @ApiOperation(value = "查询新华三设备使用信息")
    @PostMapping("/getH3CDevicePerformance")
    public ResponseUtil<ViewH3cSysnameCpuMemorySlot> getViewH3cSysnameCpuMemorySlot(@RequestBody ViewH3cSysnameCpuMemorySlot viewH3cSysnameCpuMemorySlot,
                                                                                    @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                                                    @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        log.info("查询新华三设备使用信息--请求pageSize:" + pageSize + ",currentPage:" + currentPage + ",其他入参:" + viewH3cSysnameCpuMemorySlot.toString());
        try {
            PagingUtil.validatePageParam(currentPage, pageSize);
        } catch (Exception e) {
            log.error("分页参数校验失败" + e);
            throw new RuntimeException(e.getMessage());
        }
        PageRsp<ViewH3cSysnameCpuMemorySlot> viewResult = h3CViewService.getViewH3cSysnameCpuMemorySlot(viewH3cSysnameCpuMemorySlot, currentPage, pageSize);
        ResponseUtil responseUtil = new ResponseUtil();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();
        if (null == viewResult) {
            meta.setCode(RESULT_CODE_FAILURE);
            meta.setMessage(RESULT_MESSAGE_FAILURE);
        } else {
            meta.setCode(RESULT_CODE_SUCCESS);
            meta.setMessage(RESULT_MESSAGE_SUCCESS);
            responseUtil.setData(viewResult);
        }
        responseUtil.setMeta(meta);

        log.info("查询新华三设备使用信息--结果" + responseUtil);
        return responseUtil;
    }


    @ApiOperation(value = "查询设备使用信息")
    @PostMapping("/getViewDeviceInfo")
    public ResponseUtil<DeviceVO> getViewDeviceInfo(@RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                    @RequestParam(value = "pageSize", required = false) Integer pageSize) throws Exception {

        log.info("查询设备使用信息--请求pageSize:" + pageSize + ",currentPage:" + currentPage);
        PagingUtil.validatePageParam(currentPage, pageSize);

        PageRsp<Device> result = h3CViewService.getDeviceInfo(currentPage, pageSize);


        PageRsp<DeviceVO> viewResult = new PageRsp<>();
        viewResult.setCurrentPage(result.getCurrentPage());
        viewResult.setTotalElements(result.getTotalElements());
        viewResult.setTotalPages(result.getTotalPages());
        viewResult.setResults(result.getResults().stream().map(DeviceVO::new).collect(Collectors.toList()));
        ResponseUtil responseUtil = new ResponseUtil();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();
        if (null == viewResult) {
            meta.setCode(RESULT_CODE_FAILURE);
            meta.setMessage(RESULT_MESSAGE_FAILURE);
        } else {
            meta.setCode(RESULT_CODE_SUCCESS);
            meta.setMessage(RESULT_MESSAGE_SUCCESS);
            responseUtil.setData(viewResult);
        }
        responseUtil.setMeta(meta);

        log.info("查询设备使用信息--结果" + responseUtil);
        return responseUtil;
    }


    @ApiOperation(value = "单板信息-树形结构")
    @GetMapping("/getViewSiteDevSlot")
    public ResponseUtil<List<ViewSiteDevSlot>> getViewSiteDevSlot() {
        log.info("单板信息-树形结构");
        ResponseUtil<List<ViewSiteDevSlot>> responseUtil =
                ResponseUtil.generate(viewService.getViewSiteDevSlot());
        log.info("单板信息-树形结构--结果" + responseUtil);
        return responseUtil;
    }



    @ApiOperation(value = "查询单板信息 -- 多IP、单板")
    @PostMapping(value = "/getIpSlots")
    public ResponseUtil<PageRsp<Device>> getIpSlots(
            @RequestBody DevSiteSlotVo devSiteSlotVo,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception {

        log.info("查询单板信息 -- 多IP、单板 devSitePortVo:" + devSiteSlotVo +  ",currentPage:"+ currentPage +",pageSize:" + pageSize);

        PagingUtil.validatePageParam(currentPage, pageSize);

        ResponseUtil<PageRsp<Device>> responseUtil = new ResponseUtil<>();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();

        try {

            PageRsp<Device> result = h3CViewService.getIpSlots(devSiteSlotVo, currentPage, pageSize);
//            PageRsp<ViewPortInfoVo> ipPorts = viewService.getDevPorts(devSitePortVo, currentPage, pageSize);
            meta.setCode(RESULT_CODE_SUCCESS);
            meta.setMessage(RESULT_MESSAGE_SUCCESS);
            responseUtil.setData(result);
            responseUtil.setMeta(meta);
        } catch (Exception e){
            meta.setCode(RESULT_CODE_FAILURE);
            meta.setMessage(RESULT_MESSAGE_FAILURE);
            log.error("[查询端口信息 -- 多IP、端口]" + e);
        }

        log.info("查询端口信息 -- 多IP、端口--结果" + responseUtil);
        return responseUtil;
    }


}
