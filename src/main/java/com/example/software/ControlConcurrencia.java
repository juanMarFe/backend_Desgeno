package com.example.software;

import com.example.software.controlador.Facade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync

public class ControlConcurrencia {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControlConcurrencia.class);
    private ArrayList<Controller> controller;

    public Executor taskExecutor(){
        controller.add(new Controller());
        controller.get(0).getClass();
        LOGGER.debug("Creating Async Task Executor");
        final ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("userThread-");
        executor.initialize();
        return executor;

    }
}
