package com.vehicle;

import java.text.NumberFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import com.vehicle.model.CreateKendaraan;
import com.vehicle.model.DriverCreate;
import com.vehicle.service.BusinessKendaraan;
import com.vehicle.service.PerhitunganDriver;

public class TestBusinessLogic {

    @Test
    public void TestBusinessLogicMobil() {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.of("id", "ID"));
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        BusinessKendaraan businessKendaraan = new BusinessKendaraan();
        DriverCreate driver = CreateKendaraan.createKendaraanDriver("Mobil", "Baru", 2025, 1000000000d, 6, 500000000d);
        driver = businessKendaraan.SendDriverToStored(driver);
        List<SimpleEntry<Integer, PerhitunganDriver>> dataAll = driver.getPerhitunganBunga();
        System.out.println("vehicleType : " + driver.getTypeKendaraan());
        System.out.println("vehicleCondition : " + driver.getKeadaanKendaraan());
        System.out.println("totalLoanAmount : " + nf.format(driver.getPinjamTotal()));
        System.out.println("loanTenure : " + driver.getTenorPinjam());
        System.out.println("downPayment : " + nf.format(driver.getJumlahDP()));
        System.out.println("================================");
        System.out.println("Jumlah Cicilan : " + nf.format(driver.getJumlahCicilan()));
        for (SimpleEntry<Integer, PerhitunganDriver> d : dataAll) {
            System.out.println("Hasil Perhitungan Bunga " + d.getKey());
            System.out.println("Percent Rate " + nf.format(d.getValue().rate()));
            System.out.println("Pokok Pinjaman " + nf.format(d.getValue().pokokPinjaman()));
            System.out.println("Total Pinjaman " + nf.format(d.getValue().totalPinjaman()));
            System.out.println("Instalment Monthly " + nf.format(d.getValue().instalmentMonthly()));
            System.out.println("Instalment Year " + nf.format(d.getValue().instalmentYear()));
        }
    }

    @Test
    public void TestBusinessLogicMotor() {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.of("id", "ID"));
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        BusinessKendaraan businessKendaraan = new BusinessKendaraan();
        DriverCreate driver = CreateKendaraan.createKendaraanDriver("Motor", "Baru", 2025, 1000000000d, 6, 500000000d);
        driver = businessKendaraan.SendDriverToStored(driver);
        List<SimpleEntry<Integer, PerhitunganDriver>> dataAll = driver.getPerhitunganBunga();
        System.out.println("vehicleType : " + driver.getTypeKendaraan());
        System.out.println("vehicleCondition : " + driver.getKeadaanKendaraan());
        System.out.println("totalLoanAmount : " + nf.format(driver.getPinjamTotal()));
        System.out.println("loanTenure : " + driver.getTenorPinjam());
        System.out.println("downPayment : " + nf.format(driver.getJumlahDP()));
        System.out.println("================================");
        System.out.println("Jumlah Cicilan : " + nf.format(driver.getJumlahCicilan()));
        for (SimpleEntry<Integer, PerhitunganDriver> d : dataAll) {
            System.out.println("Hasil Perhitungan Bunga " + d.getKey());
            System.out.println("Percent Rate " + nf.format(d.getValue().rate()));
            System.out.println("Pokok Pinjaman " + nf.format(d.getValue().pokokPinjaman()));
            System.out.println("Total Pinjaman " + nf.format(d.getValue().totalPinjaman()));
            System.out.println("Instalment Monthly " + nf.format(d.getValue().instalmentMonthly()));
            System.out.println("Instalment Year " + nf.format(d.getValue().instalmentYear()));
        }
    }
}
