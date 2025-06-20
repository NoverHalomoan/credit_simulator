package com.vehicle.service;

public record PerhitunganDriver(
        double pokokPinjaman,
        float rate,
        double totalPinjaman,
        double instalmentMonthly,
        double instalmentYear
        ) {

}
