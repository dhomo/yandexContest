package con35674;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static char[][] maze;

    public static void step (int r, int c, char label){
        maze[r][c] = label;
        if (maze[r][c+1] == '.') step(r, c+1, 'R');
        if (maze[r][c-1] == '.') step(r, c-1, 'L');
        if (maze[r+1][c] == '.') step(r+1, c, 'D');
        if (maze[r-1][c] == '.') step(r-1, c, 'U');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] string = reader.readLine().split(" ");
        int n = Integer.parseInt(string[0]);
        int m = Integer.parseInt(string[1]);

        maze = new char[n][m];
//        for (char[] row: maze ) {
//            reader.read(row);
//            reader.read(); // пропускаем \n символ
//        }

        int startR = 0,startC = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = (char) reader.read();
                //читать построчно быстрее, но тогда придется еще раз проходить по всему массиву в поисках точки старта
                if (maze[i][j] == 'S'){
                    startR = i;
                    startC = j;
                }
            }
            reader.skip(1); // пропускаем \n символ
        }

        step(startR, startC, 'S');

        for (char[] row: maze ) {
            System.out.println(row);
        }
    }
}
