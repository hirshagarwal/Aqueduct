import com.google.common.collect.ImmutableList;
import com.h2micro.pipe.PipeSystem;
import com.h2micro.pipe.SimplePipe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimplePipeTest {

    @Test
    public void testSinglePipeMultiply() {
        SimplePipe<Integer, Integer> multiplyPipe;
        multiplyPipe = new SimplePipe<>(inputNum -> inputNum * 2);

        PipeSystem<Integer, Integer> pipeSystem = new PipeSystem<>(ImmutableList.of(multiplyPipe));

        int result = pipeSystem.run(10);

        assertEquals(20, result);
    }

    @Test
    public void testTwoPipeMultiply() {
        SimplePipe<Integer, Integer> multiplyPipe;
        multiplyPipe = new SimplePipe<>(inputNum -> inputNum * 2);

        PipeSystem<Integer, Integer> pipeSystem = new PipeSystem<>(
                ImmutableList.of(multiplyPipe, multiplyPipe)
        );

        int result = pipeSystem.run(10);

        assertEquals(40, result);
    }
}
