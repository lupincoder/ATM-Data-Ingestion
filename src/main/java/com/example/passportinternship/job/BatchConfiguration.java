package com.example.passportinternship.job;

import com.example.passportinternship.Repositories.AtmRepo;
import com.example.passportinternship.entities.Atm;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.LineMapper;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.infrastructure.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.infrastructure.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@RequiredArgsConstructor
@Configuration
public class BatchConfiguration {


    private final JobRepository jobRepo;
    private final PlatformTransactionManager platformTransactionManager;
    private final AtmRepo atmRepo;

    @Bean
    @StepScope
    public FlatFileItemReader<Atm> itemReader() {
        FlatFileItemReader<Atm> reader = new FlatFileItemReader<>(
                new FileSystemResource("src/main/resources/data/atmData.txt"),
                lineMapper());
        reader.setLinesToSkip(1);
        return reader;
    }

    @Bean
    public AtmProcessor processor() {
        return new AtmProcessor();
    }

    @Bean
    public RepositoryItemWriter<Atm> writer() {
        RepositoryItemWriter<Atm> writer = new RepositoryItemWriter<>(atmRepo);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step importStep() {
        return new StepBuilder("csvImport", jobRepo)
                .<Atm, Atm>chunk(10)
                .reader(itemReader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job runJob() {
        return new JobBuilder("importStudents", jobRepo)
                .start(importStep())
                .build();
    }

    private LineMapper<Atm> lineMapper() {
        DefaultLineMapper<Atm> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(" ");
        lineTokenizer.setStrict(false);

        lineTokenizer.setNames("dccValue", "timeStamp", "kioskID", "location", "status");

        BeanWrapperFieldSetMapper<Atm> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Atm.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;


    }
}