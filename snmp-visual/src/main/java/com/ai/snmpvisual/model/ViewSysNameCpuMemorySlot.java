package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: LIJY
 * @Description: TODO
 * @Date: 2020/7/6 16:42
 */
@Getter
@Setter
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class ViewSysNameCpuMemorySlot {

    /**
     * 设备ip
     */
    @ApiModelProperty(notes = "设备ip")
    private String devIp;

    @ApiModelProperty(notes = "系统名")
    private String sysName;

    @ApiModelProperty(notes = "槽位索引")
    private String idx;

    @ApiModelProperty(notes = "单板CPU平均使用率")
    private String hwCpuDevDuty;

    /**
     * 表示一块单板或者一个实体最后1分钟的CPU的平均使用率，从读取数据前的1分钟内，一块单板或者一个实体的CPU的平均使用率
     */
    @ApiModelProperty(notes = "最后1分钟的CPU的平均使用率")
    private String hwAvgDuty1min;
    /**
     * 表示一块单板或者一个实体最后5分钟的CPU的平均使用率，从读取数据前的5分钟内，一块单板或者一个实体的CPU的平均使用率。
     */
    @ApiModelProperty(notes = "最后5分钟的CPU的平均使用率")
    private String hwAvgDuty5min;

    /**
     * 被管理对象的内存总量，单位是字节.包括每块板上空闲的内存量和已占用的内存量
     */
    @ApiModelProperty(notes = "内存总量")
    private String hwMemoryDevSize;
    /**
     * 主控板上空闲内存的总量，单位是字节
     */
    @ApiModelProperty(notes = "空闲内存总量")
    private String hwMemoryDevFree;
    /**
     * 设备上已占用的raw slice内存总量，单位是字节
     */
    @ApiModelProperty(notes = "已占用的raw slice内存总量")
    private String hwMemoryDevRawSliceUsed;
    /**
     * 被管理对象上目前未被占用的最大连续字节数。是系统当时可以分配的最大内存量
     */
    @ApiModelProperty(notes = "未被占用的最大连续字节数")
    private String hwMemoryDevLargestFree;
    /**
     * 内存分配失败的次数,缺省值为0
     */
    @ApiModelProperty(notes = "内存分配失败的次数")
    private String hwMemoryDevFail;
    /**
     *由于没有空闲内存导致的内存分配失败次数。缺省值为0
     */
    @ApiModelProperty(notes = "由于没有空闲内存导致的内存分配失败次数")
    private String hwMemoryDevFailNoMem;
    /**
     * 在被管对象上存储器模块总量超过4G的总大小，单位为字节
     */
    @ApiModelProperty(notes = "存储器模块总量超过4G的总大小")
    private String hwMemoryDevSize64;
    /**
     * 在超过4G的情况下的存储器的空闲大小，单位为字节
     */
    @ApiModelProperty(notes = "超过4G的情况下的存储器的空闲大小")
    private String hwMemoryDevFree64;

    @ApiModelProperty(notes = "单板类型")
    private String hwSlotType;

    @ApiModelProperty(notes = "单板的描述")
    private String hwSlotDesc;

    @ApiModelProperty(notes = "子单板的数量")
    private String hwSubSlots;

    @ApiModelProperty(notes = "单板的运行状态")
    private String hwSlotOperStatus;

    @ApiModelProperty(notes = "单板状态管理")
    private String hwSlotAdminStatus;

    @Override
    public String toString() {
        return "ViewSysNameCpuMemorySlot{" +
                "devIp='" + devIp + '\'' +
                ", sysName='" + sysName + '\'' +
                ", hwCpuDevDuty='" + hwCpuDevDuty + '\'' +
                ", hwAvgDuty1min='" + hwAvgDuty1min + '\'' +
                ", hwAvgDuty5min='" + hwAvgDuty5min + '\'' +
                ", hwMemoryDevSize='" + hwMemoryDevSize + '\'' +
                ", hwMemoryDevFree='" + hwMemoryDevFree + '\'' +
                ", hwMemoryDevRawSliceUsed='" + hwMemoryDevRawSliceUsed + '\'' +
                ", hwMemoryDevLargestFree='" + hwMemoryDevLargestFree + '\'' +
                ", hwMemoryDevFail='" + hwMemoryDevFail + '\'' +
                ", hwMemoryDevFailNoMem='" + hwMemoryDevFailNoMem + '\'' +
                ", hwMemoryDevSize64='" + hwMemoryDevSize64 + '\'' +
                ", hwMemoryDevFree64='" + hwMemoryDevFree64 + '\'' +
                ", hwSlotType='" + hwSlotType + '\'' +
                ", hwSlotDesc='" + hwSlotDesc + '\'' +
                ", hwSubSlots='" + hwSubSlots + '\'' +
                ", hwSlotOperStatus='" + hwSlotOperStatus + '\'' +
                ", hwSlotAdminStatus='" + hwSlotAdminStatus + '\'' +
                '}';
    }
}
