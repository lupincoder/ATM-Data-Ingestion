package com.example.passportinternship.job;

import com.example.passportinternship.entities.Atm;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;

public class AtmProcessor implements ItemProcessor<Atm, Atm> {

    @Override
    public @Nullable Atm process(Atm atm) throws Exception {
        String newDccValue = atm.getDccValue().toLowerCase();
        atm.setDccValue(newDccValue);
        return atm;
    }
}
