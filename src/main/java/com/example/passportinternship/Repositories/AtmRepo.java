package com.example.passportinternship.Repositories;

import com.example.passportinternship.entities.Atm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepo extends CrudRepository<Atm, String> {
    List<Atm> findByKioskID(String kioskID);

    List<Atm> findByLocation(String location);
}
