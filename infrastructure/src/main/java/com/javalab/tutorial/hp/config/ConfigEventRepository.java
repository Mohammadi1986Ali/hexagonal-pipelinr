package com.javalab.tutorial.hp.config;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import com.javalab.tutorial.hp.adapter.EventRepository;
import com.javalab.tutorial.hp.event.Events;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class ConfigEventRepository {

    @Bean
    Pipeline pipeline(ObjectProvider<Command.Handler> commandHandlers,
                      ObjectProvider<Command.Middleware> middlewares) {
        return new Pipelinr()
                .with(commandHandlers::stream)
                .with(middlewares::stream);
    }

    @Bean
    Events getEvents(Pipeline pipeline) {
        return new EventRepository(pipeline);
    }
}
