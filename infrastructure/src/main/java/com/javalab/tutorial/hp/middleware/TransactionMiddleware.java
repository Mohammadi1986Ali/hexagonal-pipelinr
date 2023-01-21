package com.javalab.tutorial.hp.middleware;

import an.awesome.pipelinr.Command;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class TransactionMiddleware implements Command.Middleware {

    @Override
    @Transactional
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        R response = next.invoke();
        return response;
    }
}
