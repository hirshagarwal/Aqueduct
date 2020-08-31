package com.h2micro.pipe;

import com.google.common.collect.ImmutableList;

import java.util.function.Function;

public class SimpleParallelPipes<I extends ImmutableList<S>, O extends ImmutableList<S>, S> implements AbstractPipe<I, O>{
    private final Function<S, S> f;

    public SimpleParallelPipes(Function<S, S> f) {
        this.f = f;
    }

    public O run(I input) {
        return (O) input.stream()
                .map(f)
                .collect(ImmutableList.toImmutableList());
    }
}
