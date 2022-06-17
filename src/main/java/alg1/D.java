package alg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static int[] parseInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] splitLine = reader.readLine().split(" ");
        int[] studentsAddresses = new int[n];
        for (int i = 0; i < n; i++) {
            studentsAddresses[i] = Integer.parseInt(splitLine[i]);
        }
        return studentsAddresses;
    }
    public static int computeSchoolAdrr(int[] studentsAddresses){
        return studentsAddresses[(studentsAddresses.length - 1) / 2]; // мазафака, это верное решение!!!!
    }

    public static void main(String[] args) throws IOException {
        int[] studentsAddresses = parseInput();
        int result = computeSchoolAdrr(studentsAddresses);
        System.out.println(result);
    }
}