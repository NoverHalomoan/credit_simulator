package com.vehicle.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.vehicle.model.CreateKendaraan;
import com.vehicle.model.DriverCreate;

public class LoadServiceData {

    public DriverCreate getDataFromLoadService() {
        try {
            URL url = new URL(RulesOfLoan.URL_LOAD_DATA);
            HttpURLConnection connectionHttp = (HttpURLConnection) url.openConnection();
            connectionHttp.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connectionHttp.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connectionHttp.disconnect();
            String json = content.toString();
            String vehicleType = json.split("\"vehicleType\":\"")[1].split("\"")[0];
            String vehicleCondition = json.split("\"vehicleCondition\":\"")[1].split("\"")[0];
            int vehicleYear = Integer.parseInt(json.split("\"vehicleYear\":")[1].split(",")[0].trim());
            double totalLoanAmount = Double.parseDouble(json.split("\"totalLoanAmount\":")[1].split(",")[0].trim());
            int loanTenure = Integer.parseInt(json.split("\"loanTenure\":")[1].split(",")[0].trim());
            double downPayment = Double.parseDouble(json.split("\"downPayment\":")[1].replace("}", "").trim());
            return CreateKendaraan.createKendaraanDriver(vehicleType, vehicleCondition, vehicleYear, totalLoanAmount, loanTenure, downPayment);
        } catch (Exception e) {
            System.out.println("Data Tidak Ada");
        }

        return null;
    }
}
