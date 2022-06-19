package alg2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ETest {

    public static Stream<Arguments> findTime() {
        return Stream.of(
                Arguments.of(1, new ArrayList<>(Arrays.asList(2, 1))),
                Arguments.of(3, new ArrayList<>(Arrays.asList(3, 1, 2))),
                Arguments.of(4, new ArrayList<>(Arrays.asList(3, 1, 3))),
                Arguments.of(0, new ArrayList<>(Arrays.asList(3)))
        );
    }

    @ParameterizedTest
    @MethodSource
    void findTime(int expected, ArrayList<Integer> folders) {
        int testResult = E.findTime(folders);

        assertEquals(expected, testResult);
    }
}