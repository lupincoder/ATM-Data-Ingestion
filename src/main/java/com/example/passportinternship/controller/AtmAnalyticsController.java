package com.example.passportinternship.controller;

import com.example.passportinternship.Repositories.AtmRepo;
import com.example.passportinternship.entities.Atm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/atms")
@RequiredArgsConstructor
public class AtmAnalyticsController {

    private final AtmRepo atmRepo;

    @GetMapping("/by-location/{location}")
    public ResponseEntity<?> getByLocation(@PathVariable String location) {
        List<Atm> atms = atmRepo.findByLocation(location);
        return atms.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(atms);
    }

    @GetMapping("/summary")
    public ResponseEntity<?> getSummary() {
        List<Atm> allAtms = (List<Atm>) atmRepo.findAll();

        return ResponseEntity.ok(Map.of(
                "totalTransactions", allAtms.size(),
                "uniqueKiosks", allAtms.stream().map(Atm::getKioskID).distinct().count(),
                "uniqueLocations", allAtms.stream().map(Atm::getLocation).distinct().count(),
                "locations", allAtms.stream()
                        .collect(Collectors.groupingByConcurrent(Atm::getLocation, Collectors.counting())),
                "kiosks", allAtms.stream()
                        .collect(Collectors.groupingByConcurrent(Atm::getKioskID, Collectors.counting())),
                "lastUpdated", LocalDateTime.now()
        ));
    }

    @GetMapping("/by-kiosk/{kioskID}")
    public ResponseEntity<?> getByKiosk(@PathVariable String kioskID) {
        List<Atm> atms = atmRepo.findByKioskID(kioskID);
        return atms.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(atms);
    }
}