package com.ai.snmpvisual.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author:guwei
 * @Date:2020/6/16 9:59
 */
@Getter
@Setter
public class IfXTable extends BaseModel{

    /*1.3.6.1.2.1.31.1.1.1.1 */
    private String ifName;
    /*1.3.6.1.2.1.31.1.1.1.2 */
    private String ifInMulticastPkts;
    /*1.3.6.1.2.1.31.1.1.1.3 */
    private String ifInBroadcastPkts;
    /*1.3.6.1.2.1.31.1.1.1.4 */
    private String ifOutMulticastPkts;
    /*1.3.6.1.2.1.31.1.1.1.5 */
    private String ifOutBroadcastPkts;
    /*1.3.6.1.2.1.31.1.1.1.6 */
    private String ifHCInOctets;
    /*1.3.6.1.2.1.31.1.1.1.7 */
    private String ifHCInUcastPkts;
    /*1.3.6.1.2.1.31.1.1.1.8 */
    private String ifHCInMulticastPkts;
    /*1.3.6.1.2.1.31.1.1.1.9 */
    private String ifHCInBroadcastPkts;
    /*1.3.6.1.2.1.31.1.1.1.10 */
    private String ifHCOutOctets;
    /*1.3.6.1.2.1.31.1.1.1.11 */
    private String ifHCOutUcastPkts;
    /*1.3.6.1.2.1.31.1.1.1.12 */
    private String ifHCOutMulticastPkts;
    /*1.3.6.1.2.1.31.1.1.1.13 */
    private String ifHCOutBroadcastPkts;
    /*1.3.6.1.2.1.31.1.1.1.14 */
    private String ifLinkUpDownTrapEnable;
    /*1.3.6.1.2.1.31.1.1.1.15 */
    private String ifHighSpeed;


    @Override
    public String toString() {
        return super.toString()+"IfXTable{" +
                "ifName='" + ifName + '\'' +
                ", ifInMulticastPkts='" + ifInMulticastPkts + '\'' +
                ", ifInBroadcastPkts='" + ifInBroadcastPkts + '\'' +
                ", ifOutMulticastPkts='" + ifOutMulticastPkts + '\'' +
                ", ifOutBroadcastPkts='" + ifOutBroadcastPkts + '\'' +
                ", ifHCInOctets='" + ifHCInOctets + '\'' +
                ", ifHCInUcastPkts='" + ifHCInUcastPkts + '\'' +
                ", ifHCInMulticastPkts='" + ifHCInMulticastPkts + '\'' +
                ", ifHCInBroadcastPkts='" + ifHCInBroadcastPkts + '\'' +
                ", ifHCOutOctets='" + ifHCOutOctets + '\'' +
                ", ifHCOutUcastPkts='" + ifHCOutUcastPkts + '\'' +
                ", ifHCOutMulticastPkts='" + ifHCOutMulticastPkts + '\'' +
                ", ifHCOutBroadcastPkts='" + ifHCOutBroadcastPkts + '\'' +
                ", ifLinkUpDownTrapEnable='" + ifLinkUpDownTrapEnable + '\'' +
                ", ifHighSpeed='" + ifHighSpeed + '\'' +
                '}';
    }
}
