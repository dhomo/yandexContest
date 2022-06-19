package alg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class D {
    public static int[] findRequiredBlocks(int plateLength, int[] blocks){
        // если длина нечетна и есть блок по центтру то достаточноно его одного
        if ((plateLength % 2 > 0) && Arrays.binarySearch(blocks, plateLength / 2) >= 0){
            return new int[]{Math.floorDiv(plateLength,2)};
        }

        int[] result = new int[2];
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] >= plateLength/2){
                result[1] = blocks[i];
                break;
            }
        }
        for (int i = blocks.length-1; i >= 0; i--) {
            if (blocks[i] < plateLength/2){
                result[0] = blocks[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        // parse input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] splitLine = reader.readLine().split(" ");
        int plateLength = Integer.parseInt(splitLine[0]);
        int n = Integer.parseInt(splitLine[1]);
        splitLine = reader.readLine().split(" ");
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = Integer.parseInt(splitLine[i]);
        }

        int[] redundantBlocks = findRequiredBlocks(plateLength, blocks);
        // int[] {1, 10} в String "1 10"
        String result = Arrays
                .stream(redundantBlocks)
                .mapToObj(String::valueOf)
                .reduce((sumStr, b) -> sumStr.concat(" ").concat(b))
                .get();
        System.out.println(result);
    }
}
