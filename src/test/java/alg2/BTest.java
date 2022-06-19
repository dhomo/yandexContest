package alg2;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BTest {

    public static Stream<Arguments> calcMaximumDistance() {
        return Stream.of(
                Arguments.of(new int[]{2,0,1,1,0,1,0,2,1,2}, 3),
                Arguments.of(new int[]{2,0,1,0,1,1,0,0,0,2}, 4),
                Arguments.of(new int[]{2,0,0,0,0,0,0,0,0,1}, 9),
                Arguments.of(new int[]{1,0,0,0,0,0,0,0,0,2}, 9),
                Arguments.of(new int[]{1,0,0,0,0,0,0,0,1,2}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource
    void calcMaximumDistance(int[] testdata, int expected) {
        int testResult = B.calcMaximumDistance(testdata);
        // checkout output
        assertEquals(expected, testResult);
    }
}