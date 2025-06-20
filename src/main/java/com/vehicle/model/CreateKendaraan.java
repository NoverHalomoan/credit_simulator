package com.vehicle.model;

public class CreateKendaraan {

    public static DriverCreate createKendaraanDriver(String type, String keadaanKendaraan, Integer tahunKendaraan, double pinjamTotal, Integer tenorPinjam, double jumlahDP) {
        if (type.equalsIgnoreCase("mobil")) {
            return new modelMobil("MOBIL", keadaanKendaraan, tahunKendaraan, pinjamTotal, tenorPinjam, jumlahDP);
        } else if (type.equalsIgnoreCase("motor")) {
            return new modelMotor("MOTOR", keadaanKendaraan, tahunKendaraan, pinjamTotal, tenorPinjam, jumlahDP);
        }
        return null;
    }
}
