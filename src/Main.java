import utils.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static final int OPERATION_LIM = 2;
    public static int N = 5;
    public static String D = "words-second-half.txt";

    public static void main(String[] args) {
        HashSet<String> dict = Utils.getDictionary(D);

        Scanner sc = new Scanner(System.in);
        TyperAlgorithmType[] vals = TyperAlgorithmType.values();

        System.out.println("Choose one of the algorithms: ");
        for (int i = 0; i < vals.length; i++) {
            System.out.printf("\tType %d for %s\n", i, vals[i]);
        }
        int algorithmHelperType = sc.nextInt();
        sc.nextLine();
        TyperHelper th = new TyperHelper(vals[algorithmHelperType], dict);

        while (true) {
            System.out.println("Enter a word: ");
            String input = sc.nextLine();
            long initialTime = new Date().getTime();
            List<String> corrections = th.correct(input, OPERATION_LIM, N);
            System.out.printf("Found corrections in %d milliseconds.\n", new Date().getTime() - initialTime);
            for (String correction : corrections) {
                System.out.println(correction);
            }
        }
    }
}

