
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

public class DTest {

    public int computeSchoolAdrrFull(int[] studentsAddresses){
        int minStAddress = studentsAddresses[0];
        int maxStAddress = studentsAddresses[studentsAddresses.length - 1];
        int result = 0;
        int minSum = Integer.MAX_VALUE;
//        System.out.println(Arrays.toString(studentsAddresses));
        for (int schoolAddress = minStAddress; schoolAddress <= maxStAddress; schoolAddress++) {
            int sum = 0;
            System.out.print(schoolAddress);
            for (int j = 0; j < studentsAddresses.length; j++) {
                sum += Math.abs(schoolAddress - studentsAddresses[j]);
                if (schoolAddress == studentsAddresses[j]){
//                    System.out.print("*");
                }
            }
//            System.out.print("\t");
//            System.out.println(sum);
            if (sum < minSum) {
                minSum = sum;
                result = schoolAddress;
            }
        }
        return result;
    }

    @Test
    public void test2() throws IOException {
        int[] studentsAddresses = new int[] {1, 2, 3, 4};

        int testAnswer = D.computeSchoolAdrr(studentsAddresses); // call the main method
        int trueAnswer = computeSchoolAdrrFull(studentsAddresses);
        // checkout output
        assertEquals(trueAnswer, testAnswer);
    }

    @Test
    public void test4() throws IOException {
        int[] studentsAddresses = new int[] {-1, 0, 10};

        int testAnswer = D.computeSchoolAdrr(studentsAddresses); // call the main method
        int trueAnswer = computeSchoolAdrrFull(studentsAddresses);
        // checkout output
        assertEquals(trueAnswer, testAnswer);
    }

    @Test
    public void test3() throws IOException {
        int[] studentsAddresses = new int[] {22, 49, 63};

        int testAnswer = D.computeSchoolAdrr(studentsAddresses); // call the main method
        int trueAnswer = computeSchoolAdrrFull(studentsAddresses);
        // checkout output
        assertEquals(trueAnswer, testAnswer);
    }

    public static final int MAX_STUDENT_COUNT = 100; //100001
    public static final int MAX_STUDENT_ADRR = (int) 2e3; //(int) 2e9
    @Test
    public void test_random() throws IOException {

        final Random random = new Random();

        // количество учеников 0 < N < 100001
        int n = random.nextInt(1, MAX_STUDENT_COUNT);
        SortedSet<Integer> setNumbers = new TreeSet<>();
        while (setNumbers.size() < n) {
            setNumbers.add(random.nextInt(1, MAX_STUDENT_ADRR));
        }
        int[] studentsAddresses = setNumbers.stream().mapToInt(Integer::intValue).toArray();

        int testAnswer = D.computeSchoolAdrr(studentsAddresses); // call the main method
        int trueAnswer = computeSchoolAdrrFull(studentsAddresses);
        // checkout output
        assertEquals(trueAnswer, testAnswer);
    }
}


