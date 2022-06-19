package alg2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CTest {

    @ParameterizedTest
    @CsvSource({"a,0",
            "ab,1",
            "cognitive,4",
            "som,1",
            "soms,1",
            "abcdefga,3"
    })
    void calcCost(String testString, int expected) {
        int testResult = C.calcCost(testString);
        // checkout output
        assertEquals(expected, testResult);
    }
}