package con35674;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static final String CORRECT = "correct";
    public static final String PRESENT = "present";
    public static final String ABSENT = "absent";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        int n = string.length();
        char[] s = string.toCharArray();
        char[] q = reader.readLine().toCharArray();

        // O(n^2) плохо однако
        outerloop:
        for (int i = 0; i < n; i++) {
            if (q[i] == s[i]){
                System.out.println(CORRECT);
                s[i] = Character.MIN_VALUE;
            } else {
                for (int j = 0; j < n; j++) {
                    if (q[i] == s[j] && q[j] != s[j]) {
                        System.out.println(PRESENT);
                        s[j] = Character.MIN_VALUE;
                        continue outerloop;
                    }
                }
                System.out.println(ABSENT);
            }
        }
    }
}
