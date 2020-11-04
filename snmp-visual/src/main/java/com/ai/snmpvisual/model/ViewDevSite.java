package com.ai.snmpvisual.model;

import io.swagger.annotations.ApiOperation;

import java.util.*;

public class ViewDevSite {

    public static class DevInfo {

        private String devIp;

        private String devName;

        private Integer devStatus;

        private List<PortInfo> portInfos;

        public String getDevIp() {
            return devIp;
        }

        public void setDevIp(String devIp) {
            this.devIp = devIp;
        }

        public String getDevName() {
            return devName;
        }

        public void setDevName(String devName) {
            this.devName = devName;
        }

        public List<PortInfo> getPortInfos() {
            return portInfos;
        }

        public void setPortInfos(List<PortInfo> portInfos) {
            this.portInfos = portInfos;
        }

        public Integer getDevStatus() {
            return devStatus;
        }

        public void setDevStatus(Integer devStatus) {
            this.devStatus = devStatus;
        }

        @Override
        public String toString() {
            return "DevInfo{" +
                    "devIp='" + devIp + '\'' +
                    ", devName='" + devName + '\'' +
                    ", devStatus=" + devStatus +
                    ", portInfos=" + portInfos +
                    '}';
        }
    }

    public static class PortInfo{

        private String portName;

        private String portAdminStatus;

        private String portOperStatus;

        public String getPortName() {
            return portName;
        }

        public void setPortName(String portName) {
            this.portName = portName;
        }

        public String getPortAdminStatus() {
            return portAdminStatus;
        }

        public void setPortAdminStatus(String portAdminStatus) {
            this.portAdminStatus = portAdminStatus;
        }

        public String getPortOperStatus() {
            return portOperStatus;
        }

        public void setPortOperStatus(String portOperStatus) {
            this.portOperStatus = portOperStatus;
        }

        @Override
        public String toString() {
            return "portInfo{" +
                    "portName='" + portName + '\'' +
                    ", portAdminStatus='" + portAdminStatus + '\'' +
                    ", portOperStatus='" + portOperStatus + '\'' +
                    '}';
        }
    }

    private String site;

    private List<DevInfo> devInfos;

    public List<DevInfo> getDevInfos() {
        return devInfos;
    }

    public void setDevInfos(List<DevInfo> devInfos) {
        this.devInfos = devInfos;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String Site) {
        this.site = Site;
    }

    @Override
    public String toString() {
        return "ViewDevSite{" +
                "devSite='" + site + '\'' +
                ", devInfos=" + devInfos +
                '}';
    }
}
