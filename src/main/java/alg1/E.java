package alg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    public static int findDotPos(int d, int dotX, int dotY){
        int[] x = new int[4];
        int[] y = new int[4];
        // dot X
        x[0]=dotX;
        y[0]=dotY;
        // A
        x[1]=0;
        y[1]=0;
        // B
        x[2]=d;
        y[2]=0;
        // C
        x[3]=0;
        y[3]=d;

        int a = (x[1] - dotX) * (y[2] - y[1]) - (x[2] - x[1]) * (y[1] - y[0]);
        int b = (x[2] - dotX) * (y[3] - y[2]) - (x[3] - x[2]) * (y[2] - y[0]);
        int c = (x[3] - dotX) * (y[1] - y[3]) - (x[1] - x[3]) * (y[3] - y[0]);

        if ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0))
        {
            return 0; // внутри треугольника или на стороне
        }
        else
        {
            if (dotX <= d/2.0 && dotY <= d/2.0){
                return 1; // ближе точка А
            } else if (dotX == dotY || dotX > dotY){
                return 2; // одинаковое растояние до В и С, или ближе В
            } else {
                return 3; // ближе C
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(reader.readLine());
        String[] splitLine = reader.readLine().split(" ");
        int dotX = Integer.parseInt(splitLine[0]);
        int dotY = Integer.parseInt(splitLine[1]);

        System.out.println(findDotPos(d, dotX, dotY));
    }
}
