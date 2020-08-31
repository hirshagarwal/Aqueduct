import com.google.common.collect.ImmutableList;
import com.h2micro.pipe.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PipeSystemTest {

    @Test
    public void testSimpleCompoundPipe() {
        SimplePipe<Integer, Integer> step1 = new SimplePipe<>(input -> input * 2);
        SimpleManifold<Integer, ImmutableList<Integer>, Integer> step2 = new SimpleManifold<>(ImmutableList.of(
                input -> input + 1,
                input -> input + 2
        ));
        SimpleParallelPipes<ImmutableList<Integer>, ImmutableList<Integer>, Integer> step3 = new SimpleParallelPipes<>(input -> input + 1);
        SimpleReducer<ImmutableList<Integer>, Integer, Integer> step4 = new SimpleReducer<>(
                listInput -> {
                    int total = 0;
                    for (int i : listInput) {
                        total += i;
                    }
                    return total;
                }
        );

        PipeSystem<Integer, Integer> system = new PipeSystem<>(ImmutableList.of(step1, step2, step3, step4));

        int total = system.run(2);

        assertEquals(13, total);
    }
}
