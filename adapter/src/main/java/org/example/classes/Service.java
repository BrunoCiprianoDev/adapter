package org.example.classes;

public class Service {

    private ICpuInfo cpuInfo;

    public Service(ICpuInfo cpuInfo) {
        this.cpuInfo = cpuInfo;
    }

    public String getInfo() {
        return cpuInfo.getData();
    }
}