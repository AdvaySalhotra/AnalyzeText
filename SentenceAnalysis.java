import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Runner to analyze sentences
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SentenceAnalysis
{
    /**
     * Runner
     * 
     * @param args Not used
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("analyze.txt"));

        while (input.hasNext()) {
            String nextWord = input.next();

        }
        
        input.close();
    }
}
