package com.ai.snmpvisual.service.impl;

import com.ai.snmpvisual.model.ViewH3cSysnameCpuMemorySlot;
import com.ai.snmpvisual.model.ViewPortInfo;
import com.ai.snmpvisual.model.ViewPortInfoVo;
import com.ai.snmpvisual.repository.mapper.ViewMapper;
import com.ai.snmpvisual.model.Device;
import com.ai.snmpvisual.service.H3CViewService;
import com.ai.snmpvisual.util.PageRsp;
import com.ai.snmpvisual.util.PagingUtil;
import com.ai.snmpvisual.vo.DevPort;
import com.ai.snmpvisual.vo.DevSiteSlotVo;
import com.ai.snmpvisual.vo.DevSlot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/8/3 20:50
 */
@Service
@Slf4j
public class H3CViewServiceImpl implements H3CViewService {

    @Autowired
    ViewMapper viewMapper;

    @Override
    public PageRsp<ViewH3cSysnameCpuMemorySlot> getViewH3cSysnameCpuMemorySlot(ViewH3cSysnameCpuMemorySlot viewH3cSysnameCpuMemorySlot, Integer currentPage, Integer pageSize) {
        try {
            return PagingUtil.GeneratePageRsp(viewMapper.getH3CViewSysNameCpuMemorySlot(viewH3cSysnameCpuMemorySlot, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage-1) * pageSize, pageSize),
                    viewMapper.countNumViewH3cSysnameCpuMemorySlot(),
                    currentPage,
                    pageSize);
        } catch (Exception e) {
            log.error("查询失败" + e);
            return null;
        }
    }

    @Override
    public PageRsp<Device> getDeviceInfo(Integer currentPage, Integer pageSize) {
        try {
            return PagingUtil.GeneratePageRsp(viewMapper.getDeviceInfo((Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage-1) * pageSize, pageSize),
                    viewMapper.getViewDeviceInfoNum(),
                    currentPage,
                    pageSize);
        } catch (Exception e) {
            log.error("查询失败" + e);
            return null;
        }
    }

    @Override
    public PageRsp<Device> getIpSlots(DevSiteSlotVo devSiteSlotVo, Integer currentPage, Integer pageSize) {

        // 统计数量，用于分页
        Integer countDev = 0;
        List<Device> devices = new ArrayList<>();

        try {
            if (devSiteSlotVo != null) {
                String devIp = devSiteSlotVo.getDevIp();
                List<DevSlot> devSlots = devSiteSlotVo.getDevSlots();

                if (devSlots != null && devSlots.size() > 0) {
                    // 根据devPorts 查询
                    devices = viewMapper.getDevSiteSlotByIpAndSlot(devSlots, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize);
                    countDev = viewMapper.getDevSlotNumByIpAndSlot(devSlots);
                } else {
                    // 根据 devIp 查询
                    devices = viewMapper.getDevSiteSlotByIp(devIp, (Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize);
                    countDev = viewMapper.getDevSlotNum(devIp);
                }
            } else {
                devices = viewMapper.getAllDevSlot((Objects.isNull(currentPage) || Objects.isNull(pageSize)) ? null : (currentPage - 1) * pageSize, pageSize);
                countDev = viewMapper.getViewDeviceInfoNum();
            }

            return PagingUtil.GeneratePageRsp(devices,
                    countDev,
                    currentPage,
                    pageSize);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
