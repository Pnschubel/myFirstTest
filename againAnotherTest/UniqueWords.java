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
      // Read the dictionary and the document
      Set<String> UniqueWords = readWords("words");
      Set<String> documentWords = readWords("alice30.txt");


      // Print all words that are in the document but not the dictionary

      for (String word : UniqueWords)
      {
         System.out.println(word);
      }
      
      //Prints
   }
   
   //MUST MAKE CLEAN METHOD

   /**
      Reads all words from a file.
      @param filename the name of the file
      @return a Set with all unique words of the file in it.
   */
   public static Set<String> readWords(String filename)
      throws FileNotFoundException
   {
       Set<String> words = new TreeSet<>();
       Scanner scan = new Scanner(new File(filename));
       
       //Cleans file of unnecessary characters
       scan.clean();
       
       //Use any characters other than a-z or A-Z as delimiter
       scan.useDelimiter("[^a-zA-Z]");
       while(scan.hasNext()){
           words.add(scan.next().toUpperCase());
        }
       return words;
   }
}



