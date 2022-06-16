import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] splitLine = reader.readLine().split(" ");
        int x = Integer.parseInt(splitLine[0]);
        int y = Integer.parseInt(splitLine[1]);
        int z = Integer.parseInt(splitLine[2]);

        int result = 0;
        if (x > 12 || y > 12 || x == y) {
            result = 1;
        }

        System.out.println(result);
    }
}
