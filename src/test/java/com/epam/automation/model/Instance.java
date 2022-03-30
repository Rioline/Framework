package com.epam.automation.model;

public class Instance {

    private final String numberOfInstance;
    private final String instanceFor;
    private final String operatingSoftware;
    private final String virtualMachinesClass;
    private final String serie;
    private final String machineType;
    private final String committedUsage;
    private final String datacenterLocations;
    private final String addGPUType;
    private final String numberOfGpu;
    private final String localSSD;

    public Instance(String numberOfInstance, String instanceFor, String operatingSoftware, String virtualMachinesClass,
                    String serie, String machineType, String committedUsage, String datacenterLocations,
                    String addGPUType, String numberOfGpu, String localSSD) {
        this.numberOfInstance = numberOfInstance;
        this.instanceFor = instanceFor;
        this.operatingSoftware = operatingSoftware;
        this.virtualMachinesClass = virtualMachinesClass;
        this.serie = serie;
        this.machineType = machineType;
        this.committedUsage = committedUsage;
        this.datacenterLocations = datacenterLocations;
        this.addGPUType = addGPUType;
        this.numberOfGpu = numberOfGpu;
        this.localSSD = localSSD;
    }

    public String getNumberOfInstance() {
        return numberOfInstance;
    }

    public String getInstanceFor() {
        return instanceFor;
    }

    public String getOperatingSoftware() {
        return operatingSoftware;
    }

    public String getVirtualMachinesClass() {
        return virtualMachinesClass;
    }

    public String getSerie() {
        return serie;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String getDatacenterLocations() {
        return datacenterLocations;
    }

    public String getAddGPUType() {
        return addGPUType;
    }

    public String getNumberOfGpu() {
        return numberOfGpu;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instance instance = (Instance) o;

        if (!numberOfInstance.equals(instance.numberOfInstance)) return false;
        if (!instanceFor.equals(instance.instanceFor)) return false;
        if (!operatingSoftware.equals(instance.operatingSoftware)) return false;
        if (!virtualMachinesClass.equals(instance.virtualMachinesClass)) return false;
        if (!serie.equals(instance.serie)) return false;
        if (!machineType.equals(instance.machineType)) return false;
        if (!committedUsage.equals(instance.committedUsage)) return false;
        if (!datacenterLocations.equals(instance.datacenterLocations)) return false;
        if (!addGPUType.equals(instance.addGPUType)) return false;
        if (!numberOfGpu.equals(instance.numberOfGpu)) return false;
        return localSSD.equals(instance.localSSD);
    }

    @Override
    public int hashCode() {
        int result = numberOfInstance.hashCode();
        result = 31 * result + instanceFor.hashCode();
        result = 31 * result + operatingSoftware.hashCode();
        result = 31 * result + virtualMachinesClass.hashCode();
        result = 31 * result + serie.hashCode();
        result = 31 * result + machineType.hashCode();
        result = 31 * result + committedUsage.hashCode();
        result = 31 * result + datacenterLocations.hashCode();
        result = 31 * result + addGPUType.hashCode();
        result = 31 * result + numberOfGpu.hashCode();
        result = 31 * result + localSSD.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "numberOfInstance='" + numberOfInstance + '\'' +
                ", instanceFor='" + instanceFor + '\'' +
                ", operatingSoftware='" + operatingSoftware + '\'' +
                ", virtualMachinesClass='" + virtualMachinesClass + '\'' +
                ", serie='" + serie + '\'' +
                ", machineType='" + machineType + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                ", datacenterLocations='" + datacenterLocations + '\'' +
                ", addGPUType='" + addGPUType + '\'' +
                ", numberOfGpu='" + numberOfGpu + '\'' +
                ", localSSD='" + localSSD + '\'' +
                '}';
    }

}
