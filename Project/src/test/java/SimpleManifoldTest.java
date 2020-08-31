import com.google.common.collect.ImmutableList;
import com.h2micro.pipe.PipeSystem;
import com.h2micro.pipe.SimpleManifold;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class SimpleManifoldTest {

    @Test
    public void testSimpleManifoldMultiply() {
        SimpleManifold<Integer, ImmutableList<Integer>, Integer> simpleManifold;
        ImmutableList<Function<Integer, Integer>> functions = ImmutableList.of(
                a -> a * 2,
                b -> b * 3
        );

        simpleManifold = new SimpleManifold<>(functions);

        PipeSystem<Integer, ImmutableList<Integer>> system = new PipeSystem<>(ImmutableList.of(simpleManifold));

        ImmutableList<Integer> result = system.run(2);

        assertEquals(4, (int) result.get(0));
        assertEquals(6, (int) result.get(1));
    }
}
