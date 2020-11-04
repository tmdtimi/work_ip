package com.ai.snmpvisual.controller;

import com.ai.snmpvisual.model.Device;
import com.ai.snmpvisual.model.ViewH3cSysnameCpuMemorySlot;
import com.ai.snmpvisual.service.H3CViewService;
import com.ai.snmpvisual.util.PageRsp;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.LinkedList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class H3CViewControllerTest {

    @Mock
    H3CViewService h3CViewService;

    @InjectMocks
    H3CViewController h3CViewController;

    @Test
    void getViewH3cSysnameCpuMemorySlot() {
        ViewH3cSysnameCpuMemorySlot viewH3cSysnameCpuMemorySlot = new ViewH3cSysnameCpuMemorySlot();
        Integer currentPage=0;
        Integer pageSize=1;
        LinkedList<ViewH3cSysnameCpuMemorySlot> viewH3cSysnameCpuMemorySlots = new LinkedList<>();
        viewH3cSysnameCpuMemorySlots.add(viewH3cSysnameCpuMemorySlot);
        PageRsp<ViewH3cSysnameCpuMemorySlot> viewH3cSysnameCpuMemorySlotPageRsp = new PageRsp<>();
        viewH3cSysnameCpuMemorySlotPageRsp.setResults(viewH3cSysnameCpuMemorySlots);
        Mockito.when(h3CViewService.getViewH3cSysnameCpuMemorySlot(viewH3cSysnameCpuMemorySlot,currentPage,pageSize)).thenReturn(viewH3cSysnameCpuMemorySlotPageRsp);
        h3CViewController.getViewH3cSysnameCpuMemorySlot(viewH3cSysnameCpuMemorySlot,currentPage,pageSize);
    }

    @Test
    void getViewDeviceInfo() throws Exception {
        Integer currentPage=0;
        Integer pageSize=1;
        Device device = new Device();
        List<Device> devices = new LinkedList<>();
        devices.add(device);
        PageRsp<Device> devicePageRsp = new PageRsp<>();
        devicePageRsp.setResults(devices);
        Mockito.when(h3CViewService.getDeviceInfo(currentPage,pageSize)).thenReturn(devicePageRsp);
        h3CViewController.getViewDeviceInfo(currentPage,pageSize);

    }
}