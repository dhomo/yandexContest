import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int i = Integer.parseInt(splitLine[1]);
        int j = Integer.parseInt(splitLine[2]);

        int route1 = Math.abs(i-j)-1;
        int route2 = n-Math.max(i,j)+Math.min(i,j)-1;
        int result = Math.min(route1, route2);
        System.out.println(result);
    }
}
