package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Utils {
    public static int strDistance(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] cache = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0)
                    cache[i][j] = j;
                else if (j == 0)
                    cache[i][j] = i;
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    cache[i][j] = cache[i - 1][j - 1];
                else {
                    int[] opt = {cache[i - 1][j], cache[i][j - 1], cache[i - 1][j - 1]};
                    cache[i][j] = 1 + Arrays.stream(opt)
                            .min()
                            .getAsInt();
                }

            }
        }

        return cache[n][m];
    }

    public static HashSet<String> getDictionary() throws IOException {
        return getDictionary("words.txt");
    }

    public static HashSet<String> getDictionary(String filename) throws IOException{
        HashSet<String> dict = new HashSet<>();
        try {
            FileInputStream stream = new FileInputStream(filename);
            Scanner f = new Scanner(stream);    //file to be scanned

            while (f.hasNextLine()) {
                dict.add(f.nextLine().toLowerCase());
            }
            f.close();
        } catch (IOException e) {
           throw new IOException("File not found.");
        }

        return dict;
    }

}