package com.epam.automation.service;

import com.epam.automation.model.Instance;

public class InstanceCreator {

    public static final String NUMBER_OF_INSTANCE = "testdata.instance.number-of-instance";
    public static final String INSTANCE_FOR = "testdata.instance.instance-for";
    public static final String OPERATING_SOFTWARE = "testdata.instance.operating-software";
    public static final String VIRTUAL_MACHINES_CLASS = "testdata.instance.virtual-machines-class";
    public static final String SERIE = "testdata.instance.serie";
    public static final String MACHINE_TYPE = "testdata.instance.machine-type";
    public static final String COMMITED_USAGE = "testdata.instance.committed-usage";
    public static final String DATACENTER_LOCATIONS = "testdata.instance.datacenter-locations";
    public static final String ADD_GPU_TYPE = "testdata.instance.add-gpu-type";
    public static final String NUMBER_OF_GPU = "testdata.instance.number-of-gpu";
    public static final String LOCAL_SSD = "testdata.instance.local-ssd";

    public static Instance withCredentialsFromProperty() {
        return new Instance(
                TestDataReader.getTestData(NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(INSTANCE_FOR),
                TestDataReader.getTestData(OPERATING_SOFTWARE),
                TestDataReader.getTestData(VIRTUAL_MACHINES_CLASS),
                TestDataReader.getTestData(SERIE),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(COMMITED_USAGE),
                TestDataReader.getTestData(DATACENTER_LOCATIONS),
                TestDataReader.getTestData(ADD_GPU_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPU),
                TestDataReader.getTestData(LOCAL_SSD)
        );
    }

}
