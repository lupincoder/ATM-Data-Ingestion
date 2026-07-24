package com.example.passportinternship.job;

import com.example.passportinternship.entities.Transaction;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.StepContribution;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ValidateTrans implements Tasklet {
    @Override
    public @Nullable RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {


        Map<String, Object> myMap = chunkContext.getStepContext().getJobParameters();
        String acctNum = (String) myMap.get("acctNum");
        String status = (String) myMap.get("status");
        String transType = (String) myMap.get("transType");
        Double amount = (Double) myMap.get("amount");
        String location = (String) myMap.get("location");
        String timeStamp = (String) myMap.get("timeStamp");

        Transaction transaction = new Transaction(acctNum, timeStamp, location, amount, transType, status);
        return RepeatStatus.FINISHED;

    }
}
