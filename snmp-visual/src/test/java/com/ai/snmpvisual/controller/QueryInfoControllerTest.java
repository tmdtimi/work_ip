package com.ai.snmpvisual.controller;

import com.ai.snmpvisual.service.ViewService;
import com.ai.snmpvisual.vo.DevIPAndNameVo;
import com.ai.snmpvisual.vo.GetIfNameReq;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.LinkedList;



@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class QueryInfoControllerTest {

    @Mock
    ViewService viewService;

    @InjectMocks
    QueryInfoController queryInfoController;


    @Test
    void getDevIpAndName() {
        DevIPAndNameVo devIPAndNameVo = new DevIPAndNameVo();
        devIPAndNameVo.setDevIp("10.20.16.107");
        devIPAndNameVo.setSysName("HUAWEI");
        LinkedList<DevIPAndNameVo> devIPAndNameVos = new LinkedList<>();
        Mockito.when(viewService.getDevIpAndName()).thenReturn(devIPAndNameVos);
        queryInfoController.getDevIpAndName();
    }

    @Test
    void getIfNameByIpOrSysName() {
        GetIfNameReq getIfNameReq = new GetIfNameReq();
        String sysName="HuaWei";
        String devIp="10.21.13.52";
        String ifname="";
        getIfNameReq.setDevIp(devIp);
        getIfNameReq.setSysName(sysName);
        LinkedList<String> strings = new LinkedList<>();
        strings.add(ifname);
        Mockito.when(viewService.getIfNameByIpOrSysName(sysName,devIp)).thenReturn(strings);
        queryInfoController.getIfNameByIpOrSysName(getIfNameReq);
    }
}