package Exersice11_20;
import java.util.*;
import java.io.*;
/*
Write a modified version of the Vocabulary program developed in Chapter 10 that uses sets rather than
ArrayLists to store its words. (The program will be noticeably shorter and will run faster!)
 */
public class Run {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in1 = new Scanner(new File("src/Exersice11_20/File1"));
        Scanner in2 = new Scanner(new File("src/Exersice11_20/File2"));

        Set<String> set1 = getWords(in1);
        Set<String> set2 = getWords(in2);
        Set<String> common = getOverLap(set1,set2);

        reportResulsts(set1,set2,common);
    }

    public static Set<String> getWords(Scanner input){

        // Alfabetisk rækkefølge.
        Set<String> words = new TreeSet<>();
        while (input.hasNext()){
            String next = input.next().toLowerCase();
            words.add(next);
        }
        return words;
    }

    public static Set<String> getOverLap (Set<String> set1, Set<String > set2){

        //retainAll holder på alle de strings som er i begge sets.
        Set<String> result = new TreeSet<>();
        result.addAll(set1);
        result.retainAll(set2);

        return result;
    }

    public static void reportResulsts (Set<String> set1, Set<String> set2, Set<String> common){

        System.out.println("File1: " + set1 );
        System.out.println("\nFile2: " + set2);
        System.out.println("\nOverlappede Ord: " + common);

        double pct1 = 100*common.size() / set1.size();
        double pct2 = 100*common.size() / set2.size();
        System.out.println("\n% af File1 overlappede: " + pct1);
        System.out.println("% af File2 overlappede: " + pct2);
    }
}