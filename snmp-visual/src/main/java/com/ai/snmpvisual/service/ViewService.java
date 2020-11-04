package com.ai.snmpvisual.service;

import com.ai.snmpvisual.model.*;
import com.ai.snmpvisual.util.PageRsp;
import com.ai.snmpvisual.vo.*;

import java.util.List;
import java.util.Map;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/7/6 16:06
 */
public interface ViewService {

    PageRsp<ViewSysNameCpuMemorySlot> getViewSysNameCpuMemorySlot(ViewSysNameCpuMemorySlot viewSysNameCpuMemorySlot, Integer currentPage, Integer pageSize);

    PageRsp<ViewIfTableIfXTable> getViewIfTableIfXTable(ViewIfTableIfXTable viewIfTableIfXTable, Integer currentPage, Integer pageSize);

    PageRsp<ViewIfTableIfXTableNow> getViewIfTableIfXTableNow(ViewIfTableIfXTableNow viewIfTableIfXTableNow, Integer currentPage, Integer pageSize);

    PageRsp<ViewTrendIfXTable> getViewTrendIfXTable(ViewTrendIfXTable viewTrendIfXTable, Integer currentPage, Integer pageSize);

    PageRsp<ViewTrendInetCidrRouteNumber> getViewTrendInetCidrRouteNumber(ViewTrendInetCidrRouteNumber viewTrendInetCidrRouteNumber, Integer currentPage, Integer pageSize);

    List<Speed> getViewTrendIfXTableSpeed(String dev_ip, String idx, String start_time, String end_time);

    PageRsp<ViewPortInfoVo> getPortInfo(String sys_name, String dev_ip, String if_name, String oper_status, Integer currentPage, Integer pageSize);

    PageRsp<ViewRouteManage> getViewRouteManage(ViewRouteManageDTO viewRouteManageDTO, Integer currentPage, Integer pageSize);

    List<ViewInterfaceNameIp> getViewInterfaceNameIp(String dev_ip);

    List<DevIPAndNameVo> getDevIpAndName();

    List<String> getIfNameByIpOrSysName(String sysName, String devIp);

    String getIdxByIpAndIfName(String ip, String ifName);

    List<CPUTop10Device> getCPUTop10();

    List<MemTop10Device> getMemTop10Device();

    List<InOctetsTop10> getInOctetsTop10Dev();

    List<OutOctetsTop10> getOutOctetsTop10Dev();

    DeviceStatus getDeviceStatus();

    PortStatus getPortStatus();

    List<TreeModel>  getPortRunningStatus(String machineSite);

    List<TreeModel> getDevRunningStatus(String machineSite);

    List<ViewSiteDevPortVo> getViewSiteDevPort();

//    PageRsp<ViewPortInfoVo> getIpPorts(List<IpPortsReq> ipPortsReqs, Integer currentPage, Integer pageSize);

    PageRsp<ViewPortInfoVo> getDevPorts(DevSitePortVo devSitePortVo, Integer currentPage, Integer pageSize) throws Exception;


//    PageRsp<ViewSiteDevPortRsp> getViewSiteDevPortRsp(String devName, String devIp, String portName, String devStatus, String devSite, String portStatus, Integer currentPage, Integer pageSize);

    MonitorDevStatusVo getDevNumInfo();

    MonitorPortStatus getMonitorPortStatus();

    List<AlarmEventInfo> getAlarmEventInfo();

    List<ViewSiteDevSlot> getViewSiteDevSlot();

    List<AlarmReceive> getAlarmInfo();
}
