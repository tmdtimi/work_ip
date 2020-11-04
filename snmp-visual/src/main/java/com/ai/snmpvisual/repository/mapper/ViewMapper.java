package com.ai.snmpvisual.repository.mapper;

import com.ai.snmpvisual.model.*;
import com.ai.snmpvisual.model.Device;
import com.ai.snmpvisual.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/7/6 16:01
 */
@Repository
public interface ViewMapper {


    public Integer countNumViewSysNameCpuMemorySlot();

    public Integer countNumViewIfTableIfXTable();

    public Integer countNumViewIfTableIfXTableNow();

    public Integer countNumViewTrendIfXTable();

    public Integer countNumViewTrendInetCidrRouteNumber();

    public Integer countNumViewH3cSysnameCpuMemorySlot();

    public Integer getViewDeviceInfoNum();

    public Integer countNumViewPortInfo(@Param("sys_name") String sys_name,
                                        @Param("ip") String ip,
                                        @Param("if_name") String if_name,
                                        @Param("admin_status") String admin_status,
                                        @Param("oper_status") String oper_status
                                        );

    List<ViewSysNameCpuMemorySlot> getViewSysNameCpuMemorySlot(@Param("obj") ViewSysNameCpuMemorySlot viewSysNameCpuMemorySlot,
                                                               @Param("offSet") Integer offSet,
                                                               @Param("pageSize") Integer pageSize);

    List<ViewIfTableIfXTable> getViewIfTableIfXTable(@Param("obj") ViewIfTableIfXTable viewIfTableIfXTable,
                                                     @Param("offSet") Integer offSet,
                                                     @Param("pageSize") Integer pageSize);

    List<ViewIfTableIfXTableNow> getViewIfTableIfXTableNow(@Param("obj") ViewIfTableIfXTableNow viewIfTableIfXTableNow,
                                                           @Param("offSet") Integer offSet,
                                                           @Param("pageSize") Integer pageSize);

    List<ViewTrendIfXTable> getViewTrendIfXTable(@Param("obj") ViewTrendIfXTable viewTrendIfXTable,
                                                 @Param("offSet") Integer offSet,
                                                 @Param("pageSize") Integer pageSize);

    List<ViewTrendInetCidrRouteNumber> getViewTrendInetCidrRouteNumber(@Param("obj") ViewTrendInetCidrRouteNumber viewTrendInetCidrRouteNumber,
                                                                       @Param("offSet") Integer offSet,
                                                                       @Param("pageSize") Integer pageSize);

    List<ViewTrendIfXTable> getTrendIfxTable(@Param("dev_ip") String dev_ip, @Param("idx") String idx, @Param("start_time") String start_time, @Param("end_time") String end_time);

    List<ViewPortInfo> getPortInfo(@Param("sys_name") String sys_name, @Param("ip") String ip, @Param("if_name") String if_name, @Param("admin_status") String admin_status, @Param("oper_status") String oper_status, @Param("offSet") Integer offSet, @Param("pageSize") Integer pageSize);


    List<ViewTrendIfXTable> getViewTrendIfXTableByIPAndIfName(@Param("ip") String ip, @Param("if_name") String if_name);

    List<ViewH3cSysnameCpuMemorySlot> getH3CViewSysNameCpuMemorySlot(@Param("obj") ViewH3cSysnameCpuMemorySlot viewH3cSysnameCpuMemorySlot, @Param("offSet") Integer offSet,
                                                                     @Param("pageSize") Integer pageSize);


    List<Device> getDeviceInfo(@Param("offSet") Integer offSet,
                               @Param("pageSize") Integer pageSize);


    List<ViewRouteManage> getRouteManageInfo(@Param("obj") ViewRouteManageDTO viewRouteManageDTO,
                                             @Param("offSet") Integer offSet,
                                             @Param("pageSize") Integer pageSize);


    public Integer countNumViewRouteManage(@Param("obj") ViewRouteManageDTO viewRouteManageDTO);


    List<ViewInterfaceNameIp> getViewInterfaceNameIp(@Param("dev_ip") String dev_ip);

    List<DevIPAndNameVo> getDevIpAndName();

    List<String> getIfNameByIpOrSysName(@Param("sys_name") String sys_name, @Param("ip") String ip);

    public String getIdxByIpAndIfName(@Param("dev_ip") String dev_ip, @Param("if_name") String if_name);

    List<ViewPortInfo> getPortInfoAbnormal(@Param("sys_name") String sys_name, @Param("ip") String ip, @Param("if_name") String if_name, @Param("offSet") Integer offSet, @Param("pageSize") Integer pageSize);



    List<Device> getCPUTop10();

    List<Device> getHwMemTop10();

    List<Device> getH3cMemTop10();

    List<Device> getZteMemTop10();

    List<PortInfoVo> getPortInfoVo();

    String getConnectivity(@Param("dev_ip") String dev_ip);

    List<Device> getDeviceInfo();

    List<ViewPortInfo> getPortInfo();

    List<ViewDevSite> getPortRunningStatus(String machineSite);

    List<ViewDevSite> getDevRunningStatus(String machineSite);

    Integer countNumViewPortInfoAbnormal(@Param("sys_name") String sys_name,
                                         @Param("ip") String ip,
                                         @Param("if_name") String if_name);

    Integer countNumViewPortInfoNoState(@Param("sys_name") String sys_name, @Param("ip") String ip, @Param("if_name") String if_name);

    List<ViewSiteDevPort> getViewSiteDevPort();

    List<ViewSiteDevPort> getSiteDevPorts(@Param("devSite") String devSite,
                                          @Param("devStatus")String devStatus,
                                          @Param("devName")String devName,
                                          @Param("devIp")String devIp,
                                          @Param("portName")String portName,
                                          @Param("adminStatus")String adminStatus,
                                          @Param("operStatus")String operStatus,
                                          @Param("offSet")Integer offSet,
                                          @Param("pageSize")Integer pageSize);


    List<ViewPortInfo> getIpPort(@Param("sys_name") String sys_name,
                                 @Param("ip") String ip,
                                 @Param("if_names") List<String> if_names,
                                 @Param("admin_status") String admin_status,
                                 @Param("oper_status") String oper_status,
                                 @Param("offSet") Integer offSet,
                                 @Param("pageSize") Integer pageSize);

    Integer countIpPorts(@Param("sys_name") String sys_name,
                         @Param("ip") String ip,
                         @Param("if_names") List<String> if_names,
                         @Param("admin_status") String admin_status,
                         @Param("oper_status") String oper_status);


    List<ViewPortInfo> getIpPortAbnormal(@Param("sys_name") String sys_name,
                                         @Param("ip") String ip,
                                         @Param("if_names") List<String> if_names,
                                         @Param("offSet") Integer offSet,
                                         @Param("pageSize") Integer pageSize);

    Integer countIpPortAbnormal(@Param("sys_name") String sys_name,
                                @Param("ip") String ip,
                                @Param("if_names") List<String> if_names);


    Integer countIpPortNoState(@Param("sys_name") String sys_name,
                               @Param("ip") String ip,
                               @Param("if_name") List<String> if_name);



    List<ViewPortInfo> getDevSitePortByIp(@Param("devIp")String devIp,
                                             @Param("offSet") Integer offSet,
                                             @Param("pageSize") Integer pageSize);

    List<ViewPortInfo> getDevSitePortByIpAndPort(@Param("infos")List<DevPort> devPorts,
                                                    @Param("offSet") Integer offSet,
                                                    @Param("pageSize") Integer pageSize);

    Integer getDevPortNum(String devIp);

    Integer getDevPortNumByIpAndPort(@Param("infos")List<DevPort> devPorts);

    List<ViewPortInfo> getAllDevPort( @Param("offSet") Integer offSet,
                                         @Param("pageSize") Integer pageSize);

    Integer getAllDevPortNum();

    List<MonitorDevStatus> getDevNumInfo();



    List<ViewPortInfo> getFocusPortInfo();

    int getAllPortNum();


    List<AlarmEventInfo> getAlarmEventInfo();



    String getUpThreshold();

    String getDownThreshold();

    List<ViewSiteDevSlot> getViewSiteDevSlot();

    List<Device> getDevSiteSlotByIpAndSlot(@Param("infos")List<DevSlot> devSlots,
                                           @Param("offSet") Integer offSet,
                                           @Param("pageSize") Integer pageSize);

//    List<ViewPortInfo> getDevSitePortByIp(@Param("devIp")String devIp,
//                                          @Param("offSet") Integer offSet,
//                                          @Param("pageSize") Integer pageSize);

    List<Device> getDevSiteSlotByIp(@Param("devIp")String devIp,
                                    @Param("offSet") Integer offSet,
                                    @Param("pageSize") Integer pageSize);


    List<Device> getAllDevSlot( @Param("offSet") Integer offSet,
                                      @Param("pageSize") Integer pageSize);

//    Integer getDevPortNumByIpAndPort(@Param("infos")List<DevPort> devPorts);

    Integer getDevSlotNumByIpAndSlot(@Param("infos")List<DevSlot> devSlots);

//    Integer getDevPortNum(String devIp);

    Integer getDevSlotNum(String devIp);

    List<AlarmReceive> getAlarmInfo();
}
