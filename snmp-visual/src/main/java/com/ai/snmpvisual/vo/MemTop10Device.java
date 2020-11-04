package com.ai.snmpvisual.vo;

import com.ai.snmpvisual.model.Device;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;


/*
 * Memory Top10工具类
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemTop10Device {

    @ApiModelProperty(notes = "设备名称")
    private String sysName;

    @ApiModelProperty(notes = "设备Ip")
    private String devIp;

    @ApiModelProperty(notes = "单板描述")
    private String slotDesc;

    @ApiModelProperty(notes = "内存占比")
    private String devDuty;

    @ApiModelProperty(notes = "h3c设备总内存")
    private static String h3cTotalMemory="8000000000";

    public MemTop10Device(Device device) {
        this.sysName=device.getSysName();
        this.devIp=device.getDevIp();
        this.slotDesc=device.getSlotDesc();
        String hwMemoryDevSize64 = device.getHwMemoryDevSize64();
        String hwMemoryDevFree64 = device.getHwMemoryDevFree64();
        String zteTotalMemory = device.getZteTotalMemory();
        String zteUsedMemory = device.getZteUsedMemory();
        String h3cMemory = device.getH3cMemory();
        //判断设备种类 初始化内存占比
        if(!StringUtils.isEmpty(hwMemoryDevFree64) && !StringUtils.isEmpty(hwMemoryDevSize64)){
            BigDecimal hwMemFree = new BigDecimal(hwMemoryDevFree64);
            BigDecimal hwMemSize = new BigDecimal(hwMemoryDevSize64);
            BigDecimal rate = (hwMemSize.subtract(hwMemFree)).divide(hwMemSize,3,BigDecimal.ROUND_CEILING);
            this.devDuty=(rate.multiply(new BigDecimal(100))).toString();
        }else if(!StringUtils.isEmpty(zteTotalMemory) && !StringUtils.isEmpty(zteUsedMemory)){
            BigDecimal rate = new BigDecimal(zteUsedMemory).setScale(3,BigDecimal.ROUND_CEILING);
            this.devDuty=rate.toString();
        }else if(!StringUtils.isEmpty(h3cMemory)){
            BigDecimal rate = new BigDecimal(h3cMemory).setScale(3,BigDecimal.ROUND_CEILING);
            this.devDuty=rate.toString();
        }else{
            this.devDuty=String.valueOf(0);
        }

    }
}
