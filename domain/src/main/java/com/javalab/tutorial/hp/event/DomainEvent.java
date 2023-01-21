package com.javalab.tutorial.hp.event;

import an.awesome.pipelinr.Command;

public interface DomainEvent<T> extends Command<T> {
}
