package com.ai.snmpvisual.service;

import com.ai.snmpvisual.model.ViewH3cSysnameCpuMemorySlot;
import com.ai.snmpvisual.model.Device;
import com.ai.snmpvisual.util.PageRsp;
import com.ai.snmpvisual.vo.DevSiteSlotVo;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/8/3 20:50
 */
public interface H3CViewService {

    PageRsp<ViewH3cSysnameCpuMemorySlot> getViewH3cSysnameCpuMemorySlot(ViewH3cSysnameCpuMemorySlot viewH3cSysnameCpuMemorySlot, Integer currentPage, Integer pageSize);

    PageRsp<Device> getDeviceInfo(Integer currentPage, Integer pageSize);

    PageRsp<Device> getIpSlots(DevSiteSlotVo devSiteSlotVo, Integer currentPage, Integer pageSize);
}
