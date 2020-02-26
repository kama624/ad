package com.ad.web.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController

public class JobLauncherController {

	@Autowired(required = false)
    private JobLauncher jobLauncher;
	@Autowired(required = false)
    private Job job;
    @Autowired
    private ApplicationContext context;

    
    @GetMapping("/launchjob")
    public String handle(String fileName) throws Exception {
    	
//    	System.out.println(context);
//        try {
//        	
//        	
//        	
//        	Job  job2 = (Job) context.getBean("TestJob31");
//            JobParameters jobParameters = new JobParametersBuilder()
//                                    .addString("input.file.name", fileName)
//                                    .addLong("time", System.currentTimeMillis())
//                                    .toJobParameters();
//            jobLauncher.run(job2, jobParameters);
//        } catch (Exception e) {
//            log.info(e.getMessage());
//        }

        return "Done";
    }
}
