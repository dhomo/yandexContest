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

    public static int computeSchoolAdrrold(int[] studentsAddresses){
        int minStAddress = studentsAddresses[0];
        int maxStAddress = studentsAddresses[studentsAddresses.length - 1];
        int minSumPath = Integer.MAX_VALUE;
        int result = 0;
        while (minStAddress <= maxStAddress) {
            int schoolAddress = (minStAddress + maxStAddress) / 2;

            // считаем сумарный путь учеников для текущего расположения школы
            int sumPath = 0;
            for (int j = 0; j < studentsAddresses.length; j++) {
                sumPath += Math.abs(schoolAddress - studentsAddresses[j]);
            }
            System.out.printf("%d\t%d\n",schoolAddress, sumPath);
            if (sumPath < minSumPath) {
                minStAddress = schoolAddress;
                minSumPath = sumPath;
            } else if (sumPath > minSumPath) {
                maxStAddress = schoolAddress;
            } else {
                result = schoolAddress;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        int[] studentsAddresses = parseInput();
        int result = computeSchoolAdrr(studentsAddresses);
        System.out.println(result);
    }
}
