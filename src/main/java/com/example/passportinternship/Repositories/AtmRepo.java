package com.example.passportinternship.Repositories;

import com.example.passportinternship.entities.Atm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepo extends CrudRepository<Atm, String> {
}
