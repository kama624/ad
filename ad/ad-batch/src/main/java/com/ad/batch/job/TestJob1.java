package com.ad.batch.job;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
//import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
//import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ad.dto.BoardDto;

import jdk.internal.org.jline.utils.Log;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TestJob1 {

	 private final JobBuilderFactory jobBuilderFactory;
	 private final StepBuilderFactory stepBuilderFactory;
	 
	 @Autowired 
	 SqlSessionFactory sqlSessionFactory;
	 
	 
	 @Bean(name = "taskletJob")
	 @Qualifier(value = "taskletJob")
	 @JobScope
	 @Primary
	 public Job taskletJob(@Value("#{jobParameters[requestDate]}") String requestDate) {
		 requestDate = LocalDateTime.now().toString();
		 log.debug(" 날짜  : " , requestDate);
		 return jobBuilderFactory.get("taskletJob")
				 .incrementer(new RunIdIncrementer())
//				 .start(taskletStep1(requestDate))
				 .start(taskletStep1())
				 .build();
	 }
	 
	 
	 @Bean(name = "taskletStep1")
	 @Qualifier(value = "taskletStep1")
	 public Step taskletStep1() {
		 
		 log.info("  Step taskletStep1()   " );
//		 public Step taskletStep1(String requestDate) {
		return stepBuilderFactory.get("taskletStep1")
				.<BoardDto, BoardDto> chunk(100)
				.reader(reader())
				.processor(processorBoard())
				.writer(writer())
				//.writer( new MyBatisBatchItemWriter())
				.build();
	}

	 @Bean
	 public BoardDtoItemProcessor processorBoard() {
	   return new BoardDtoItemProcessor();
	 }
	
	/*
	 * <batch:reader> <bean
	 * class="org.mybatis.spring.batch.MyBatisPagingItemReader"> <property
	 * name="sqlSessionFactory" ref="sqlSessionFactoryForMysql"/> <property
	 * name="pageSize" value="100"/> <property name="queryId"
	 * value="xxx.xxx.xxx.xxxRepository.get블라블라"/> </bean> </batch:reader>
	 * 
	 */	@Bean
    public MyBatisPagingItemReader<BoardDto> reader() {
		log.info("####MyBatisPagingItemReader###");
		MyBatisPagingItemReader myBatisPagingItemReader = new MyBatisPagingItemReader();
		myBatisPagingItemReader.setSqlSessionFactory(sqlSessionFactory);
		myBatisPagingItemReader.setQueryId("com.ad.mapper.batch.TestMapper.selectMapper");
		log.info("####MyBatisPagingItemReader    end end end #### ");
		try {
			System.out.println( "  myBatisPagingItemReader   " + 
					myBatisPagingItemReader.read()
			); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myBatisPagingItemReader;
		
//	   return new MyBatisPagingItemReaderBuilder<BoardDto>()
//	       .sqlSessionFactory(sqlSessionFactory)
//	       .queryId("com.ad.mapper.batch.TestMapper.selectMapper")
//	       .build();
	 }
	
//    @Bean
//    public ItemProcessor<BoardDto, BoardDto> processor() {
//    	log.info("  ItemWriter<BoardDto> processor() ");
//        return item -> {
//            //item.success();
//            return item;
//        };
//    }
//    
	 @Bean 
	 public ItemWriter<BoardDto> writer() {
		 log.info("  ItemWriter<BoardDto> writer()   " );
		 return items -> {
			 for( BoardDto item : items) {
				 System.out.println("item"+item);
			 }
		 };
		 
	 }
//	
//	@Bean
//	public MyBatisBatchItemWriter<BoardDto> writer() {
//	  return new MyBatisBatchItemWriterBuilder<BoardDto>()
//	      .sqlSessionFactory(sqlSessionFactory)
//	      .statementId("com.ad.batch.mapper.SampleMapper.selectMapper1")
//	      .build();
//	}
	
	

}


