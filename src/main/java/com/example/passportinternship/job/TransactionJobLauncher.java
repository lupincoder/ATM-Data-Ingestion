package com.example.passportinternship.job;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.InvalidJobParametersException;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.launch.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobRestartException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TransactionJobLauncher {
    private final JobLauncher jobLauncher;
    private final Job job;

    public TransactionJobLauncher(JobLauncher jobLauncher, @Qualifier("runValidateJob") Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    public void runTransJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .addString("acctNum", "111111")
                .addString("status", "processed")
                .addString("transType", "deposit")
                .addDouble("amount", 20.00)
                .addString("location", "Beijing")
                .addString("timeStamp", "2024-06-15_19:06:00")
                .toJobParameters();


        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException
                 | JobRestartException
                 | JobInstanceAlreadyCompleteException
                 | InvalidJobParametersException e) {
            throw new RuntimeException(e);
        }
    }
}
