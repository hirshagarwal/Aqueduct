package com.h2micro.pipe;

import com.google.common.collect.ImmutableList;

public class PipeSystem<I, O> {

    final ImmutableList<AbstractPipe> pipes;

    public PipeSystem(ImmutableList<AbstractPipe> pipes) {
        this.pipes = pipes;
    }

    public O run(I input) {
        Object intermediate = input;
        for (AbstractPipe pipe : pipes) {
            intermediate = pipe.run(intermediate);
        }

        return (O) intermediate;
    }

}
