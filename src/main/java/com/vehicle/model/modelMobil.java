package com.vehicle.model;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import com.vehicle.service.PerhitunganDriver;

public class modelMobil implements DriverCreate {

    private String typeKendaraan;
    private String keadaanKendaraan;
    private Integer tahunKendaraan;
    private double pinjamTotal;
    private Integer tenorPinjam;
    private double jumlahDP;
    private double jumlahCicilan;
    private List<SimpleEntry<Integer, PerhitunganDriver>> perhitunganBunga;

    public modelMobil() {
    }

    public modelMobil(String typeKendaraan, String keadaanKendaraan, Integer tahunKendaraan, double pinjamTotal,
            Integer tenorPinjam, double jumlahDP) {
        this.typeKendaraan = typeKendaraan;
        this.keadaanKendaraan = keadaanKendaraan;
        this.tahunKendaraan = tahunKendaraan;
        this.pinjamTotal = pinjamTotal;
        this.tenorPinjam = tenorPinjam;
        this.jumlahDP = jumlahDP;
    }

    @Override
    public String getTypeKendaraan() {
        // TODO Auto-generated method stub
        return this.typeKendaraan;
    }

    @Override
    public String getKeadaanKendaraan() {
        // TODO Auto-generated method stub
        return this.keadaanKendaraan;
    }

    @Override
    public Integer getTahunKendaraan() {
        // TODO Auto-generated method stub
        return this.tahunKendaraan;
    }

    @Override
    public double getPinjamTotal() {
        // TODO Auto-generated method stub
        return this.pinjamTotal;
    }

    @Override
    public Integer getTenorPinjam() {
        // TODO Auto-generated method stub
        return this.tenorPinjam;
    }

    @Override
    public double getJumlahDP() {
        // TODO Auto-generated method stub
        return this.jumlahDP;
    }

    @Override
    public double getJumlahCicilan() {
        // TODO Auto-generated method stub
        return this.jumlahCicilan;
    }

    @Override
    public void driver() {
        System.out.println("Create a mobile object");
    }

    @Override
    public List<SimpleEntry<Integer, PerhitunganDriver>> getPerhitunganBunga() {
        // TODO Auto-generated method stub
        return this.perhitunganBunga;
    }

    @Override
    public void setJumlahCicilan(double jumlahCicilan) {
        // TODO Auto-generated method stub
        this.jumlahCicilan = jumlahCicilan;
    }

    @Override
    public void setPerhitunganBunga(List<SimpleEntry<Integer, PerhitunganDriver>> perhitunganDrivers) {
        // TODO Auto-generated method stub
        this.perhitunganBunga = perhitunganDrivers;
    }

}
