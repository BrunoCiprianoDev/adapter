package org.example.classes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CpuAdapter implements ICpuInfo {
    private DriverManager driverManager;

    public CpuAdapter(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public String getData() {
        double tempFahrenheit = driverManager.getTemperature();
        double tempCelsius = (tempFahrenheit - 32) * 5 / 9;

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.00", symbols);
        String tempCelsiusFormatted = decimalFormat.format(tempCelsius);

        String clock24h = driverManager.getClock();
        String clockAmPm = convertToAmPm(clock24h);

        String dateUS = driverManager.getDate();
        String dateBR = convertToBRDate(dateUS);

        return String.format("Temperatura: %s°C, Relógio: %s, Data: %s", tempCelsiusFormatted, clockAmPm, dateBR);
    }

    private String convertToAmPm(String clock24h) {
        try {
            SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm");
            SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm a");
            Date date = sdf24.parse(clock24h);
            return sdf12.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return clock24h;
        }
    }

    private String convertToBRDate(String dateUS) {
        try {
            SimpleDateFormat sdfUS = new SimpleDateFormat("MM-dd-yyyy");
            SimpleDateFormat sdfBR = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdfUS.parse(dateUS);
            return sdfBR.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return dateUS;
        }
    }
}
