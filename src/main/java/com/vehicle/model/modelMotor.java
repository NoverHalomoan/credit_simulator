package com.vehicle.model;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import com.vehicle.service.PerhitunganDriver;

public class modelMotor implements DriverCreate {

    private String typeKendaraan;
    private String keadaanKendaraan;
    private Integer tahunKendaraan;
    private double pinjamTotal;
    private Integer tenorPinjam;
    private double jumlahDP;
    private double jumlahCicilan;
    private List<SimpleEntry<Integer, PerhitunganDriver>> perhitunganBunga;

    public modelMotor() {
    }

    public modelMotor(String typeKendaraan, String keadaanKendaraan, Integer tahunKendaraan, double pinjamTotal,
            Integer tenorPinjam, double jumlahDP) {
        this.typeKendaraan = typeKendaraan;
        this.keadaanKendaraan = keadaanKendaraan;
        this.tahunKendaraan = tahunKendaraan;
        this.pinjamTotal = pinjamTotal;
        this.tenorPinjam = tenorPinjam;
        this.jumlahDP = jumlahDP;
    }

    @Override
    public double getJumlahCicilan() {
        return this.jumlahCicilan;
    }

    @Override
    public double getJumlahDP() {
        return this.jumlahDP;
    }

    @Override
    public String getKeadaanKendaraan() {
        return this.keadaanKendaraan;
    }

    @Override
    public double getPinjamTotal() {
        return this.pinjamTotal;
    }

    @Override
    public Integer getTahunKendaraan() {
        return this.tahunKendaraan;
    }

    @Override
    public Integer getTenorPinjam() {
        return this.tenorPinjam;
    }

    @Override
    public String getTypeKendaraan() {
        return this.typeKendaraan;
    }

    @Override
    public void driver() {
        System.out.println("Create a motor object");
    }

    @Override
    public void setJumlahCicilan(double jumlahCicilan) {
        this.jumlahCicilan = jumlahCicilan;
    }

    @Override
    public List<SimpleEntry<Integer, PerhitunganDriver>> getPerhitunganBunga() {
        // TODO Auto-generated method stub
        return this.perhitunganBunga;
    }

    @Override
    public void setPerhitunganBunga(List<SimpleEntry<Integer, PerhitunganDriver>> perhitunganDrivers) {
        // TODO Auto-generated method stub
        this.perhitunganBunga = perhitunganDrivers;
    }
}
