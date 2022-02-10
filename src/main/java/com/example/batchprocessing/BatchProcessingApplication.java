package com.example.batchprocessing;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
public class BatchProcessingApplication {

    private final JobRunner jobRunner;

    BatchProcessingApplication(JobRunner jobRunner) {
        this.jobRunner = jobRunner;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BatchProcessingApplication.class);
    }

    @Scheduled(cron = "*/15 * * * * *")
    public void runJob() {
        jobRunner.runJob();
    }
}
