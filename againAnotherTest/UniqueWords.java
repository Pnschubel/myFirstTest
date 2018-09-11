import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
   This program checks which words in a file are not present in a dictionary.
*/
public class UniqueWords
{
   public static void main(String[] args)
      throws FileNotFoundException
   {
      //Reads the file, cleaning it up and putting individuals words into a set.
      Set<String> UniqueWords = readWords("retrievedRefomation.txt"); //#yesIknowImisspeltthetitledon'tjudgeme

      for (String word : UniqueWords)
      {
         System.out.println(word);
      }
      
      //Prints the size of the set (the # of unique words
      System.out.println("\n\nNumber of Unique Words: " + UniqueWords.size());
   }
   
   /**
    * Cleans all unnecessary characters
    * @param String string -- the string to be cleaned up
    * @return String -- the cleaned up string
    */
   private static String clean(String string){
       //makes string for cleaned up words
       String cleanerString = "";
       char c;
       for (int i = 0; i < string.length(); i++){
           c = string.charAt(i);

           //Will add the character to the cleaner string if char is proper character.
           if (Character.isLetter(c)){
               cleanerString += c;
            }
        }
        
       //returns the cleaner string
       return cleanerString;
    }
   
   /**
      Reads all words from a file.
      @param filename the name of the file
      @return a Set with all unique words of the file in it.
   */
   public static Set<String> readWords(String filename)
      throws FileNotFoundException
   {
       //Gets the file
       Set<String> words = new TreeSet<>();
       Scanner scan = new Scanner(new File(filename));

       //Puts all words in a set.
       while(scan.hasNext()){
           words.add(clean(scan.next().toUpperCase()));
        }
       return words;
   }
}



