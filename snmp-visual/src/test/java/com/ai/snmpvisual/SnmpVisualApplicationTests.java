package com.ai.snmpvisual;

import com.ai.snmpvisual.model.ViewSysNameCpuMemorySlot;
import com.ai.snmpvisual.service.ViewService;
import com.ai.snmpvisual.util.PageRsp;
import com.ai.snmpvisual.vo.PortStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SnmpVisualApplicationTests {

    @Autowired
    ViewService viewService;


//    @Test
//    void contextLoads() {
//        PortStatus portStatus = viewService.getPortStatus();
//        System.out.println(portStatus);
//    }

}
