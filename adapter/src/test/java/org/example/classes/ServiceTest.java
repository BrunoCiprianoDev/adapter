package org.example.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ServiceTest {

    @Test
    public void testGetInfo() {
        // Caso de teste 1
        DriverManager driverManager1 = new DriverManager(98.6, "14:30", "07-15-2024");
        CpuAdapter cpuAdapter1 = new CpuAdapter(driverManager1);
        Service service1 = new Service(cpuAdapter1);
        String expectedOutput1 = "Temperatura: 37.00°C, Relógio: 02:30 PM, Data: 15/07/2024";
        assertEquals(expectedOutput1, service1.getInfo());

    }

    @Test
    public void testGetInfo_Case3() {
        DriverManager driverManager = new DriverManager(212.0, "23:59", "12-31-2024");
        CpuAdapter cpuAdapter = new CpuAdapter(driverManager);
        Service service = new Service(cpuAdapter);
        String expectedOutput = "Temperatura: 100.00°C, Relógio: 11:59 PM, Data: 31/12/2024";
        assertEquals(expectedOutput, service.getInfo());
    }

    @Test
    public void testGetInfo_Case4() {
        DriverManager driverManager = new DriverManager(77.0, "09:45", "05-21-2024");
        CpuAdapter cpuAdapter = new CpuAdapter(driverManager);
        Service service = new Service(cpuAdapter);
        String expectedOutput = "Temperatura: 25.00°C, Relógio: 09:45 AM, Data: 21/05/2024";
        assertEquals(expectedOutput, service.getInfo());
    }
}