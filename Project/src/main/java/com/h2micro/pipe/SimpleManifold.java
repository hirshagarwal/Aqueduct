package com.h2micro.pipe;

import com.google.common.collect.ImmutableList;

import java.util.function.Function;

public class SimpleManifold<I, O extends ImmutableList<S>, S> implements AbstractPipe<I, O>{
    private final ImmutableList<Function<I, S>> f;

    public SimpleManifold(ImmutableList<Function<I, S>> f) {
        this.f = f;
    }

    @Override
    public O run(I input) {
        return (O) f.stream()
                .map(function -> function.apply(input))
                .collect(ImmutableList.toImmutableList());
    }
}
