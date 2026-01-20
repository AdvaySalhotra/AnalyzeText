import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Runner to analyze words
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordAnalysis
{

    static ArrayList <Word> text  = new ArrayList<>();

    /**
     * Runner
     * 
     * @param args Not used
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("analyze.txt"));
        Scanner nltk = new Scanner(new File("nltk.txt"));
        Scanner worldLeaders = new Scanner(new File("worldLeaders.txt"));

        ArrayList<String> badWords = new ArrayList<>();
        ArrayList<String> leaders = new ArrayList<>();
        ArrayList<String> mentionedLeaders  = new ArrayList<>();



        while (nltk.hasNextLine()) {
            badWords.add(nltk.nextLine());
        }

        while (worldLeaders.hasNextLine()) {
            leaders.add(worldLeaders.nextLine());
        }

        for (int i = 0; i < leaders.size(); i++) {
            leaders.set(i, leaders.get(i).toLowerCase());
        }


        int count = 0;
        int length = 0;

        int numLeaders = 0;

        String longestWord = null;


        while (input.hasNext()) {

            String nextWord = input.next();
            nextWord = nextWord.replaceAll("[^a-zA-Z]", "");
            nextWord = nextWord.toLowerCase();

            count += 1;

            if (nextWord.length() > length) {

                length = nextWord.length();
                longestWord = nextWord;
            }

            if (!badWords.contains(nextWord)) {
                addToText(nextWord);
            }



            if (leaders.contains(nextWord) && !mentionedLeaders.contains(nextWord)) {
                mentionedLeaders.add(nextWord);
                numLeaders ++;
            }
        }

        String mostCommonWord = mostCommonWord();

        input.close();

        System.out.println("most common word : " + mostCommonWord + " repetitions");
        System.out.println("total unique words found: " + text.size());
        System.out.println("total number of words: " + count);
        System.out.println("longest word : " + longestWord);
        System.out.print("there are " + numLeaders + " world leaders in this text, and they are: ");
        System.out.print(mentionedLeaders);
    }

    public static String mostCommonWord () {

        int maxCount = 0;
        String commonWord = "";
            for (Word x : text) {
                if (x.getCount() > maxCount) {
                    maxCount = x.getCount();
                    commonWord = x.getWord();
                }
            }
            return commonWord + ", " + maxCount;



    }
    public static void addToText (String nextWord) {
        Boolean found = false;
        for (Word x : text) {
            if (x.getWord().equals(nextWord)) {
                x.updateCount()  ;
                found = true;
            }
        }
        if (found == false) {
            text.add(new Word(nextWord));
        }
    }



}
