package com.h2micro.pipe;


public interface AbstractPipe<I, O> {

    abstract O run(I input);
}
