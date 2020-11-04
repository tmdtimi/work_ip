package com.ai.snmpvisual.controller;

import com.ai.snmpvisual.model.*;
import com.ai.snmpvisual.service.ViewService;
import com.ai.snmpvisual.util.PageRsp;
import com.ai.snmpvisual.vo.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ViewControllerTest {

    @InjectMocks
    private ViewController viewController;

    @Mock
    private ViewService viewService;

    @Mock
    private ViewMapper viewMapper;


    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getViewSysNameCpuMemorySlot() throws Exception {
        ViewSysNameCpuMemorySlot viewSysNameCpuMemorySlot=new ViewSysNameCpuMemorySlot("10.20.16.107","HUAWEI","1.3","16","16",
                "15","4294967295","4294967295","0",
                "0","0","0","8209342464","6523572224",
                "IPU slot 3","0","0","2","2");
        Integer currentPage=0;
        Integer pageSize=1;
        LinkedList<ViewSysNameCpuMemorySlot> viewSysNameCpuMemorySlots = new LinkedList<>();
        viewSysNameCpuMemorySlots.add(viewSysNameCpuMemorySlot);
        PageRsp<ViewSysNameCpuMemorySlot> viewSysNameCpuMemorySlotPageRsp = new PageRsp<>();
        viewSysNameCpuMemorySlotPageRsp.setResults(viewSysNameCpuMemorySlots);
        System.out.println(viewSysNameCpuMemorySlot.toString());
        when(viewService.getViewSysNameCpuMemorySlot(viewSysNameCpuMemorySlot,currentPage,pageSize)).thenReturn(viewSysNameCpuMemorySlotPageRsp);
        viewController.getViewSysNameCpuMemorySlot(viewSysNameCpuMemorySlot,currentPage,pageSize);
    }


    @Test
    void getViewIfTableIfXTable() throws Exception {
        ViewIfTableIfXTable viewIfTableIfXTable = new ViewIfTableIfXTable();
        Integer currentPage=0;
        Integer pageSize=1;
        LinkedList<ViewIfTableIfXTable> viewIfTableIfXTables = new LinkedList<>();
        viewIfTableIfXTables.add(viewIfTableIfXTable);
        PageRsp<ViewIfTableIfXTable> viewIfTableIfXTablePage = new PageRsp<>();
        viewIfTableIfXTablePage.setResults(viewIfTableIfXTables);
        when(viewService.getViewIfTableIfXTable(viewIfTableIfXTable,currentPage,pageSize)).thenReturn(viewIfTableIfXTablePage);
        viewController.getViewIfTableIfXTable(viewIfTableIfXTable,currentPage,pageSize);

    }

    @Test
    void getViewIfTableIfXTableNow() throws Exception {
        ViewIfTableIfXTableNow viewIfTableIfXTableNow = new ViewIfTableIfXTableNow();
        Integer currentPage=0;
        Integer pageSize=1;
        LinkedList<ViewIfTableIfXTableNow> viewIfTableIfXTableNows = new LinkedList<>();
        viewIfTableIfXTableNows.add(viewIfTableIfXTableNow);
        PageRsp<ViewIfTableIfXTableNow> viewIfTableIfXTableNowPageRsp = new PageRsp<>();
        viewIfTableIfXTableNowPageRsp.setResults(viewIfTableIfXTableNows);
        when(viewService.getViewIfTableIfXTableNow(viewIfTableIfXTableNow,currentPage,pageSize)).thenReturn(viewIfTableIfXTableNowPageRsp);
        viewController.getViewIfTableIfXTableNow(viewIfTableIfXTableNow,currentPage,pageSize);
    }

    @Test
    void getViewTrendIfXTable() throws Exception {
        ViewTrendIfXTable viewTrendIfXTable = new ViewTrendIfXTable();
        Integer currentPage=0;
        Integer pageSize=0;
        LinkedList<ViewTrendIfXTable> viewTrendIfXTables = new LinkedList<>();
        viewTrendIfXTables.add(viewTrendIfXTable);
        PageRsp<ViewTrendIfXTable> viewTrendIfXTablePageRsp = new PageRsp<>();
        viewTrendIfXTablePageRsp.setResults(viewTrendIfXTables);
        when(viewService.getViewTrendIfXTable(viewTrendIfXTable,currentPage,pageSize)).thenReturn(viewTrendIfXTablePageRsp);
        viewController.getViewTrendIfXTable(viewTrendIfXTable,currentPage,pageSize);
    }

    @Test
    void getViewRateIfXTable() throws Exception {
        ViewTrendIfXTable viewTrendIfXTable = new ViewTrendIfXTable();
        Integer currentPage=0;
        Integer pageSize=0;
        LinkedList<ViewTrendIfXTable> viewTrendIfXTables = new LinkedList<>();
        viewTrendIfXTables.add(viewTrendIfXTable);
        PageRsp<ViewTrendIfXTable> viewTrendIfXTablePageRsp = new PageRsp<>();
        viewTrendIfXTablePageRsp.setResults(viewTrendIfXTables);
        when(viewService.getViewTrendIfXTable(viewTrendIfXTable,currentPage,pageSize)).thenReturn(viewTrendIfXTablePageRsp);
        viewController.getViewRateIfXTable(viewTrendIfXTable,currentPage,pageSize);
    }

    @Test
    void getViewTrendInetCidrRouteNumber() throws Exception {
        ViewTrendInetCidrRouteNumber viewTrendInetCidrRouteNumber = new ViewTrendInetCidrRouteNumber();
        Integer currentPage=0;
        Integer pageSize=1;
        LinkedList<ViewTrendInetCidrRouteNumber> viewTrendInetCidrRouteNumbers = new LinkedList<>();
        viewTrendInetCidrRouteNumbers.add(viewTrendInetCidrRouteNumber);
        PageRsp<ViewTrendInetCidrRouteNumber> viewTrendInetCidrRouteNumberPageRsp = new PageRsp<>();
        viewTrendInetCidrRouteNumberPageRsp.setResults(viewTrendInetCidrRouteNumbers);
        when(viewService.getViewTrendInetCidrRouteNumber(viewTrendInetCidrRouteNumber,currentPage,pageSize)).thenReturn(viewTrendInetCidrRouteNumberPageRsp);
        viewController.getViewTrendInetCidrRouteNumber(viewTrendInetCidrRouteNumber,currentPage,pageSize);
    }

    @Test
    void getViewTrendIfXTableSpeed() {
        String devIp="";
        String idx="";
        String startTime="";
        String endTime="";
        Speed speed = new Speed();
        List<Speed> speeds = new LinkedList<>();
        speeds.add(speed);
        when(viewService.getViewTrendIfXTableSpeed(devIp,idx,startTime,endTime)).thenReturn(speeds);
        viewController.getViewTrendIfXTableSpeed(devIp,idx,startTime,endTime);
    }

    @Test
    void getPortInfo() throws Exception {
        String sysName="HUAWEI";
        String devIp="10.20.16.107";
        String ifName="GigabitEthernet0/3/0";
        String operStatus="1";
        Integer currenPage=0;
        Integer pageSize=1;
        PortInfoReq portInfoReq = new PortInfoReq();
        portInfoReq.setDev_ip(devIp);
        portInfoReq.setIf_name(ifName);
        portInfoReq.setOper_status(operStatus);
        portInfoReq.setSys_name(sysName);
        ViewPortInfoVo viewPortInfo = new ViewPortInfoVo();
        LinkedList<ViewPortInfoVo> viewPortInfoVos = new LinkedList<>();
        viewPortInfoVos.add(viewPortInfo);
        PageRsp<ViewPortInfoVo> viewPortInfoPageRsp = new PageRsp<>();
        viewPortInfoPageRsp.setResults(viewPortInfoVos);
        when(viewService.getPortInfo(sysName,devIp,ifName,operStatus,currenPage,pageSize)).thenReturn(viewPortInfoPageRsp);
        viewController.getPortInfo(portInfoReq,currenPage,pageSize);
    }

    @Test
    void getViewRouteManage() throws Exception {
        ViewRouteManageDTO viewRouteManageDTO = new ViewRouteManageDTO();
        viewRouteManageDTO.setDestIp("10.20.16.107");
        viewRouteManageDTO.setStartTime("2020-09-18");
        viewRouteManageDTO.setEndTime("2020-09-18");
        ViewRouteManage viewRouteManage = new ViewRouteManage();
        List<ViewRouteManage> viewRouteManages = new LinkedList<>();
        viewRouteManages.add(viewRouteManage);
        PageRsp<ViewRouteManage> viewRouteManagePageRsp = new PageRsp<>();
        viewRouteManagePageRsp.setResults(viewRouteManages);
        when(viewService.getViewRouteManage(viewRouteManageDTO,0,1)).thenReturn(viewRouteManagePageRsp);
        viewController.getViewRouteManage(viewRouteManageDTO,0,1);
    }

    @Test
    void getViewInterfaceNameIp() {
        String devIp="10.20.16.107";
        ViewInterfaceNameIp viewInterfaceNameIp = new ViewInterfaceNameIp();
        viewInterfaceNameIp.setDevIp("10.20.16.107");
        viewInterfaceNameIp.setIfName("GigabitEthernet0/3/0");
        viewInterfaceNameIp.setIpAddr("");
        viewInterfaceNameIp.setMask("");
        List<ViewInterfaceNameIp> list=new LinkedList<>();
        list.add(viewInterfaceNameIp);
        when(viewService.getViewInterfaceNameIp(devIp)).thenReturn(list);
        viewController.getViewInterfaceNameIp(devIp);
    }

    @Test
    void getTrendIfXTable() {
        String ip="10.20.16.107";
        String ifName="GigabitEthernet0/3/0";
        String idx="";
        String startTime="";
        String endTime="";
        String res1="ok!";
        Speed speed = new Speed();
        List<Speed> speedList=new ArrayList<>();
        speedList.add(speed);
        TrendPortVo trendPortVo = new TrendPortVo();
        IpIfName ipIfName = new IpIfName();
        ipIfName.setIp("");
        List<String> ifNamelist=new LinkedList<>();
        ifNamelist.add(ifName);
        ipIfName.setIfName(ifNamelist);
        List<IpIfName> ipIfNameList=new LinkedList<>();
        ipIfNameList.add(ipIfName);
        trendPortVo.setIp_ifName(ipIfNameList);
        trendPortVo.setStart_time("2020-09-18");
        trendPortVo.setEnd_time("2020-09-18");
        when(viewService.getIdxByIpAndIfName(ip,ifName)).thenReturn(res1);
        when(viewService.getViewTrendIfXTableSpeed(ip,idx,startTime,endTime)).thenReturn(speedList);
        viewController.getTrendIfXTable(trendPortVo);
    }


    @Test
    void getCpuTop10Device() {
        CPUTop10Device cpuTop10Device = new CPUTop10Device();
        cpuTop10Device.setDevIp("10.20.16.107");
        cpuTop10Device.setDevDuty("21");
        cpuTop10Device.setSysName("HUAWEI");
        cpuTop10Device.setSlotDesc("IPU slot 3");
        List<CPUTop10Device> list=new ArrayList<>();
        list.add(cpuTop10Device);
        when(viewService.getCPUTop10()).thenReturn(list);
        viewController.getCpuTop10Device();
    }

    @Test
    void getMemTop10Device() {
        MemTop10Device memTop10Device = new MemTop10Device();
        memTop10Device.setDevIp("10.20.16.107");
        memTop10Device.setDevDuty("21");
        memTop10Device.setSysName("HUAWEI");
        memTop10Device.setSlotDesc("IPU slot 3");
        List<MemTop10Device> list=new ArrayList<>();
        list.add(memTop10Device);
        when(viewService.getMemTop10Device()).thenReturn(list);
        viewController.getMemTop10Device();
    }

    @Test
    void getInoctetsTop10() {
        InOctetsTop10 inOctetsTop10 = new InOctetsTop10();
        inOctetsTop10.setIfName("GigabitEthernet0/3/0");
        inOctetsTop10.setIp("192,.1681.122.1");
        inOctetsTop10.setDevDuty("0.1");
        inOctetsTop10.setSysName("HUAWEI");
        List<InOctetsTop10> list=new ArrayList<>();
        list.add(inOctetsTop10);
        when(viewService.getInOctetsTop10Dev()).thenReturn(list);
        viewController.getInoctetsTop10();
    }

    @Test
    void getOutoctetsTop10() {
        OutOctetsTop10 outOctetsTop10 = new OutOctetsTop10();
        outOctetsTop10.setIfName("GigabitEthernet0/3/0");
        outOctetsTop10.setIp("192,.1681.122.1");
        outOctetsTop10.setDevDuty("0.1");
        outOctetsTop10.setSysName("HUAWEI");
        List<OutOctetsTop10> list=new ArrayList<>();
        list.add(outOctetsTop10);
        when(viewService.getOutOctetsTop10Dev()).thenReturn(list);
        viewController.getOutoctetsTop10();

    }

    @Test
    void getDeviceStatus() {
        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setAmount(9);
        deviceStatus.setNomalDev(8);
        deviceStatus.setAbNomalDev(1);
        when(viewService.getDeviceStatus()).thenReturn(deviceStatus);
        viewController.getDeviceStatus();
    }

    @Test
    void getPortStatus() {
        PortStatus portStatus = new PortStatus();
        portStatus.setAmountDev(9);
        portStatus.setNomalDev(8);
        portStatus.setAbNomalDev(1);
        when(viewService.getPortStatus()).thenReturn(portStatus);
        viewController.getPortStatus();
    }


}