package com.example.passportinternship;

import com.example.passportinternship.entities.Atm;
import com.example.passportinternship.services.AtmService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class mainApp {

    private final AtmService atmService;

    public mainApp(AtmService atmService) {
        this.atmService = atmService;
    }
    @Scheduled(fixedDelay = 1000)
    public void runMainApp() {
        File dataFile = new File("src/main/resources/data/atmData.txt");
        String data;

        try (BufferedReader bF = new BufferedReader(new FileReader(dataFile))) {

            while ((data = bF.readLine()) != null) {
                if (data.matches("ATM_ID DCC_VALUE")) {
                    continue;
                }
                String[] parts = data.split("\\s+");
                String atmId = parts[0];
                String dccValue = parts[1];
                Atm atm = new Atm(atmId, dccValue);
                atmService.saveAtm(atm);
                System.out.println(atmId + " " + dccValue + " Added to database");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
