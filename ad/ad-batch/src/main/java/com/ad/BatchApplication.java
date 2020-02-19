package com.ad;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication extends DefaultBatchConfigurer {

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(BatchApplication.class);
		application.run(args);
	}

}
