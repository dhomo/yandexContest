
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ETest {

    @ParameterizedTest
    @CsvSource({"5,1,1,0", "3,-1,-1,1", "4,4,4,2", "4,2,2,0"})
    void findDotPos(int d, int dotX, int dotY, int result) {
        int testResult = E.findDotPos(d, dotX, dotY);
        // checkout output
        assertEquals(result, testResult);
    }
}