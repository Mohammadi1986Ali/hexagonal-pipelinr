package com.javalab.tutorial.hp.event;

import an.awesome.pipelinr.Command;

public interface Events {

    <T> T publish(Command<T> event);
}
