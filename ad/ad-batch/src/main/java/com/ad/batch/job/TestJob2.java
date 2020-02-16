//package com.ad.batch.job;
//
//import javax.sql.DataSource;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//
//import com.ad.dto.BoardDto;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//@EnableBatchProcessing
//public class TestJob2 {
//
//	private final JobBuilderFactory jobBuilderFactory;
//	private final StepBuilderFactory stepBuilderFactory;
//	 
//    private final DataSource dataSource; // DataSource DI
//
//    private static final int chunkSize = 10;
//    
//    @Bean
//    public Job jdbcCursorItemReaderJob11() {
//        return jobBuilderFactory.get("jdbcCursorItemReaderJob11")
//                .start(TestStep())
//                .build();
//    }
//    
//    @Bean
//    public Step TestStep() {
//        return stepBuilderFactory.get("jdbcCursorItemReaderStep")
//                .<BoardDto, BoardDto>chunk(chunkSize)
//                .reader(TestStepReader())
//                .writer(TestStepWriter())
//                .build();
//    }
//    
//    @Bean
//    public JdbcCursorItemReader<BoardDto> TestStepReader() {
//    	log.info("  Step TestStepReader()   " );
//        return new JdbcCursorItemReaderBuilder<BoardDto>()
//                .fetchSize(chunkSize)
//                .dataSource(dataSource)
//                .rowMapper(new BeanPropertyRowMapper<>(BoardDto.class))
//                .sql("select a.*, rownum from MP_BOARD")
//                .name("TestStepReader")
//                .build();
//    }
//
//    private ItemWriter<BoardDto> TestStepWriter() {
//    	log.info("  Step TestStepWriter()   " );
//        return list -> {
//            for (BoardDto boardDto: list) {
//                log.info("Current BoardDto={}", boardDto);
//            }
//        };
//    }
//
//}
