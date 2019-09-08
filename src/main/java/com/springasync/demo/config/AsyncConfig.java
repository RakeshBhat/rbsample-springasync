package com.springasync.demo.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.springasync.demo.exception.handler.AsyncExceptionHandler;

/**
 * 
 * By default, Spring uses a SimpleAsyncTaskExecutor to actually run 
 * these methods asynchronously. The defaults can be overridden at two levels – at the 
 * application level or at the individual method level.
 * 
 * the below sample uses application level override
 *
 */

@EnableAsync
@Configuration
@ComponentScan("com.springasync.demo.service.async")
public class AsyncConfig implements AsyncConfigurer {

	@Override
    public Executor getAsyncExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
	
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
	    return new AsyncExceptionHandler();
	}
	
	@Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
