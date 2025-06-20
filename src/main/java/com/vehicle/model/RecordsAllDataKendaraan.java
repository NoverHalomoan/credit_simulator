package com.vehicle.model;

import java.util.ArrayList;
import java.util.List;

public class RecordsAllDataKendaraan {

    private static RecordsAllDataKendaraan instance;

    private List<DriverCreate> DataDriverAll = new ArrayList<>();

    private RecordsAllDataKendaraan() {

    }

    public static RecordsAllDataKendaraan getInstance() {
        if (instance == null) {
            instance = new RecordsAllDataKendaraan();
        }
        return instance;
    }

    public List<DriverCreate> getDataDriverAll() {
        return this.DataDriverAll;
    }

    public void setDataDriverAll(List<DriverCreate> dataDriverAll) {
        this.DataDriverAll = dataDriverAll;
    }

    public void addDataDriver(DriverCreate driver) {
        this.DataDriverAll.add(driver);
    }

}
