package com.h2micro.pipe;

import com.google.common.collect.ImmutableList;

import java.util.function.Function;

public class SimpleReducer<I extends ImmutableList<S>, O, S> implements AbstractPipe<I, O>{
    private final Function<I, O> f;

    public SimpleReducer(Function<I, O> f) {
        this.f = f;
    }

    public O run(I input) {
        return f.apply(input);
    }
}
