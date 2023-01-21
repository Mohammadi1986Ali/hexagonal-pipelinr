package com.javalab.tutorial.hp.middleware;

import an.awesome.pipelinr.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingMiddleware implements Command.Middleware {

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        log.info(command.toString());
        R response = next.invoke();
        log.info(response.toString());
        return null;
    }
}
