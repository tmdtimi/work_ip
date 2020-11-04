package com.ai.snmpvisual.vo;

import com.ai.snmpvisual.model.*;
import com.ai.snmpvisual.model.Device;
import com.ai.snmpvisual.vo.DevIPAndNameVo;
import com.ai.snmpvisual.vo.PortInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    public Integer countNumViewPortInfo(@Param("sys_name") String sys_name, @Param("ip") String ip, @Param("if_name") String if_name, @Param("oper_status") String oper_status);

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

    List<ViewPortInfo> getPortInfo(@Param("sys_name") String sys_name, @Param("ip") String ip, @Param("if_name") String if_name, @Param("oper_status") String oper_status, @Param("offSet") Integer offSet, @Param("pageSize") Integer pageSize);


    List<ViewTrendIfXTable> getViewTrendIfXTableByIPAndIfName(@Param("ip") String ip, @Param("if_name") String if_name);

    List<ViewH3cSysnameCpuMemorySlot> getH3CViewSysNameCpuMemorySlot(@Param("obj") ViewH3cSysnameCpuMemorySlot viewH3cSysnameCpuMemorySlot, @Param("offSet") Integer offSet,
                                                                     @Param("pageSize") Integer pageSize);


    List<Device> getDeviceInfo(@Param("offSet") Integer offSet,
                               @Param("pageSize") Integer pageSize);

    List<Device> getDeviceInfo();


    List<ViewRouteManage> getRouteManageInfo(@Param("obj") ViewRouteManageDTO viewRouteManageDTO,
                                             @Param("offSet") Integer offSet,
                                             @Param("pageSize") Integer pageSize);


    public Integer countNumViewRouteManage(@Param("obj") ViewRouteManageDTO viewRouteManageDTO);


    List<ViewInterfaceNameIp> getViewInterfaceNameIp(@Param("dev_ip") String dev_ip);

    List<DevIPAndNameVo> getDevIpAndName();

    List<String> getIfNameByIpOrSysName(@Param("sys_name") String sys_name, @Param("ip") String ip);

    List<Device> getCPUTop10();

    List<Device> getHwMemTop10();

    List<Device> getH3cMemTop10();

    List<Device> getZteMemTop10();

    List<PortInfoVo> getPortInfoVo();

    String getConnectivity(@Param("dev_ip") String dev_ip);

    List<ViewPortInfo> getPortInfo();

}
