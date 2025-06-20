package com.vehicle.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.vehicle.inputan.DriverInsert;
import com.vehicle.model.CreateKendaraan;
import com.vehicle.model.DriverCreate;
import com.vehicle.model.RecordsAllDataKendaraan;
import com.vehicle.service.BusinessKendaraan;
import com.vehicle.service.LoadServiceData;

public class viewVehicle {

    BusinessKendaraan businessKendaraan = new BusinessKendaraan();

    LoadServiceData loanServiceData = new LoadServiceData();

    public viewVehicle() {
    }

    public void RunViewVehicle() {
        boolean keepInput = true;
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.of("id", "ID"));
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Aplikasi Vehicle");
            System.out.println("================");
            System.out.println("Pilih Input Kendaraan :");
            System.out.println("1. Mobil");
            System.out.println("2. Motor");
            System.out.println("3. Lihat Data");
            System.out.println("4. Keluar Dari APP");
            System.out.print("Masukan Pilihan : ");
            Integer pilihan = DriverInsert.setPilihan(scanner);
            String driverName = "";
            if (pilihan == 4) {
                System.out.println("Terimakasih !!");
                keepInput = false;
                break;
            }

            if (pilihan == 3) {
                DriverCreate ObjectCreate = loanServiceData.getDataFromLoadService();
                if (ObjectCreate != null) {
                    RecordsAllDataKendaraan.getInstance().addDataDriver(businessKendaraan.SendDriverToStored(ObjectCreate));
                }
                System.out.println("\nData have been Stored\n");
                List<DriverCreate> dataList = RecordsAllDataKendaraan.getInstance().getDataDriverAll();
                for (DriverCreate data : dataList) {
                    System.out.println("vehicleType : " + data.getTypeKendaraan());
                    System.out.println("vehicleCondition : " + data.getKeadaanKendaraan());
                    System.out.println("totalLoanAmount : " + nf.format(data.getPinjamTotal()));
                    System.out.println("loanTenure : " + data.getTenorPinjam());
                    System.out.println("downPayment : " + nf.format(data.getJumlahDP()));
                    System.out.println("================================");
                    System.out.println("Jumlah Cicilan : " + nf.format(data.getJumlahCicilan()));
                }
                System.out.print("Click Enter to back menu application !!");
                scanner.nextLine();
                continue;
            }
            // System.out.println("Test " + DriverInsert.keadaanKendaraan);
            if (pilihan == 1 || pilihan == 2) {
                driverName = pilihan == 1 ? "Mobil" : "Motor";
                System.out.println("=====================");
                System.out.print("Kondisi Kendaraan(ex. Baru or Lama) : ");
                DriverInsert.keadaanKendaraan = DriverInsert.setKeadaanKendaraan(scanner);
                if (DriverInsert.keadaanKendaraan.isEmpty()) {
                    System.out.print("Input Keadaan Kendaraan Invalid, Please press Enter !");
                    scanner.nextLine();
                    continue;
                }
                System.out.print("Tahun Kendaraan(ex. 2000) : ");
                DriverInsert.tahunKendaraan = DriverInsert.setTahunKendaraan(scanner, DriverInsert.keadaanKendaraan);
                if (DriverInsert.tahunKendaraan == 0) {
                    System.out.print("Input Tahun Kendaraan Invalid, Please press Enter !");
                    scanner.nextLine();
                    continue;
                }
                System.out.print("Jumlah Pinjaman (Less than 1 M) : ");
                DriverInsert.pinjamTotal = DriverInsert.setJumalahPinjaman(scanner);
                if (DriverInsert.pinjamTotal == 0) {
                    System.out.print("Input Total Pinjaman Invalid, Please press Enter !");
                    scanner.nextLine();
                    continue;
                }

                System.out.print("Tenor Pinjaman (ex 1 - 6) : ");
                DriverInsert.tenorPinjam = DriverInsert.setTenorPinjaman(scanner, DriverInsert.keadaanKendaraan);
                if (DriverInsert.tenorPinjam == 0) {
                    System.out.print("Input Tenor Pinjaman Invalid, Please press Enter !");
                    scanner.nextLine();
                    continue;
                }

                System.out.print("Input Jumal DP  : ");
                DriverInsert.jumlahDP = DriverInsert.setJumalahDP(scanner, DriverInsert.tenorPinjam, DriverInsert.keadaanKendaraan);
                if (DriverInsert.jumlahDP == 0) {
                    System.out.print("Input Jumlah DP Invalid, Please press Enter !");
                    scanner.nextLine();
                    continue;
                }
            }

            if (pilihan != 1 && pilihan != 2 && pilihan != 3) {
                System.out.print("Error Input Invalid, Please press Enter !");
                scanner.nextLine();
            } else {
                DriverCreate driverCreate = CreateKendaraan.createKendaraanDriver(driverName, DriverInsert.keadaanKendaraan, DriverInsert.tahunKendaraan, DriverInsert.pinjamTotal, DriverInsert.tenorPinjam, DriverInsert.jumlahDP);
                driverCreate = businessKendaraan.SendDriverToStored(driverCreate);
                RecordsAllDataKendaraan.getInstance().addDataDriver(driverCreate);
                System.out.println("Detail Inputan Data Kendaraan");
                System.out.println("vehicleType : " + driverCreate.getTypeKendaraan());
                System.out.println("vehicleCondition : " + driverCreate.getKeadaanKendaraan());
                System.out.println("totalLoanAmount : " + nf.format(driverCreate.getPinjamTotal()));
                System.out.println("loanTenure : " + driverCreate.getTenorPinjam());
                System.out.println("downPayment : " + nf.format(driverCreate.getJumlahDP()));
                System.out.println("================================");
                System.out.println("Jumlah Cicilan : " + nf.format(driverCreate.getJumlahCicilan()));
                scanner.nextLine();
            }
        } while (keepInput);

    }
}
