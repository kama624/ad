package com.ad.batch.job;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.ad.dto.BoardDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
@Component
public class TestJob3 {

	private static final String JOB_NAME = "TestJob3221";
	private static final String STEP_NAME = "TestStep1";

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@BeforeJob
	public void beforeJob(JobExecution jobExecution){
		log.info(" beforeJob getStatus()  " + jobExecution.getStatus());
	}
	@AfterJob
	public void afterJob(JobExecution jobExecution){
		log.info(" afterJob getStatus()  " + jobExecution.getStatus());
	}
	
	
    @Bean
    @Primary
    public Job TestJob3221() {
        return jobBuilderFactory.get(JOB_NAME)
        		.incrementer(new RunIdIncrementer())
                .start(TestStep1())
                .next(TestStep2())
                .build();
    }
	
	@Bean
	public Step TestStep1() {
		log.info("  Step Step() --spring.batch.job.names=TestJob3221  " );

		return stepBuilderFactory.get(STEP_NAME)
			.<BoardDto, BoardDto>chunk(1)
			.reader(sampleItemReader())
			.processor(processorBoard())
			.writer(sampleItemWriter())
			.build();
	}
	
	@Bean
	public Step TestStep2() {
		log.info("  Step TestStep2() " );
		return stepBuilderFactory.get(STEP_NAME).tasklet((contribution, chunkContext) -> {
          //throw new IllegalArgumentException("step1에서 실패합니다.");
      	 log.info(">>>>> This is TestStep2 리턴");
           return RepeatStatus.FINISHED;
      })
      .build();
	}
	
	@Bean(name = "sampleItemReader")
	public ItemReader<BoardDto> sampleItemReader() {
		log.info("  Step sampleItemReader()   " );
		MyBatisPagingItemReader<BoardDto> reader = new MyBatisPagingItemReader<BoardDto>();
		reader.setSqlSessionFactory(sqlSessionFactory);
		reader.setQueryId("com.ad.mapper.batch.TestMapper.selectMapper");
		return reader;
	}

	 @Bean(name = "processorBoard")
	 public BoardDtoItemProcessor processorBoard() {
		 log.info("  Step processorBoard()   " );
	   return new BoardDtoItemProcessor();
	 }

	@Bean(name = "sampleItemWriter")
	public ItemWriter<BoardDto> sampleItemWriter() {
		log.info("  Step sampleItemWriter()   " );
		MyBatisBatchItemWriter<BoardDto> writer = new MyBatisBatchItemWriter<BoardDto>();
		writer.setSqlSessionFactory(sqlSessionFactory);
		writer.setStatementId("com.ad.mapper.batch.TestMapper.updateBoard");

		return writer;
	}

}
