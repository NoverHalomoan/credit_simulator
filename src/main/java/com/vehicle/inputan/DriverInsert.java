package com.vehicle.inputan;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DriverInsert {

    public static String typeKendaraan;
    public static String keadaanKendaraan;
    public static Integer tahunKendaraan;
    public static double pinjamTotal;
    public static Integer tenorPinjam;
    public static double jumlahDP;
    public static double jumlahCicilan;

    public static Integer setPilihan(Scanner scanner) {
        Integer pilihanChoose = 0;
        while (true) {
            try {
                pilihanChoose = Integer.valueOf(scanner.nextLine());

                if (pilihanChoose >= 1 && pilihanChoose <= 4) {
                    break;
                } else {
                    System.out.println("Input Pilihan Invalid");
                }
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return pilihanChoose;
    }

    public static String setKeadaanKendaraan(Scanner scanner) {
        String keadaanKendaraan = scanner.nextLine();
        if (keadaanKendaraan.equalsIgnoreCase("baru")) {
            return "Baru";
        } else if (keadaanKendaraan.equalsIgnoreCase("lama")) {
            return "Lama";
        }
        return "";
    }

    public static Integer setTahunKendaraan(Scanner scanner, String keadaanKendaran) {
        Integer tahun = 0;

        Integer tahunNow = LocalDateTime.now().getYear() - 1;
        while (true) {
            try {
                String tahunKendaraan = scanner.nextLine();
                tahun = Integer.valueOf(tahunKendaraan);
                if (tahunKendaraan.length() == 4) {
                    if (keadaanKendaran.equalsIgnoreCase("baru") && tahunNow > tahun) {
                        return 0;
                    }
                    break;
                } else {
                    return 0;
                }
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return tahun;
    }

    public static Double setJumalahPinjaman(Scanner scanner) {
        Double jumlahPinjaman = 0d;
        while (true) {
            try {
                String inputan = scanner.nextLine();
                jumlahPinjaman = Double.valueOf(inputan);
                if (jumlahPinjaman != 0d && jumlahPinjaman <= 1_000_000_000d) {
                    break;
                } else {
                    return 0d;
                }
            } catch (NumberFormatException e) {
                return 0d;
            }
        }
        return jumlahPinjaman;
    }

    public static Integer setTenorPinjaman(Scanner scanner, String keadaanKendaraan) {
        Integer pilihanChoose = 0;
        while (true) {
            try {
                String inputan = scanner.nextLine();
                pilihanChoose = Integer.valueOf(inputan);

                if (pilihanChoose != 0 && ((keadaanKendaraan.equalsIgnoreCase("Baru") && pilihanChoose <= 6) || (keadaanKendaraan.equalsIgnoreCase("lama") && pilihanChoose != 0))) {
                    break;
                } else {
                    return 0;
                }
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return pilihanChoose;
    }

    public static Double setJumalahDP(Scanner scanner, double jumlahPinjaman, String keadaanKendaraan) {
        Double jumlahDP = 0d;
        while (true) {
            try {
                String inputan = scanner.nextLine();
                jumlahDP = Double.valueOf(inputan);
                float percentLoan = Math.round(jumlahDP / jumlahPinjaman);
                if (jumlahDP != 0 && jumlahDP <= 1_000_000_000d) {
                    if (keadaanKendaraan.equalsIgnoreCase("baru") && percentLoan >= 35) {
                        break;
                    } else if (keadaanKendaraan.equalsIgnoreCase("lama") && percentLoan >= 25) {
                        break;
                    } else {
                        return 0d;
                    }

                } else {
                    return 0d;
                }
            } catch (NumberFormatException e) {
                return 0d;
            }
        }
        return jumlahDP;
    }

}
