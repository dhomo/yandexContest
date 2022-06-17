package alg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> setNumbers = new TreeSet<>();
        int number = 0;
        int count = 1;
        setNumbers.add(0);
        while ((number = Integer.parseInt(reader.readLine())) != 0) {
            boolean contain = !setNumbers.add(number);
            if (setNumbers.last() == number){
                if (contain) {
                    count++;
                } else {
                    count = 1;
                }
            }
        }

        System.out.println(count);
    }
}
