package com.example.passportinternship.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class TransactionJob {

    private final JobRepository jobRepo;
    private final PlatformTransactionManager platformTransactionManager;
    private final ValidateTrans validateTrans;

    @Bean
    public Step validateTransaction() {
        return new StepBuilder("validate", jobRepo)
                .tasklet(validateTrans, platformTransactionManager)
                .build();
    }

    @Bean
    public Job runValidateJob() {
        return new JobBuilder("processTransaction", jobRepo)
                .start(validateTransaction())
//                .next(checkAuth)
//                .next(processDebit)
//                .next(updateTransactionLedger)
//                .next(signalDispense)
                .build();
    }

}
