package com.javalab.tutorial.hp.adapter;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.javalab.tutorial.hp.event.Events;

public class EventRepository implements Events {

    private final Pipeline pipeline;

    public EventRepository(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public <T> T publish(Command<T> event) {
        return pipeline.send(event);
    }
}
