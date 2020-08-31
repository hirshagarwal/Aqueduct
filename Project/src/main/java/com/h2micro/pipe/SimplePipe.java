package com.h2micro.pipe;

import java.util.function.Function;

public class SimplePipe<I, O> implements AbstractPipe<I, O>{
    private final Function<I, O> f;

    public SimplePipe(Function<I, O> f) {
        this.f = f;
    }

    @Override
    public O run(I input) {
        return f.apply(input);
    }
}
