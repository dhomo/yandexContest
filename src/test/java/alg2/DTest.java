package alg2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DTest {
    public static Stream<Arguments> findRequiredBlocks() {
        return Stream.of(
                Arguments.of(4, new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(5, new int[]{0, 2}, new int[]{2}),
                Arguments.of(5, new int[]{0, 3}, new int[]{0,3}),
                Arguments.of(5, new int[]{2, 3}, new int[]{2}),
                Arguments.of(13, new int[]{1, 4, 8 ,11}, new int[]{4, 8}),
                Arguments.of(14, new int[]{1, 6, 8 ,11, 12, 13}, new int[]{6, 8}),
                Arguments.of(10_000, new int[]{0, 9_999}, new int[]{0, 9_999}),
                Arguments.of(10_000, new int[]{0, 5000,9_999}, new int[]{0, 5000})
        );
    }

    @ParameterizedTest
    @MethodSource
    void findRequiredBlocks(int plateLength, int[] blocks, int[] expected) {
        int[] testResult = D.findRequiredBlocks(plateLength, blocks);

        assertArrayEquals(expected, testResult);
    }
}