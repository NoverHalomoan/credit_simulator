package com.vehicle.service;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import com.vehicle.model.DriverCreate;

public class BusinessKendaraan {

    private double getpokokPinjamanSum(double pokokPinjaman, double InstallmentVal) {
        return pokokPinjaman - InstallmentVal;
    }

    private double getTotalPinjamanSum(double pokoPinjaman, float rate) {
        return pokoPinjaman + (pokoPinjaman * (rate / 100));
    }

    private double getInstalmentMonthlySum(double totalPinjaman, int tenor, int moreThan) {
        if (moreThan == 0) {
            return totalPinjaman / (12 * tenor);
        } else {
            return totalPinjaman / ((12 * tenor) - moreThan);
        }

    }

    private List<SimpleEntry<Integer, PerhitunganDriver>> getTotalBungaPertahun(DriverCreate vehicle) {
        List<SimpleEntry<Integer, PerhitunganDriver>> TotalBunga = new ArrayList<>();

        float baseGlobalRate = RulesOfLoan.baseRateMotor;
        double pokokPinjaman = 0d;
        double totalPinjaman = 0d;
        double intalmentMontly = 0d;
        double instalmentYear = 0d;

        int totalTahun = vehicle.getTenorPinjam() - 1;
        if (vehicle.getTypeKendaraan().equalsIgnoreCase("mobil")) {
            baseGlobalRate = RulesOfLoan.baseRateMobil;
            pokokPinjaman = getpokokPinjamanSum(vehicle.getPinjamTotal(), vehicle.getJumlahDP());
            totalPinjaman = Math.round(getTotalPinjamanSum(pokokPinjaman, baseGlobalRate));
            intalmentMontly = getInstalmentMonthlySum(totalPinjaman, vehicle.getTenorPinjam(), 0);
            instalmentYear = intalmentMontly * 12;
            PerhitunganDriver perhitunganDriver = new PerhitunganDriver(pokokPinjaman, baseGlobalRate, totalPinjaman, intalmentMontly, instalmentYear);
            TotalBunga.add(new SimpleEntry<>(1, perhitunganDriver));
        } else if (vehicle.getTypeKendaraan().equalsIgnoreCase("motor")) {
            pokokPinjaman = getpokokPinjamanSum(vehicle.getPinjamTotal(), vehicle.getJumlahDP());
            totalPinjaman = getTotalPinjamanSum(pokokPinjaman, baseGlobalRate);
            intalmentMontly = getInstalmentMonthlySum(totalPinjaman, vehicle.getTenorPinjam(), 0);
            instalmentYear = intalmentMontly * 12;
            PerhitunganDriver perhitunganDriver = new PerhitunganDriver(pokokPinjaman, baseGlobalRate, totalPinjaman, intalmentMontly, instalmentYear);
            TotalBunga.add(new SimpleEntry<>(1, perhitunganDriver));
        }

        for (int i = 1; i <= totalTahun; i++) {
            if (i % 2 == 0) {
                baseGlobalRate += RulesOfLoan.TwoYears;
                baseGlobalRate = Math.round(baseGlobalRate * 10f) / 10f;
                pokokPinjaman = getpokokPinjamanSum(totalPinjaman, instalmentYear);
                totalPinjaman = getTotalPinjamanSum(pokokPinjaman, baseGlobalRate);
                intalmentMontly = getInstalmentMonthlySum(totalPinjaman, vehicle.getTenorPinjam(), (i * 12));
                instalmentYear = intalmentMontly * 12;
                PerhitunganDriver perhitunganDriver = new PerhitunganDriver(pokokPinjaman, baseGlobalRate, totalPinjaman, intalmentMontly, instalmentYear);
                TotalBunga.add(new SimpleEntry<>(i + 1, perhitunganDriver));
            } else {
                baseGlobalRate += RulesOfLoan.OneYears;
                baseGlobalRate = Math.round(baseGlobalRate * 10f) / 10f;
                pokokPinjaman = getpokokPinjamanSum(totalPinjaman, instalmentYear);
                totalPinjaman = getTotalPinjamanSum(pokokPinjaman, baseGlobalRate);
                intalmentMontly = getInstalmentMonthlySum(totalPinjaman, vehicle.getTenorPinjam(), i * 12);
                instalmentYear = intalmentMontly * 12;
                PerhitunganDriver perhitunganDriver = new PerhitunganDriver(pokokPinjaman, baseGlobalRate, totalPinjaman, intalmentMontly, instalmentYear);
                TotalBunga.add(new SimpleEntry<>(i + 1, perhitunganDriver));
            }
        }
        return TotalBunga;
    }

    public DriverCreate SendDriverToStored(DriverCreate vehicle) {

        List<SimpleEntry<Integer, PerhitunganDriver>> data = getTotalBungaPertahun(vehicle);
        double jumlahCicilan = data.get(data.size() - 1).getValue().instalmentMonthly();
        vehicle.setPerhitunganBunga(data);
        vehicle.setJumlahCicilan(jumlahCicilan);

        return vehicle;
    }
}
