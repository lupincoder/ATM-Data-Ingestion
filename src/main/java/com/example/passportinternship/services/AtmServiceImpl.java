package com.example.passportinternship.services;

import com.example.passportinternship.Repositories.AtmRepo;
import com.example.passportinternship.entities.Atm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Service;

@Service
public class AtmServiceImpl implements AtmService{

    private final JdbcAggregateTemplate jdbcAggregateTemplate;
    private AtmRepo aR;

   @Autowired
    public AtmServiceImpl(AtmRepo aR, JdbcAggregateTemplate jdbcAggregateTemplate) {
        this.aR = aR;
       this.jdbcAggregateTemplate = jdbcAggregateTemplate;
   }

    @Override
    public void saveAtm(Atm atm) {
        if (aR.existsById(atm.getId())) {
            aR.save(atm);
        } else {
            jdbcAggregateTemplate.insert(atm);
        }
    }
}
