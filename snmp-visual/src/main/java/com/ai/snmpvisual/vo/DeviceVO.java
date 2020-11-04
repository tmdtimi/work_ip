package com.ai.snmpvisual.vo;

import com.ai.snmpvisual.model.Device;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * @author: YiFei
 * @Description:
 * @date: 2020/8/20 3:01 下午
 */

@Setter
@Getter
@ToString
public class DeviceVO {
    public DeviceVO(){

    }

    public DeviceVO(Device device){
        BeanUtils.copyProperties(device, this);
        if (!StringUtils.isEmpty(device.getH3cMemory())){
            this.memoryUsedRate = device.getH3cMemory();
        }else if (!StringUtils.isEmpty(device.getHwMemoryDevSize64())){
            BigDecimal totalMemory = new BigDecimal(device.getHwMemoryDevSize64());
            BigDecimal freeMemory = new BigDecimal(device.getHwMemoryDevFree64());

            BigDecimal usedMemoryRate = new BigDecimal(100)
                                .subtract(freeMemory.divide(totalMemory,2, BigDecimal.ROUND_HALF_UP)
                                .multiply(new BigDecimal(100)));
            this.memoryUsedRate = usedMemoryRate.toString().split("\\.")[0];
        }else if (!StringUtils.isEmpty(device.getZteTotalMemory())){
            this.memoryUsedRate = device.getZteUsedMemory();
        }
    }

    private String sysName;
    private String devIp;
    private String idx;
    private String slotDesc;
    private String operStatus;
    private String cpuDevDuty;
    private String memoryUsedRate;
}
