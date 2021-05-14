import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main{

    public static final int OPERATION_LIM = 2;
    public static int N = 5;
    public static String D = "words.txt";

     public static void main(String []args){
         HashSet<String> dict = Utils.getDictionary(D);
         TyperHelper th = new TyperHelper(TyperAlgorithmType.WORD_TREE, dict);

         Scanner sc = new Scanner(System.in);
         while(true){
             String input = sc.nextLine();
             List<String> corrections = th.correct(input, OPERATION_LIM, N);

             for(String correction: corrections){
                 System.out.println(correction);
             }
         }
     }
}

