package alg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static int calcCost(String string){
        int cost = 0;
        for (int i = string.length() / 2; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)){
                cost++;
            }
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        System.out.println(calcCost(string));
    }
}
