import utils.Utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static int OPERATION_LIM = 2;
    public static int N = 5;
    public static String D = "words.txt";

     public static void main(String []args){
         updateParameters(args);

         HashSet<String> dict;
         try{
             dict = Utils.getDictionary(D);
         }catch (IOException e){
             System.out.println(e.getMessage());
             return;
         }

         Scanner sc = new Scanner(System.in);
         TyperAlgorithmType[] vals = TyperAlgorithmType.values();

         System.out.println("Choose one of the algorithms: ");
         for(int i = 0; i < vals.length; i++) {
             System.out.printf("\tType %d for %s\n", i, vals[i]);
         }
         int algorithmHelperType = sc.nextInt();
         sc.nextLine();
         TyperHelper th = new TyperHelper(vals[algorithmHelperType], dict);

         while(true){
             System.out.println("Enter a word: ");
             String input = sc.nextLine();
             List<String> corrections = th.correct(input, OPERATION_LIM, N);

             for(String correction: corrections){
                 System.out.println(correction);
             }
         }
     }

     public static void updateParameters(String[] args){
         boolean d = false;
         boolean n = false;

         for(int i=0; i<args.length; i++){
             if(args[i].equals("-d")){
                 d=true;
             }else if(args[i].equals("-n")){
                 n=true;
             }else if(d){
                 D = args[i];
                 d=false;
             }else if(n){
                 N = Integer.parseInt(args[i]);
                 n=false;
             }else{
                 System.out.println("Unrecognized argument.");
             }
         }
     }
}

