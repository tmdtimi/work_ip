package com.ai.snmpvisual.controller;

import com.ai.snmpvisual.model.*;
import com.ai.snmpvisual.service.ViewService;
import com.ai.snmpvisual.util.PageRsp;
import com.ai.snmpvisual.util.PagingUtil;
import com.ai.snmpvisual.util.ResponseUtil;
import com.ai.snmpvisual.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.ai.snmpvisual.util.StatusCodeUtil.*;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/7/6 16:07
 */
@Api(tags = "采集目标设备IP的操作API2")
@Slf4j
@RestController
public class ViewController {

    @Autowired
    ViewService viewService;

    @ApiOperation(value = "查询设备使用信息")
    @PostMapping("/getDevicePerformance")
    public ResponseUtil<PageRsp<ViewSysNameCpuMemorySlot>> getViewSysNameCpuMemorySlot(
            @RequestBody ViewSysNameCpuMemorySlot viewSysNameCpuMemorySlot,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception {

        log.info("查询设备使用信息--请求pageSize:" + pageSize + ",currentPage:" + currentPage + ",其他入参:" + viewSysNameCpuMemorySlot.toString());
        PagingUtil.validatePageParam(currentPage, pageSize);

        PageRsp<ViewSysNameCpuMemorySlot> viewResult = viewService.getViewSysNameCpuMemorySlot(viewSysNameCpuMemorySlot, currentPage, pageSize);
        ResponseUtil<PageRsp<ViewSysNameCpuMemorySlot>> responseUtil = ResponseUtil.generate(viewResult);

        log.info("查询设备使用信息--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "查询接口信息")
    @PostMapping("/getViewIfTableIfXTable")
    public ResponseUtil<PageRsp<ViewIfTableIfXTable>> getViewIfTableIfXTable(
            @RequestBody ViewIfTableIfXTable viewIfTableIfXTable,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception {

        log.info("查询接口信息--请求pageSize:" + pageSize + ",currentPage:" + currentPage + ",其他入参:" + viewIfTableIfXTable.toString());
        PagingUtil.validatePageParam(currentPage, pageSize);

        PageRsp<ViewIfTableIfXTable> viewResult = viewService.getViewIfTableIfXTable(viewIfTableIfXTable, currentPage, pageSize);
        ResponseUtil<PageRsp<ViewIfTableIfXTable>> responseUtil = ResponseUtil.generate(viewResult);
        log.info("查询设备使用信息--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "查询接口当前统计")
    @PostMapping("/getViewIfTableIfXTableNow")
    public ResponseUtil<PageRsp<ViewIfTableIfXTableNow>> getViewIfTableIfXTableNow(
            @RequestBody ViewIfTableIfXTableNow viewIfTableIfXTableNow,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception {

        log.info("查询接口当前统计--请求pageSize:" + pageSize + ",currentPage:" + currentPage + ",其他入参:" + viewIfTableIfXTableNow.toString());
        PagingUtil.validatePageParam(currentPage, pageSize);

        PageRsp<ViewIfTableIfXTableNow> viewResult = viewService.getViewIfTableIfXTableNow(viewIfTableIfXTableNow, currentPage, pageSize);
        ResponseUtil<PageRsp<ViewIfTableIfXTableNow>> responseUtil = ResponseUtil.generate(viewResult);
        log.info("查询接口当前统计--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "查询接口统计趋势")
    @PostMapping(value = "/getTrendIfXTable")
    public ResponseUtil<PageRsp<ViewTrendIfXTable>> getViewTrendIfXTable(
            @RequestBody ViewTrendIfXTable viewTrendIfXTable,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception {

        log.info("查询接口统计趋势--请求pageSize:" + pageSize + ",currentPage:" + currentPage + ",其他入参:" + viewTrendIfXTable.toString());
        PagingUtil.validatePageParam(currentPage, pageSize);

        PageRsp<ViewTrendIfXTable> viewResult = viewService.getViewTrendIfXTable(viewTrendIfXTable, currentPage, pageSize);
        ResponseUtil<PageRsp<ViewTrendIfXTable>> responseUtil = ResponseUtil.generate(viewResult);
        log.info("查询接口当前统计--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "查询接口统计速率")
    @PostMapping(value = "/getRateIfXTable")
    public ResponseUtil<PageRsp<ViewTrendIfXTable>> getViewRateIfXTable(
            @RequestBody ViewTrendIfXTable viewTrendIfXTable,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception {

        log.info("查询接口统计速率--请求pageSize:" + pageSize + ",currentPage:" + currentPage + ",其他入参:" + viewTrendIfXTable.toString());
        PagingUtil.validatePageParam(currentPage, pageSize);

        PageRsp<ViewTrendIfXTable> viewResult = viewService.getViewTrendIfXTable(viewTrendIfXTable, currentPage, pageSize);
        ResponseUtil<PageRsp<ViewTrendIfXTable>> responseUtil = ResponseUtil.generate(viewResult);
        log.info("查询接口统计速率--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "查询路由趋势")
    @PostMapping("/getViewTrendInetCidrRouteNumber")
    public ResponseUtil<PageRsp<ViewTrendInetCidrRouteNumber>> getViewTrendInetCidrRouteNumber(
            @RequestBody ViewTrendInetCidrRouteNumber viewTrendInetCidrRouteNumber,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception {

        log.info("查询路由趋势--请求pageSize:" + pageSize + ",currentPage:" + currentPage + ",其他入参:" + viewTrendInetCidrRouteNumber.toString());
        PagingUtil.validatePageParam(currentPage, pageSize);

        PageRsp<ViewTrendInetCidrRouteNumber> viewResult = viewService.getViewTrendInetCidrRouteNumber(viewTrendInetCidrRouteNumber, currentPage, pageSize);
        ResponseUtil<PageRsp<ViewTrendInetCidrRouteNumber>> responseUtil = ResponseUtil.generate(viewResult);
        log.info("查询路由趋势--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "查询接口趋势")
    @PostMapping(value = "/getRateIfXTableSpeed")
    public ResponseUtil<List<Speed>> getViewTrendIfXTableSpeed(
            @RequestParam(value="dev_ip", required=false) String dev_ip,
            @RequestParam(value="idx", required = false) String idx,
            @RequestParam(value="start_time", required = false) String start_time,
            @RequestParam(value="end_time", required = false) String end_time)
    {
        log.info("查询接口趋势--请求dev_ip:" + dev_ip + ",idx:" + idx + ",start_time:" + start_time + ",end_time:" + end_time);

        ResponseUtil<List<Speed>> responseUtil = new ResponseUtil<>();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();
        try {
            List<Speed> speeds = viewService.getViewTrendIfXTableSpeed(dev_ip, idx, start_time, end_time);
            if (null != speeds) {
                meta.setCode(RESULT_CODE_SUCCESS);
                meta.setMessage(RESULT_MESSAGE_SUCCESS);
                responseUtil.setData(speeds);
            } else {
                meta.setCode(RESULT_CODE_FAILURE);
                meta.setMessage(RESULT_MESSAGE_FAILURE);
            }
            responseUtil.setMeta(meta);
        } catch (Exception e){
            log.error("[查询接口趋势异常]" + e);
        }
        log.info("查询接口趋势--结果" + responseUtil);
        return responseUtil;
    }


    @ApiOperation(value = "查询端口信息")
    @PostMapping(value = "/getPortInfo")
    public ResponseUtil<PageRsp<ViewPortInfoVo>> getPortInfo(
            @RequestBody PortInfoReq portInfoReq,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception {

        log.info("查询端口信息--请求 portInfoReq:" + portInfoReq +  ",currentPage:"+ currentPage +",pageSize:" + pageSize);
        String sys_name = portInfoReq.getSys_name();
        String dev_ip = portInfoReq.getDev_ip();
        String if_name = portInfoReq.getIf_name();
        String oper_status = portInfoReq.getOper_status();

        PagingUtil.validatePageParam(currentPage, pageSize);

        ResponseUtil<PageRsp<ViewPortInfoVo>> responseUtil = new ResponseUtil<>();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();
        try {
            PageRsp<ViewPortInfoVo> viewPortInfoVos = viewService.getPortInfo(sys_name, dev_ip, if_name, oper_status, currentPage, pageSize);
            meta.setCode(RESULT_CODE_SUCCESS);
            meta.setMessage(RESULT_MESSAGE_SUCCESS);
            responseUtil.setData(viewPortInfoVos);
            responseUtil.setMeta(meta);
        } catch (Exception e){
            meta.setCode(RESULT_CODE_FAILURE);
            meta.setMessage(RESULT_MESSAGE_FAILURE);
            log.error("[查询端口信息异常]" + e);
        }
        log.info("查询端口信息--结果" + responseUtil);
        return responseUtil;
    }


    @ApiOperation(value = "查询路由管理")
    @PostMapping("/getViewRouteManage")
    public ResponseUtil<PageRsp<ViewRouteManage>> getViewRouteManage(
            @RequestBody ViewRouteManageDTO viewRouteManageDTO,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception{

        log.info("查询路由管理--请求pageSize:" + pageSize + ",currentPage:" + currentPage + ",其他入参:" + viewRouteManageDTO.toString());
        PagingUtil.validatePageParam(currentPage, pageSize);
        PageRsp<ViewRouteManage> viewResult = viewService.getViewRouteManage(viewRouteManageDTO, currentPage, pageSize);
        ResponseUtil<PageRsp<ViewRouteManage>> responseUtil = ResponseUtil.generate(viewResult);
        log.info("查询路由管理--结果" + responseUtil);
        return responseUtil;
    }


    @ApiOperation(value = "查询端口名称和IP")
    @PostMapping("/getViewInterfaceNameIp")
    public ResponseUtil<List<ViewInterfaceNameIp>> getViewInterfaceNameIp(@RequestParam(value="dev_ip", required=false) String dev_ip){
        log.info("查询端口名称和IP--请求dev_ip:" + dev_ip);
        List<ViewInterfaceNameIp> list = viewService.getViewInterfaceNameIp(dev_ip);
        ResponseUtil<List<ViewInterfaceNameIp>> responseUtil = ResponseUtil.generate(list);
        log.info("查询端口名称和IP--结果" + responseUtil);
        return responseUtil;
    }



    @ApiOperation(value = "查询接口趋势222")
    @PostMapping(value = "/getTrendPort")
    public ResponseUtil<List<Object>> getTrendIfXTable(@RequestBody TrendPortVo trendPortVo){
//        System.out.println("查询接口趋势--请求" + jsonObject);
        log.info("查询接口趋势--请求:" + trendPortVo);

        List<Speed> speeds = new ArrayList<>();
        List<Object> dataList = new ArrayList<>();
        ResponseUtil<List<Object>> responseUtil = new ResponseUtil<>();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();
        if(null == trendPortVo){
            meta.setCode(RESULT_CODE_FAILURE);
            meta.setMessage(RESULT_MESSAGE_FAILURE);
            responseUtil.setMeta(meta);
            return responseUtil;
        }
//        String start_time = (String) jsonObject.get("start_time");
//        String end_time = (String) jsonObject.get("end_time");
//        List ip_ifName = (List) jsonObject.get("ip_ifName");

        String start_time = trendPortVo.getStart_time();
        String end_time = trendPortVo.getEnd_time();
        List<IpIfName> ip_ifName = trendPortVo.getIp_ifName();


//        JSONObject ip_idxs = ip_idx;
        // 解析ip_idx
        for (int i = 0; i < ip_ifName.size(); i++){
//            Map<String, Object> map = (Map<String, Object>) ip_ifName.get(i);
//            String ip = (String) map.get("ip");
//            List<String> ifNames = (List<String>) map.get("ifName");
            IpIfName ipIfName =  ip_ifName.get(i);
            String ip =  ipIfName.getIp();
            List<String> ifNames = ipIfName.getIfName();
            String ifName = "";
            if (null != ifNames && ifNames.size() > 0){
                for (int j = 0; j < ifNames.size(); j++){
                    ifName = ifNames.get(j);
                    String idx = viewService.getIdxByIpAndIfName(ip, ifName);
                    speeds = viewService.getViewTrendIfXTableSpeed(ip, idx, start_time, end_time);
                    Map<String, Object> dataMap = new HashMap<>();
                    dataMap.put("ip_ifName", ip + "_" + ifName);
                    dataMap.put("speed", speeds);
                    dataList.add(dataMap);
                }
            } else {
                speeds = viewService.getViewTrendIfXTableSpeed(ip, ifName, start_time, end_time);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("ip_ifName", ip + "_" + ifName);
                dataMap.put("speed", speeds);
                dataList.add(dataMap);
            }
        }

        try {
            meta.setCode(RESULT_CODE_SUCCESS);
            meta.setMessage(RESULT_MESSAGE_SUCCESS);
            responseUtil.setData(dataList);
            responseUtil.setMeta(meta);
        } catch (Exception e){
            log.error("[查询接口趋势异常]" + e);
        }
        log.info("查询接口趋势--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "查询CPU利用率前10设备")
    @PostMapping("/getCpuTop10Device")
    public ResponseUtil<List<CPUTop10Device>> getCpuTop10Device() {
        log.info("cpu利用率排名前十的设备信息");

        List<CPUTop10Device> cpuTop10 = viewService.getCPUTop10();
        ResponseUtil<List<CPUTop10Device>> responseUtil = ResponseUtil.generate(cpuTop10);
        log.info("查询cpu利用率排名前十的设备信息--结果" + responseUtil);
        return responseUtil;
    }



    @ApiOperation(value = "查询内存利用率前10设备")
    @PostMapping("/getMemTop10Device")
    public ResponseUtil<List<MemTop10Device>> getMemTop10Device() {
        log.info("内存利用率排名前十的设备信息");

        List<MemTop10Device> memTop10Device = viewService.getMemTop10Device();
        ResponseUtil<List<MemTop10Device>> responseUtil = ResponseUtil.generate(memTop10Device);
        log.info("查询内存利用率排名前十的设备信息--结果" + responseUtil);
        return responseUtil;
    }


    @ApiOperation(value = "查询上行带宽利用率前10设备")
    @PostMapping("/getInOctetsTop10Device")
    public ResponseUtil<List<InOctetsTop10>> getInoctetsTop10() {
        log.info("上行带宽利用率排名前十的设备信息");

        List<InOctetsTop10> inOctetsTop10Dev = viewService.getInOctetsTop10Dev();
        ResponseUtil<List<InOctetsTop10>> responseUtil = ResponseUtil.generate(inOctetsTop10Dev);
        log.info("查询上行带宽利用率利用率排名前十的设备信息--结果" + responseUtil);
        return responseUtil;
    }


    @ApiOperation(value = "查询下行带宽利用率前10设备")
    @PostMapping("/getOutOctetsTop10Device")
    public ResponseUtil<List<OutOctetsTop10>> getOutoctetsTop10() {
        log.info("下行带宽利用率排名前十的设备信息");

        List<OutOctetsTop10> outOctetsTop10Dev = viewService.getOutOctetsTop10Dev();
        ResponseUtil<List<OutOctetsTop10>> responseUtil = ResponseUtil.generate(outOctetsTop10Dev);
        log.info("查询下行带宽利用率利用率排名前十的设备信息--结果" + responseUtil);
        return responseUtil;
    }


    @ApiOperation(value = "查询设备健康度")
    @PostMapping("/getDeviceStatus")
    public ResponseUtil<DeviceStatus> getDeviceStatus() {
        log.info("设备健康度");

        DeviceStatus deviceStatus = viewService.getDeviceStatus();
        ResponseUtil<DeviceStatus> responseUtil = ResponseUtil.generate(deviceStatus);
        log.info("查询设备健康度--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "查询端口健康度")
    @GetMapping("/getPortStatus")
    public ResponseUtil<PortStatus> getPortStatus() {
        log.info("端口健康度");

        PortStatus portStatus = viewService.getPortStatus();

        ResponseUtil<PortStatus> responseUtil = ResponseUtil.generate(portStatus);

        log.info("查询端口健康度--结果" + responseUtil);
        return responseUtil;
    }


    @ApiOperation(value = "查询设备端口运行状态")
    @GetMapping("getPortRunningStatus")
    public ResponseUtil<List<TreeModel>> getPortRunningStatus(
            @RequestParam(value = "machineSite",required = false)String machineSite){

        log.info("端口运行状态检查");
        ResponseUtil<List<TreeModel>> responseUtil =
                ResponseUtil.generate(viewService.getPortRunningStatus(machineSite));

        log.info("端口运行状态检查--结果" + responseUtil);
        return responseUtil;

    }

    @ApiOperation(value = "查询设备运行状态")
    @GetMapping("getDevRunningStatus")
    public ResponseUtil<List<TreeModel>> getDevRunningStatus(
            @RequestParam(value = "machineSite",required = false)String machineSite){

        log.info("端口运行状态检查");
        ResponseUtil<List<TreeModel>> responseUtil =
                ResponseUtil.generate(viewService.getDevRunningStatus(machineSite));

        log.info("端口运行状态检查--结果" + responseUtil);
        return responseUtil;

    }

    @ApiOperation(value = "下拉框-- 查询机房设备端口 -- 树形")
    @GetMapping("getViewSiteDevPort")
    public ResponseUtil<List<ViewSiteDevPortVo>> getViewSiteDevPort(){
        log.info("下拉框查询机房设备端口");
        ResponseUtil<List<ViewSiteDevPortVo>> responseUtil =
                ResponseUtil.generate(viewService.getViewSiteDevPort());
        log.info("下拉框查询机房设备端口--结果" + responseUtil);
        return responseUtil;

    }

    @ApiOperation(value = "查询端口信息 -- 多IP、端口")
    @PostMapping(value = "/getIpPorts")
    public ResponseUtil<PageRsp<ViewPortInfoVo>> getIpPorts(
            @RequestBody DevSitePortVo devSitePortVo,
            @RequestParam(value="currentPage", required=false) Integer currentPage,
            @RequestParam(value="pageSize", required = false) Integer pageSize)
            throws Exception {

        System.out.println("--\n" + devSitePortVo.toString() + "\n--");
        log.info("查询端口信息 -- 多IP、端口 devSitePortVo:" + devSitePortVo +  ",currentPage:"+ currentPage +",pageSize:" + pageSize);

        PagingUtil.validatePageParam(currentPage, pageSize);

        ResponseUtil<PageRsp<ViewPortInfoVo>> responseUtil = new ResponseUtil<>();
        ResponseUtil.Meta meta = new ResponseUtil.Meta();

        try {
            PageRsp<ViewPortInfoVo> ipPorts = viewService.getDevPorts(devSitePortVo, currentPage, pageSize);
            meta.setCode(RESULT_CODE_SUCCESS);
            meta.setMessage(RESULT_MESSAGE_SUCCESS);
            responseUtil.setData(ipPorts);
            responseUtil.setMeta(meta);
        } catch (Exception e){
            meta.setCode(RESULT_CODE_FAILURE);
            meta.setMessage(RESULT_MESSAGE_FAILURE);
            log.error("[查询端口信息 -- 多IP、端口]" + e);
        }

        log.info("查询端口信息 -- 多IP、端口--结果" + responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "监控设备状态")
    @GetMapping("/monitorDevStatus")
    public ResponseUtil<MonitorDevStatusVo> monitorDevStatus(){
        log.info("监控设备状态");
        MonitorDevStatusVo devNumInfo = viewService.getDevNumInfo();
        ResponseUtil<MonitorDevStatusVo> responseUtil = ResponseUtil.generate(devNumInfo);
        log.info("监控设备状态--结果"+responseUtil);
        return responseUtil;
    }

    @ApiOperation(value = "监控端口状态")
    @GetMapping("/monitorPortStatus")
    public ResponseUtil<MonitorPortStatus> monitorPortStatus(){
        log.info("监控端口状态");
        ResponseUtil<MonitorPortStatus> responseUtil = ResponseUtil.generate(viewService.getMonitorPortStatus());
        log.info("监控端口状态--结果"+responseUtil);
        return responseUtil ;
    }

    @ApiOperation(value = "监控事件")
    @GetMapping("/monitorAlarmEvent")
    public ResponseUtil<AlarmEventInfoVo> monitorAlarmEvent(){
        log.info("监控事件信息");
        List<AlarmEventInfo> alarmEventInfo = viewService.getAlarmEventInfo();
        AlarmEventInfoVo alarmEventInfoVo = new AlarmEventInfoVo(alarmEventInfo);
        ResponseUtil<AlarmEventInfoVo> responseUtil = ResponseUtil.generate(alarmEventInfoVo);
        log.info("监控告警事件信息--结果"+responseUtil);
        return responseUtil ;
    }


    @ApiOperation(value = "监控告警状态")
    @GetMapping("/monitorAlarmStatus")
    public ResponseUtil<AlarmEventStatus> monitorAlarmStatus(){
        log.info("监控告警状态");
        List<AlarmReceive> alarmRec = viewService.getAlarmInfo();
        int alarmNum=alarmRec.size();
        int motalAlarmNum=0;
        int servereAlarmNum=0;
        int nomalAlarmNum=0;
        int undefinedNum=0;
        for (AlarmReceive alarmReceive : alarmRec) {
            if(alarmReceive != null){
                if(!StringUtils.isEmpty(alarmReceive.getSeverity()))
                {
                    String severity =alarmReceive.getSeverity() ;
                    switch (severity) {
                        case "2":
                            nomalAlarmNum++;
                            break;
                        case "3":
                            servereAlarmNum++;
                            break;
                        case "4":
                            motalAlarmNum++;
                            break;
                        default:
                            undefinedNum++;
                            break;
                    }
                }else{
                    undefinedNum++;
                }
            }

        }
        AlarmEventStatus alarmEventStatus = new AlarmEventStatus().setAlarmNum(alarmNum).setMotalAlarmNum(motalAlarmNum)
                .setSevereAlarmNum(servereAlarmNum).setNomalAlarmNum(nomalAlarmNum).setUndefinedNum(undefinedNum);
        ResponseUtil<AlarmEventStatus> responseUtil = ResponseUtil.generate(alarmEventStatus);
        log.info("监控告警状态--结果"+responseUtil);
        return responseUtil;
    }

}
