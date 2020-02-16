/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

import com.ad.batch.job.TestJob3;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication extends DefaultBatchConfigurer {

	public static void main(String[] args) throws Exception {
		int exitCode = SpringApplication.exit(SpringApplication.run(BatchApplication.class, args));
		System.exit(exitCode);
//		SpringApplication application = new SpringApplication(BatchApplication.class);
//		application.run(args);
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
