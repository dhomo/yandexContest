package alg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static final int BUILDING_COUNT = 10;

    public static int[] parseInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] splitLine = reader.readLine().split(" ");
        int[] streetPlan = new int[BUILDING_COUNT];
        for (int i = 0; i < BUILDING_COUNT; i++) {
            streetPlan[i] = Integer.parseInt(splitLine[i]);
        }
        return streetPlan;
    }

    // для каждого дома ищем ближайший мгаз в обе стороны, запоминаем только макс растояние
    public static int calcMaximumDistance(int[] streetPlan){
        int maximumDistance = 0;
        for (int i = 0; i < streetPlan.length; i++) {
            if (streetPlan[i] == 1){
                // forward
                int distToNearest = Integer.MAX_VALUE;
                for (int j = i+1; j < streetPlan.length; j++) {
                    if (streetPlan[j] == 2){
                        distToNearest = j-i;
                        break;
                    }
                }
                // backward
                for (int j = i-1; j >= 0; j--) {
                    if (streetPlan[j] == 2){
                        distToNearest = Math.min(distToNearest, i - j);
                        break;
                    }
                }
                maximumDistance = Math.max(maximumDistance, distToNearest);
            }
        }
        return maximumDistance;
    }

    public static void main(String[] args) throws IOException {
        int[] streetPlan = parseInput();

        System.out.println(calcMaximumDistance(streetPlan));
    }
}
