package alg2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class E {
    public static int findTime(ArrayList<Integer> folders){
        Collections.sort(folders);
        if (folders.size() > 1) {
            folders.remove(folders.size()-1); // удаляем самую большую папку, если папок больше одной
        } else return 0; // если пака всего одна то времени тратить не надо
        return folders.stream().reduce(Integer::sum).get();// + folders.size();
    }

    public static void main(String[] args) throws IOException {
        // parse input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int foldersCount = Integer.parseInt(reader.readLine()); // не используем т.к. сами парсим следющую строку
        String[] splitLine = reader.readLine().split(" ");
        ArrayList<Integer> folders = new ArrayList<>();
        for (String s : splitLine) {
            folders.add(Integer.parseInt(s));
        }

        System.out.println(findTime(folders));
    }
}
