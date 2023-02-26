package com.jung.batch.jobs;


import com.jung.batch.tasklets.ApiUsageBatchTasklet;
import com.jung.service.ApiUsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApiUsageBatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ApiUsageService apiUsageService;

    @Bean
    public Job apiUsageBatchJob() {
        return jobBuilderFactory.get("apiUsageBatchJob")
                .start(apiUsageBatchStep())  // Step 설정
                .build();
    }

    // StepBuilderFactory를 통해서 tutorialStep을 생성
    @Bean
    public Step apiUsageBatchStep() {
        return stepBuilderFactory.get("apiUsageBatchStep")
                .tasklet(new ApiUsageBatchTasklet(apiUsageService)) // Tasklet 설정
                .build();
    }
}
