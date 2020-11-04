package com.ai.snmpvisual.service.impl;

import com.ai.snmpvisual.model.*;
import com.ai.snmpvisual.repository.mapper.ViewMapper;
import com.ai.snmpvisual.service.ViewService;
import com.ai.snmpvisual.util.PageRsp;
import com.ai.snmpvisual.util.PagingUtil;
import com.ai.snmpvisual.util.UseRate;
import com.ai.snmpvisual.vo.*;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/7/6 16:04
 */
@Service
@Slf4j
public class ViewServiceImpl implements ViewService {

    // 端口的状态
    private final static String ONE = "1";
    private final static String TWO = "2";
    private final static String UP = "up";
    private final static String DOWN = "down";
    private final static String ABNORMAL = "abnormal";
    private static Pattern pattern = Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$");


    @Autowired
    ViewMapper viewMapper;

    @Override
    public PageRsp<ViewSysNameCpuMemorySlot> getViewSysNameCpuMemorySlot(ViewSysNameCpuMemorySlot viewSysNameCpuMemorySlot, Integer currentPage, Integer pageSize) {
        try {
            return PagingUtil.GeneratePageRsp(viewMapper.getViewSysNameCpuMemorySlot(viewSysNameCpuMemorySlot, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize),
                    viewMapper.countNumViewSysNameCpuMemorySlot(),
                    currentPage,
                    pageSize);
        } catch (Exception e) {
            log.error("查询失败" + e);
            return null;
        }
    }


    @Override
    public PageRsp<ViewIfTableIfXTable> getViewIfTableIfXTable(ViewIfTableIfXTable viewIfTableIfXTable, Integer currentPage, Integer pageSize) {
        try {
            return PagingUtil.GeneratePageRsp(viewMapper.getViewIfTableIfXTable(viewIfTableIfXTable, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize),
                    viewMapper.countNumViewIfTableIfXTable(),
                    currentPage,
                    pageSize);
        } catch (Exception e) {
            log.error("查询失败" + e);
            return null;
        }
    }

    @Override
    public PageRsp<ViewIfTableIfXTableNow> getViewIfTableIfXTableNow(ViewIfTableIfXTableNow viewIfTableIfXTableNow, Integer currentPage, Integer pageSize) {
        try {
            return PagingUtil.GeneratePageRsp(viewMapper.getViewIfTableIfXTableNow(viewIfTableIfXTableNow, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize),
                    viewMapper.countNumViewIfTableIfXTableNow(),
                    currentPage,
                    pageSize);
        } catch (Exception e) {
            log.error("查询失败" + e);
            return null;
        }
    }

    @Override
    public PageRsp<ViewTrendIfXTable> getViewTrendIfXTable(ViewTrendIfXTable viewTrendIfXTable, Integer currentPage, Integer pageSize) {
        try {

            return PagingUtil.GeneratePageRsp(viewMapper.getViewTrendIfXTable(viewTrendIfXTable, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize),
                    viewMapper.countNumViewTrendIfXTable(),
                    currentPage,
                    pageSize);
        } catch (Exception e) {
            log.error("查询失败" + e);
            return null;
        }
    }

    @Override
    public PageRsp<ViewTrendInetCidrRouteNumber> getViewTrendInetCidrRouteNumber(ViewTrendInetCidrRouteNumber viewTrendInetCidrRouteNumber, Integer currentPage, Integer pageSize) {
        try {
            return PagingUtil.GeneratePageRsp(viewMapper.getViewTrendInetCidrRouteNumber(viewTrendInetCidrRouteNumber, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize),
                    viewMapper.countNumViewTrendInetCidrRouteNumber(),
                    currentPage,
                    pageSize);
        } catch (Exception e) {
            log.error("查询失败" + e);
            return null;
        }
    }

    @Override
    public List<Speed> getViewTrendIfXTableSpeed(String dev_ip, String idx, String start_time, String end_time) {
        List<ViewTrendIfXTable> trendIfXTables = null;
        IfXTableSpeed ifXTableSpeed = new IfXTableSpeed();
        List<Speed> speeds = new ArrayList<>();
        try {
            trendIfXTables = viewMapper.getTrendIfxTable(dev_ip, idx, start_time, end_time);
            if (null == trendIfXTables) {
                log.error("[查询失败]");
                throw new InterruptedException("[查询失败]");
            }
            if (trendIfXTables.size() == 0) {
                return speeds;
            }
            long ifHCInOctets1 = 0L;
            long ifHCInOctets2 = 0L;
            long ifHCOutOctets1 = 0L;
            long ifHCOutOctets2 = 0L;
            Date updateTime1 = new Date();
            Date updateTime2 = new Date();
            int ifHighSpeed = 0;
            List<String> useRateIns = new ArrayList<>();
            List<String> useRateOuts = new ArrayList<>();
            List<String> speedRateIns = new ArrayList<>();
            List<String> speedRateOuts = new ArrayList<>();
            List<String> times = new ArrayList<>();

            DecimalFormat df = new DecimalFormat("0.00");
            for (int i = 0; i < (trendIfXTables.size() - 1); i++) {
                ViewTrendIfXTable viewTrendIfXTable1 = trendIfXTables.get(i);
                if (null == viewTrendIfXTable1.getInOctets()) {
                    continue;
                }
                ifHCInOctets1 = Long.valueOf(viewTrendIfXTable1.getInOctets());
                ifHCOutOctets1 = Long.valueOf(viewTrendIfXTable1.getOutOctets());
                String time1 = viewTrendIfXTable1.getTime();
                updateTime1 = StringToDate(time1);
                ViewTrendIfXTable viewTrendIfXTable2 = trendIfXTables.get(i + 1);
                if (null == viewTrendIfXTable2.getInOctets()) {
                    continue;
                }
                ifHCInOctets2 = Long.valueOf(viewTrendIfXTable2.getInOctets());
                ifHCOutOctets2 = Long.valueOf(viewTrendIfXTable2.getOutOctets());
                String time2 = viewTrendIfXTable2.getTime();
                updateTime2 = StringToDate(time2);
                ifHighSpeed = Integer.parseInt(viewTrendIfXTable1.getBandwith());
                int datediff = (int) ((updateTime1.getTime() - updateTime2.getTime()) / 1000);
                String useRateIn = "0";
                String useRateOut = "0";
                String speedRateIn = "0";
                String speedRateOut = "0";

                if (ifHighSpeed != 0) {
                    useRateIn = df.format((float) ((ifHCInOctets1 - ifHCInOctets2) * 8) * 100 / (datediff * ifHighSpeed) / 1000000);
                    useRateOut = df.format((float) ((ifHCOutOctets1 - ifHCOutOctets2) * 8) * 100 / (datediff * ifHighSpeed) / 1000000);
                } else {
                    useRateIn = "0";
                    useRateOut = "0";
                }
                speedRateIn = df.format((float) ((ifHCInOctets1 - ifHCInOctets2) * 8) / datediff);
                speedRateOut = df.format((float) ((ifHCOutOctets1 - ifHCOutOctets2) * 8) / datediff);

                useRateIns.add(useRateIn);
                useRateOuts.add(useRateOut);
                speedRateIns.add(speedRateIn);
                speedRateOuts.add(speedRateOut);
                times.add(time1);
            }
            Speed speed = new Speed();
            speed.setUseRateIn(useRateIns);
            speed.setUseRateOut(useRateOuts);
            speed.setSpeedRateIn(speedRateIns);
            speed.setSpeedRateOut(speedRateOuts);
            speed.setTime(times);
            speeds.add(speed);
            ifXTableSpeed.setIfXTableSpeed(speeds);
        } catch (Exception e) {
            log.error("计算接口速率失败");
            log.error("Exception msg:{} \ncall stack: ", e.getMessage(), e);
        }
        return speeds;
    }

    /**
     * 查询端口信息
     *
     * @param sys_name
     * @param dev_ip
     * @param if_name
     * @param oper_status
     * @return
     */
    @Override
    public PageRsp<ViewPortInfoVo> getPortInfo(String sys_name, String dev_ip, String if_name, String oper_status, Integer currentPage, Integer pageSize) {
        List<ViewPortInfo> viewPortInfos = new ArrayList<>();
        List<ViewPortInfoVo> viewPortInfoVos = new ArrayList<>();
        // 统计数量，用于分页
        Integer countNumPortInfo = 0;
        try {
            String admin_status1 = "";
            String oper_status1 = "";
            if (oper_status == null || ("").equals(oper_status)) {
                oper_status = UP;
            }
            if (oper_status.equals(UP)) {
                admin_status1 = "1";
                oper_status1 = "1";
                viewPortInfos = viewMapper.getPortInfo(sys_name, dev_ip, if_name, admin_status1, oper_status1, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize);
                countNumPortInfo = viewMapper.countNumViewPortInfo(sys_name, dev_ip, if_name, admin_status1, oper_status1);
            } else if (oper_status.equals(DOWN)) {
                admin_status1 = "2";
                oper_status1 = "2";
                viewPortInfos = viewMapper.getPortInfo(sys_name, dev_ip, if_name, admin_status1, oper_status1, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize);
                countNumPortInfo = viewMapper.countNumViewPortInfo(sys_name, dev_ip, if_name, admin_status1, oper_status1);
            } else if (oper_status.equals(ABNORMAL)) {
                viewPortInfos = viewMapper.getPortInfoAbnormal(sys_name, dev_ip, if_name, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize);
                countNumPortInfo = viewMapper.countNumViewPortInfoAbnormal(sys_name, dev_ip, if_name);
            } else {
                countNumPortInfo = viewMapper.countNumViewPortInfoNoState(sys_name, dev_ip, if_name);
            }

            if (null == viewPortInfos || viewPortInfos.size() < 1) {
                return null;
            }
            for (ViewPortInfo viewPoreInfo : viewPortInfos) {
                String devIp = viewPoreInfo.getIp();
                String ifName = viewPoreInfo.getIfName();
                if (null == viewPoreInfo.getInOctets()) {
                    viewPoreInfo.setInOctets("0");
                }
                if (null == viewPoreInfo.getOutOctets()) {
                    viewPoreInfo.setOutOctets("0");
                }
                if (null == ifName || "".equals(ifName)) {
                    continue;
                }
                if (null == viewPoreInfo.getInOctets() || null == viewPoreInfo.getOutOctets()) {
                    continue;
                }

                ViewPortInfoVo viewPortInfoVo = new ViewPortInfoVo();
                BeanUtils.copyProperties(viewPoreInfo, viewPortInfoVo);

                // 状态  adminStatus： 接口的理想状态   operStatus：当前接口的操作状态
                String adminStatus = viewPoreInfo.getAdminStatus();
                String operStatus = viewPoreInfo.getOperStatus();
                /*
                    规则： 理想状态和操作状态：
                    1、都为 1（up）,则状态为up，
                    2、都为2（down）,则状态为down，
                    3、其中一个为1、另一个为2，则状态为abnormal
                    4、其他： 为abnormal
                 */
                if (adminStatus.equals("1") && operStatus.equals("1")) {
                    viewPortInfoVo.setOperStatus(UP);
                } else if (adminStatus.equals("2") && operStatus.equals("2")) {
                    viewPortInfoVo.setOperStatus(DOWN);
                } else if ((adminStatus.equals("1") && operStatus.equals("2")) || (adminStatus.equals("2") && operStatus.equals("1"))) {
                    viewPortInfoVo.setOperStatus(ABNORMAL);
                } else {
                    log.info("状态不符合预期，adminStatus： " + adminStatus + ", operStatus：" + operStatus);
                    viewPortInfoVo.setOperStatus(ABNORMAL);
                }
                // 计算带宽利用率、接口速率
                UseRate useRate = bandwidthUseRate(devIp, ifName);

                // 将计算的结果赋值
                viewPortInfoVo.setUseRateIn(useRate.getUseRateIn());
                viewPortInfoVo.setUseRateOut(useRate.getUseRateOut());
                viewPortInfoVo.setInOctets(useRate.getInOctetsRes());
                viewPortInfoVo.setOutOctets(useRate.getOutOctetsRes());
                viewPortInfoVos.add(viewPortInfoVo);
            }
            return PagingUtil.GeneratePageRsp(viewPortInfoVos, countNumPortInfo, currentPage, pageSize);
        } catch (Exception e) {
            log.error("Exception msg:{} \ncall stack: ", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public PageRsp<ViewRouteManage> getViewRouteManage(ViewRouteManageDTO viewRouteManageDTO, Integer currentPage, Integer pageSize) {
        try {
            return PagingUtil.GeneratePageRsp(viewMapper.getRouteManageInfo(viewRouteManageDTO, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize),
                    viewMapper.countNumViewRouteManage(viewRouteManageDTO),
                    currentPage,
                    pageSize);
        } catch (Exception e) {
            log.error("查询失败" + e);
            return null;
        }
    }

    @Override
    public List<ViewInterfaceNameIp> getViewInterfaceNameIp(String dev_ip) {
        List<ViewInterfaceNameIp> list = viewMapper.getViewInterfaceNameIp(dev_ip);
        return list;
    }

    @Override
    public List<DevIPAndNameVo> getDevIpAndName() {
        return viewMapper.getDevIpAndName();
    }

    @Override
    public List<String> getIfNameByIpOrSysName(String sysName, String devIp) {
        return viewMapper.getIfNameByIpOrSysName(sysName, devIp);
    }

    @Override
    public String getIdxByIpAndIfName(String ip, String ifName) {
        return viewMapper.getIdxByIpAndIfName(ip, ifName);
    }


    /**
     * 计算CPU利用率的top10设备
     *
     * @return List<CPUTop10Device>
     */
    @Override
    public List<CPUTop10Device> getCPUTop10() {
        List<Device> cpuTop10 = viewMapper.getCPUTop10();
        List<CPUTop10Device> list = new LinkedList<>();
        for (Device device : cpuTop10) {
            CPUTop10Device top10Device = new CPUTop10Device(device);
            list.add(top10Device);
        }
        return list;
    }

    /**
     * 计算内存使用率的top10设备
     *
     * @return List<MemTop10Device>
     */
    @Override
    public List<MemTop10Device> getMemTop10Device() {
        List<Device> hwMemTop10 = viewMapper.getHwMemTop10();
        List<Device> h3cMemTop10 = viewMapper.getH3cMemTop10();
        List<Device> zteMemTop10 = viewMapper.getZteMemTop10();
        Queue<MemTop10Device> queueTop10s = new PriorityQueue<>(cMem);
        List<MemTop10Device> memTop10Devices = new LinkedList<>();

        if (!CollectionUtils.isEmpty(hwMemTop10)) {
            for (Device device : hwMemTop10) {
                MemTop10Device memTop10Device = new MemTop10Device(device);
                queueTop10s.add(memTop10Device);
            }
        }
        if (!CollectionUtils.isEmpty(h3cMemTop10)) {
            for (Device device : h3cMemTop10) {
                MemTop10Device memTop10Device = new MemTop10Device(device);
                queueTop10s.offer(memTop10Device);
            }
        }
        if (!CollectionUtils.isEmpty(zteMemTop10)) {
            for (Device device : zteMemTop10) {
                MemTop10Device memTop10Device = new MemTop10Device(device);
                queueTop10s.offer(memTop10Device);
            }
        }

        int i = 0;
        while (i < 10) {
            if (queueTop10s.peek() != null) {
                memTop10Devices.add(queueTop10s.poll());
                i++;
            } else {
                break;
            }
        }

        return memTop10Devices;
    }

    /**
     * 上行利用率设备top10
     *
     * @return List<InOctetsTop10>
     */
    @Override
    public List<InOctetsTop10> getInOctetsTop10Dev() {
        List<PortInfoVo> portInfoVo = viewMapper.getPortInfoVo();
        Queue<InOctetsTop10> inQueue = new PriorityQueue<>(cInOctets);
        List<InOctetsTop10> inOctetsTop10List = new LinkedList<>();
        for (PortInfoVo infoVo : portInfoVo) {
            String sysName = infoVo.getSysName();
            String ip = infoVo.getIp();
            String ifName = infoVo.getIfName();
            UseRate useRate = null;
            try {
                useRate = bandwidthUseRate(ip, ifName);
            } catch (Exception e) {
                //e.printStackTrace();
                log.error("Exception msg:{} \ncall stack: ", e.getMessage(), e );
            }
            if (useRate != null) {
                String useRateIn = useRate.getUseRateIn();
                Matcher matcher = pattern.matcher(useRateIn);
                if (matcher.matches()) {
                    InOctetsTop10 inOctetsTop10 = new InOctetsTop10(sysName, ip, ifName, useRateIn);
                    inQueue.offer(inOctetsTop10);
                } else {
                    useRateIn = "0.00";
                    InOctetsTop10 inOctetsTop10 = new InOctetsTop10(sysName, ip, ifName, useRateIn);
                    inQueue.offer(inOctetsTop10);
                }

            }
        }
        int i = 0;
        while (i < 10) {
            if (inQueue.peek() != null) {
                inOctetsTop10List.add(inQueue.poll());
                i++;
            } else {
                break;
            }
        }
        return inOctetsTop10List;

    }

    /**
     * 下行利用率设备top10
     *
     * @return List<OutOctetsTop10>
     */
    @Override
    public List<OutOctetsTop10> getOutOctetsTop10Dev() {
        List<PortInfoVo> portInfoVo = viewMapper.getPortInfoVo();
        Queue<OutOctetsTop10> outQueue = new PriorityQueue<>(cOutOctets);
        List<OutOctetsTop10> outOctetsTop10List = new LinkedList<>();
        for (PortInfoVo infoVo : portInfoVo) {
            String sysName = infoVo.getSysName();
            String ip = infoVo.getIp();
            String ifName = infoVo.getIfName();
            UseRate useRate = null;
            try {
                useRate = bandwidthUseRate(ip, ifName);
            } catch (Exception e) {
                //e.printStackTrace();
                log.error("Exception msg:{} \ncall stack: ", e.getMessage(), e );
            }
            if (useRate != null) {
                String useRateOut = useRate.getUseRateOut();
                Matcher matcher = pattern.matcher(useRateOut);
                if (matcher.matches()) {
                    OutOctetsTop10 outOctetsTop10 = new OutOctetsTop10(sysName, ip, ifName, useRateOut);
                    outQueue.offer(outOctetsTop10);
                } else {
                    useRateOut = "0.00";
                    OutOctetsTop10 outOctetsTop10 = new OutOctetsTop10(sysName, ip, ifName, useRateOut);
                    outQueue.offer(outOctetsTop10);
                }

            }
        }
        int i = 0;
        while (i < 10) {
            if (outQueue.peek() != null) {
                outOctetsTop10List.add(outQueue.poll());
                i++;
            } else {
                break;
            }
        }
        return outOctetsTop10List;
    }

    /**
     * 设备健康度
     *
     * @return DeviceStatus
     */
    @Override
    public DeviceStatus getDeviceStatus() {
        List<Device> deviceInfo = viewMapper.getDeviceInfo();
        DeviceStatus deviceStatus = new DeviceStatus(0, 0, 0);
        for (Device device : deviceInfo) {
            deviceStatus.setAmount(deviceStatus.getAmount() + 1);
            String cpuDevDuty = device.getCpuDevDuty();
            String devIp = device.getDevIp();
            String hwMemoryDevSize64 = device.getHwMemoryDevSize64();
            String hwMemoryDevFree64 = device.getHwMemoryDevFree64();
            String h3cMemory = device.getH3cMemory();
            String zteUsedMemory = device.getZteUsedMemory();
            String zteTotalMemory = device.getZteTotalMemory();
            String connectivity = viewMapper.getConnectivity(devIp);
            String memDevDuty = "";
            if (!StringUtils.isEmpty(hwMemoryDevFree64) && !StringUtils.isEmpty(hwMemoryDevSize64)) {
                BigDecimal hwMemFree = new BigDecimal(hwMemoryDevFree64);
                BigDecimal hwMemSize = new BigDecimal(hwMemoryDevSize64);
                BigDecimal rate = (hwMemSize.subtract(hwMemFree)).divide(hwMemSize, 3, BigDecimal.ROUND_CEILING);
                memDevDuty = (rate.multiply(new BigDecimal(100))).toString();
            } else if (!StringUtils.isEmpty(zteTotalMemory) && !StringUtils.isEmpty(zteUsedMemory)) {
                BigDecimal zteUsedMem = new BigDecimal(zteUsedMemory);
                BigDecimal zteTotalMem = new BigDecimal(zteTotalMemory);
                BigDecimal rate = zteUsedMem.divide(zteTotalMem, 5, BigDecimal.ROUND_CEILING);
                memDevDuty = (rate.multiply(new BigDecimal(100))).toString();
            } else if (!StringUtils.isEmpty(h3cMemory)) {
                BigDecimal h3cMem = new BigDecimal(h3cMemory);
                BigDecimal h3cTotalMem = new BigDecimal("800000000000");
                BigDecimal rate = h3cMem.divide(h3cTotalMem, 5, BigDecimal.ROUND_CEILING);
                memDevDuty = (rate.multiply(new BigDecimal(100))).toString();
            } else {
                memDevDuty = String.valueOf(0);
            }
            if (!StringUtils.isEmpty(connectivity) && "1".equals(connectivity) &&
                    Double.parseDouble(memDevDuty) < 70 && Double.parseDouble(cpuDevDuty) < 70) {
                deviceStatus.setNomalDev(deviceStatus.getNomalDev() + 1);
            } else {
                deviceStatus.setAbNomalDev(deviceStatus.getAbNomalDev() + 1);
            }
        }
        return deviceStatus;
    }

    /**
     * 端口健康度
     *
     * @return PortStatus
     */
    @Override
    public PortStatus getPortStatus() {
        List<ViewPortInfo> portInfo = viewMapper.getPortInfo();
        PortStatus portStatus = new PortStatus(0, 0, 0);
        for (ViewPortInfo viewPortInfo : portInfo) {
            portStatus.setAmountDev(portStatus.getAmountDev() + 1);
            String ip = viewPortInfo.getIp();
            String ifName = viewPortInfo.getIfName();
            String adminStatus = viewPortInfo.getAdminStatus();
            String operStatus = viewPortInfo.getOperStatus();
            UseRate useRate = null;
            try {
                useRate = bandwidthUseRate(ip, ifName);
            } catch (Exception e) {
                //e.printStackTrace();
                log.error("Exception msg:{} \ncall stack: ", e.getMessage(), e );
            }
            if (useRate != null) {
                String useRateIn = useRate.getUseRateIn();
                Matcher matcherIn = pattern.matcher(useRateIn);
                if (!matcherIn.matches()) {
                    useRateIn = "0.00";
                }
                String useRateOut = useRate.getUseRateOut();
                Matcher matcher = pattern.matcher(useRateOut);
                if (!matcher.matches()) {
                    useRateOut = "0.00";
                }
                double useRateInD = Double.parseDouble(useRateIn);
                double useRateOutD = Double.parseDouble(useRateOut);
                if (useRateInD > 70 || useRateOutD > 70 || ("1".equals(adminStatus) && "2".equals(operStatus))) {
                    portStatus.setAbNomalDev(portStatus.getAbNomalDev() + 1);
                } else {
                    portStatus.setNomalDev(portStatus.getNomalDev() + 1);
                }
            }
        }
        return portStatus;
    }


    /**
     * 将String类型转换成date类型
     *
     * @param dateStr 日期字符串
     * @throws ParseException 转换异常
     */
    public static Date StringToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateStr);
        return date;
    }

    /**
     * 计算流入流出的带宽利用率、速率
     */
    public UseRate bandwidthUseRate(String devIp, String ifName) throws Exception {
        log.info("开始计算带宽、速率, devIp:" + devIp + ", ifname:" + ifName);

        String useRateIn = "0";
        String useRateOut = "0";
        String inOctetsRes = "0";
        String outOctetsRes = "0";

        long inOctets1 = 0L;
        long outOctets1 = 0L;
        long inOctets2 = 0L;
        long outOctets2 = 0L;

        List<ViewTrendIfXTable> viewTrendIfXTables = viewMapper.getViewTrendIfXTableByIPAndIfName(devIp, ifName);
        if (null == viewTrendIfXTables || viewTrendIfXTables.size() <= 1) {

        } else {
            ViewTrendIfXTable viewTrendIfXTable = viewTrendIfXTables.get(0);
            String xInOctets1 = viewTrendIfXTable.getInOctets() != null ? viewTrendIfXTable.getInOctets() : "0";
            String xOutOctets1 = viewTrendIfXTable.getOutOctets() != null ? viewTrendIfXTable.getOutOctets() : "0";
            inOctets1 = Long.valueOf(xInOctets1);
            outOctets1 = Long.valueOf(xOutOctets1);
            String time1 = viewTrendIfXTable.getTime();

            ViewTrendIfXTable viewTrendIfXTable2 = viewTrendIfXTables.get(1);
            String xInOctets2 = viewTrendIfXTable2.getInOctets() != null ? viewTrendIfXTable2.getInOctets() : "0";
            String xOutOctets2 = viewTrendIfXTable2.getOutOctets() != null ? viewTrendIfXTable2.getOutOctets() : "0";

            inOctets2 = Long.valueOf(xInOctets2);
            outOctets2 = Long.valueOf(xOutOctets2);
            String time2 = viewTrendIfXTable2.getTime();
            Date updateTime2 = StringToDate(time2);
            Date updateTime1 = StringToDate(time1);
            int bandWith = Integer.parseInt(viewTrendIfXTable.getBandwith());
            int datediff = (int) ((updateTime1.getTime() - updateTime2.getTime()) / 1000);

            // 计算带宽利用率
            DecimalFormat df = new DecimalFormat("0.00");
            if (bandWith == 0) {
                useRateIn = "-";
                useRateOut = "-";
            } else {
                useRateIn = calculateInBandwidthUseRate(datediff, inOctets1, inOctets2, bandWith);
                useRateOut = calculateInBandwidthUseRate(datediff, outOctets1, outOctets2, bandWith);
            }

            if (datediff == 0) {
                inOctetsRes = "0";
                outOctetsRes = "0";
            } else {
                inOctetsRes = df.format((float) ((inOctets1 - inOctets2) * 8) / datediff);
                outOctetsRes = df.format((float) ((outOctets1 - outOctets2) * 8) / datediff);
            }
        }

        UseRate useRate = new UseRate();
        useRate.setInOctetsRes(inOctetsRes);
        useRate.setOutOctetsRes(outOctetsRes);
        useRate.setUseRateIn(useRateIn);
        useRate.setUseRateOut(useRateOut);
        return useRate;
    }

    /**
     * 计算带宽利用率
     */
    public String calculateInBandwidthUseRate(int datediff, long Octets1, long Octets2, int bandWith) {
        String useRate = "0";
        DecimalFormat df = new DecimalFormat("0.00");
        if (datediff == 0) {
            useRate = "0";
        } else {
            useRate = df.format((float) ((Octets1 - Octets2) * 8) * 100 / (datediff * bandWith) / 1000000);
        }
        return useRate;
    }


    /**
     * 内存排序
     */
    static Comparator<MemTop10Device> cMem = new Comparator<MemTop10Device>() {
        @Override
        public int compare(MemTop10Device o1, MemTop10Device o2) {
            if (Double.parseDouble(o2.getDevDuty()) - Double.parseDouble(o1.getDevDuty()) > 0) {
                return 1;
            } else if (Double.parseDouble(o2.getDevDuty()) == Double.parseDouble(o1.getDevDuty())) {
                return 0;
            }
            return -1;
        }
    };


    /**
     * 上行带宽利用率排序
     */
    static Comparator<InOctetsTop10> cInOctets = new Comparator<InOctetsTop10>() {
        @Override
        public int compare(InOctetsTop10 o1, InOctetsTop10 o2) {
            if (Double.parseDouble(o2.getDevDuty()) - Double.parseDouble(o1.getDevDuty()) >= 0) {
                return 1;
            } else if (Double.parseDouble(o2.getDevDuty()) == Double.parseDouble(o1.getDevDuty())) {
                return 0;
            }
            return -1;
        }
    };


    /**
     * 下行带宽利用率排序
     */
    static Comparator<OutOctetsTop10> cOutOctets = new Comparator<OutOctetsTop10>() {
        @Override
        public int compare(OutOctetsTop10 o1, OutOctetsTop10 o2) {
            if (Double.parseDouble(o2.getDevDuty()) - Double.parseDouble(o1.getDevDuty()) >= 0) {
                return 1;
            } else if (Double.parseDouble(o2.getDevDuty()) == Double.parseDouble(o1.getDevDuty())) {
                return 0;
            }
            return -1;
        }
    };


    @Override
    public List<TreeModel> getPortRunningStatus(String machineSite) {

        List<ViewDevSite> devSites = viewMapper.getPortRunningStatus(machineSite);

        return null == devSites ? null : convert(devSites);

    }

    @Override
    public List<TreeModel> getDevRunningStatus(String machineSite) {

        List<ViewDevSite> devSites = viewMapper.getDevRunningStatus(machineSite);

        return null == devSites ? null : convert(devSites);

    }

    @Override
    public List<ViewSiteDevPortVo> getViewSiteDevPort() {
        List<ViewSiteDevPortVo> list = new ArrayList<>();
        List<ViewSiteDevPort> viewSiteDevPorts = viewMapper.getViewSiteDevPort();
        for (ViewSiteDevPort view : viewSiteDevPorts) {
            ViewSiteDevPortVo viewPortInfoVo = new ViewSiteDevPortVo();
            BeanUtils.copyProperties(view, viewPortInfoVo);

            // 状态  adminStatus： 接口的理想状态   operStatus：当前接口的操作状态
            String adminStatus = view.getPortAdminStatus();
            String operStatus = view.getPortOperStatus();
            /*
                规则： 理想状态和操作状态：
                1、都为 1（up）,则状态为up，
                2、都为2（down）,则状态为down，
                3、其中一个为1、另一个为2，则状态为abnormal
                4、其他： 为abnormal
             */
            if (adminStatus.equals("1") && operStatus.equals("1")) {
                viewPortInfoVo.setPortStatus(UP);
            } else if (adminStatus.equals("2") && operStatus.equals("2")) {
                viewPortInfoVo.setPortStatus(DOWN);
            } else if ((adminStatus.equals("1") && operStatus.equals("2")) || (adminStatus.equals("2") && operStatus.equals("1"))) {
                viewPortInfoVo.setPortStatus(ABNORMAL);
            } else {
                log.info("状态不符合预期，adminStatus： " + adminStatus + ", operStatus：" + operStatus);
                viewPortInfoVo.setPortStatus(ABNORMAL);
            }
            list.add(viewPortInfoVo);
        }
        return list;
    }

    @Override
    public PageRsp<ViewPortInfoVo> getDevPorts(DevSitePortVo devSitePortVo, Integer currentPage, Integer pageSize) throws Exception {
        // 统计数量，用于分页
        Integer countNumPortInfo = 0;
        List<ViewPortInfo> viewSiteDevPorts = new ArrayList<>();
        List<ViewPortInfoVo> viewPortInfoVos = new ArrayList<>();

        try {
            if (devSitePortVo != null) {
//                String devSite = devSitePortVo.getDevSite();
                String devIp = devSitePortVo.getDevIp();
//                String portStatus = devSitePortVo.getPortStatus();
                List<DevPort> devPorts = devSitePortVo.getDevPorts();

                if (devPorts != null && devPorts.size() > 0) {
                    // 根据devPorts 查询
                    viewSiteDevPorts = viewMapper.getDevSitePortByIpAndPort(devPorts, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize);
                    countNumPortInfo = viewMapper.getDevPortNumByIpAndPort(devPorts);
                } else {
                    // 根据 devIp 查询
                    viewSiteDevPorts = viewMapper.getDevSitePortByIp(devIp, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize);
                    countNumPortInfo = viewMapper.getDevPortNum(devIp);
                }
            } else {
                viewSiteDevPorts = viewMapper.getAllDevPort((Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize);
                countNumPortInfo = viewMapper.getAllDevPortNum();
            }

            log.info("查询的端口参数：" + viewSiteDevPorts.toString() + ",数量" + countNumPortInfo);

            if (null == viewSiteDevPorts || viewSiteDevPorts.size() < 1) {
                return null;
            }
            for (ViewPortInfo viewPoreInfo : viewSiteDevPorts) {
                String devIp = viewPoreInfo.getIp();
                String ifName = viewPoreInfo.getIfName();
                if (null == viewPoreInfo.getInOctets()) {
                    viewPoreInfo.setInOctets("0");
                }
                if (null == viewPoreInfo.getOutOctets()) {
                    viewPoreInfo.setOutOctets("0");
                }
                if (null == ifName || "".equals(ifName)) {
                    continue;
                }
                if (null == viewPoreInfo.getInOctets() || null == viewPoreInfo.getOutOctets()) {
                    continue;
                }

                ViewPortInfoVo viewPortInfoVo = new ViewPortInfoVo();
                BeanUtils.copyProperties(viewPoreInfo, viewPortInfoVo);

                // 状态  adminStatus： 接口的理想状态   operStatus：当前接口的操作状态
                String adminStatus = viewPoreInfo.getAdminStatus();
                String operStatus = viewPoreInfo.getOperStatus();
                /*
                    规则： 理想状态和操作状态：
                    1、都为 1（up）,则状态为up，
                    2、都为2（down）,则状态为down，
                    3、其中一个为1、另一个为2，则状态为abnormal
                    4、其他： 为abnormal
                 */
                log.info("状态为adminStatus:" + adminStatus + ", operStatus:" + operStatus);
                if (adminStatus.equals("1") && operStatus.equals("1")) {
                    viewPortInfoVo.setOperStatus(UP);
                } else if (adminStatus.equals("2") && operStatus.equals("2")) {
                    viewPortInfoVo.setOperStatus(DOWN);
                } else if ((adminStatus.equals("1") && operStatus.equals("2")) || (adminStatus.equals("2") && operStatus.equals("1"))) {
                    viewPortInfoVo.setOperStatus(ABNORMAL);
                } else {
                    log.info("状态不符合预期，adminStatus： " + adminStatus + ", operStatus：" + operStatus);
                    viewPortInfoVo.setOperStatus(ABNORMAL);
                }
                // 计算带宽利用率、接口速率
                UseRate useRate = bandwidthUseRate(devIp, ifName);

                // 将计算的结果赋值
                viewPortInfoVo.setUseRateIn(useRate.getUseRateIn());
                viewPortInfoVo.setUseRateOut(useRate.getUseRateOut());
                viewPortInfoVo.setInOctets(useRate.getInOctetsRes());
                viewPortInfoVo.setOutOctets(useRate.getOutOctetsRes());
                viewPortInfoVos.add(viewPortInfoVo);
            }
            return PagingUtil.GeneratePageRsp(viewPortInfoVos, countNumPortInfo, currentPage, pageSize);
        } catch (Exception e) {
            log.error("Exception msg:{} \ncall stack: ", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public MonitorDevStatusVo getDevNumInfo() {
        List<MonitorDevStatus> devNumInfo = viewMapper.getDevNumInfo();
        int devNum = devNumInfo.size();
        int onlineNum=0;
        int offlineNum=0;
        Date createTime=devNumInfo.get(0).getCreateDate();
        for (MonitorDevStatus monitorDevStatus : devNumInfo) {
            int connectivity = monitorDevStatus.getConnectivity();
            Date createDate = monitorDevStatus.getCreateDate();
            if(connectivity==0 || connectivity==-1){
                offlineNum++;
            }else if(connectivity==1){
                onlineNum++;
            }
            int compare=createDate.compareTo(createTime);
            if(compare<0){
                createTime=createDate;
            }
        }
        MonitorDevStatusVo monitorDevStatusVo = new MonitorDevStatusVo(devNum,onlineNum,offlineNum,createTime);
        return monitorDevStatusVo;

    }


    @Override
    public MonitorPortStatus getMonitorPortStatus() {
        List<ViewPortInfo> allPortInfo = viewMapper.getFocusPortInfo();
        int portNum = viewMapper.getAllPortNum();
        int outThreshold=Integer.parseInt(viewMapper.getDownThreshold());
        int inThreshold=Integer.parseInt(viewMapper.getUpThreshold());
        int focusPortNum=allPortInfo.size();
        int upPortNum=0;
        int downPortNum=0;
        int abnomalPortNum=0;
        int inOverThreshodNum=0;
        int outOverThreshodNum=0;
        String timeDiff = getTimeDIff(allPortInfo.get(0).getTime());
        String adminStatus="";
        String operStatus="";
        String devIp="";
        String ifName="";
        UseRate useRate=null;
        String useRateIn="0";
        String useRateOut="0";
        for (ViewPortInfo viewPortInfo : allPortInfo) {
            adminStatus=viewPortInfo.getAdminStatus();
            operStatus=viewPortInfo.getOperStatus();
            devIp=viewPortInfo.getIp();
            ifName=viewPortInfo.getIfName();
            if (adminStatus.equals("1") && operStatus.equals("1")) {
                upPortNum++;
            } else if (adminStatus.equals("2") && operStatus.equals("2")) {
                downPortNum++;
            } else if ((adminStatus.equals("1") && operStatus.equals("2")) || (adminStatus.equals("2") && operStatus.equals("1"))) {
                abnomalPortNum++;
            } else {
                log.info("状态不符合预期，adminStatus： " + adminStatus + ", operStatus：" + operStatus);
                abnomalPortNum++;
            }
            try {
                useRate= bandwidthUseRate(devIp, ifName);
                useRateIn = useRate.getUseRateIn();
                useRateOut = useRate.getUseRateOut();
                if(pattern.matcher(useRateIn).matches() && pattern.matcher(useRateOut).matches()){
                    int useRateInVal = (int) Double.parseDouble(useRateIn)*100;
                    int useRateOutVal=(int) Double.parseDouble(useRateOut)*100;
                    if(useRateInVal> inThreshold){
                        inOverThreshodNum++;
                    }
                    if(useRateOutVal>outThreshold){
                        outOverThreshodNum++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return new MonitorPortStatus().setPortNum(portNum).setFocusPortNum(focusPortNum)
                .setUpPortNum(upPortNum).setDownPortNum(downPortNum).setAbnomalPortNum(abnomalPortNum)
                .setInOverThreshodNum(inOverThreshodNum).setOutOverThreshodNum(outOverThreshodNum)
                .setTimeDiff(timeDiff);

    }

    @Override
    public List<AlarmEventInfo> getAlarmEventInfo() {
        return viewMapper.getAlarmEventInfo();
    }



    private static String getTimeDIff(String createTime) {
        Date currentTime=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        String timeDiff="";
        if(createTime != null){
            String time_2 = format.format(currentTime);
            Date begin = null;
            Date end =null;
            try {
                begin= format.parse(createTime);
                end=format.parse(time_2);
                diff = end.getTime()-begin.getTime();
                day = diff / nd;// 计算差多少天
                hour = diff % nd / nh + day * 24;// 计算差多少小时
                min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
                sec = diff % nd % nh % nm / ns;// 计算差多少秒
                timeDiff=day+"天"+(hour - day * 24)+"小时"+(min - day * 24 * 60)+"分钟"+sec+"秒";
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return timeDiff;
    }

    private List<TreeModel> convert(List<ViewDevSite> devSites) {

        List<TreeModel> list = new ArrayList<>();

        for (ViewDevSite devSite : devSites) {

            String location = devSite.getSite();
            List<ViewDevSite.DevInfo> devInfos = devSite.getDevInfos();

            TreeModel treeModel1 = new TreeModel(location);

            for (ViewDevSite.DevInfo devInfo : devInfos) {

                String devName = devInfo.getDevName();
                String devIp = devInfo.getDevIp();
                Integer devStatus = devInfo.getDevStatus();
                List<ViewDevSite.PortInfo> portInfos = devInfo.getPortInfos();

                TreeModel treeModel2 = getTreeModel(treeModel1, devStatus == 1 ? "onLine" : "offLine");
                TreeModel treeModel3 = getTreeModel(treeModel2, devIp + "-" + devName);

                if (portInfos == null) {
                    continue;
                }

                for (ViewDevSite.PortInfo portInfo : portInfos) {

                    String portStatus;
                    String status1 = portInfo.getPortAdminStatus();
                    String status2 = portInfo.getPortOperStatus();
                    String portName = portInfo.getPortName();

                    if (status1.equals("1") && status2.equals("1")) {
                        portStatus = "up";
                    } else if (status1.equals("2") && status2.equals("2")) {
                        portStatus = "down";
                    } else {
                        portStatus = "abnormal";
                    }

                    TreeModel treeModel4 = getTreeModel(treeModel3, portStatus);

                    treeModel4.getChildren().add(new TreeModel(portName));
                }

            }

            list.add(treeModel1);

        }
        return list;
    }

    private TreeModel getTreeModel(TreeModel treeModel, String label) {

        TreeModel res = null;

        for (TreeModel tm : treeModel.getChildren()) {
            if (tm.getLabel().equals(label)) {
                res = tm;
                break;
            }
        }

        if (res == null) {
            res = new TreeModel(label);
            treeModel.getChildren().add(res);
        }

        return res;

    }


    @Override
    public List<ViewSiteDevSlot> getViewSiteDevSlot() {
//        List<ViewSiteDevPort> viewSiteDevPorts = viewMapper.getViewSiteDevPort();
        List<ViewSiteDevSlot> viewSiteDevSlots = viewMapper.getViewSiteDevSlot();
        return viewSiteDevSlots;
    }

    @Override
    public List<AlarmReceive> getAlarmInfo() {
        return viewMapper.getAlarmInfo();
    }
}
