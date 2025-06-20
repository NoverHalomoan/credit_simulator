package com.vehicle.model;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import com.vehicle.service.PerhitunganDriver;

public interface DriverCreate {

    String getTypeKendaraan();

    String getKeadaanKendaraan();

    Integer getTahunKendaraan();

    double getPinjamTotal();

    Integer getTenorPinjam();

    double getJumlahDP();

    double getJumlahCicilan();

    void setJumlahCicilan(double jumlahCicilan);

    void setPerhitunganBunga(List<SimpleEntry<Integer, PerhitunganDriver>> perhitunganDrivers);

    List<SimpleEntry<Integer, PerhitunganDriver>> getPerhitunganBunga();

    void driver();
}
