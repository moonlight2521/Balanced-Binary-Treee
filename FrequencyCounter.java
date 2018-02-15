import java.util.*;

/**
 * Zun Lin
 * Java Keyword Identifier
 * the program is to count the frequency of the word
 * this file is from blackboard I didn't write this file. I modified it a little.
 */
public class FrequencyCounter {
    // private DictionaryInterface<String, Integer> wordTable;
    private TreeMap<String, Integer> wordTable;

    public FrequencyCounter() {
        wordTable = new TreeMap<String, Integer>();
    }

    /** Task: Reads a text file of words and counts their frequencies
     *        of occurrence.
     * data a text scanner for the text file of data */
    public void readWord(String word) {

        word.toLowerCase().trim();
        Integer frequency = wordTable.get(word);
        if (frequency == null) {                // add new word to table
            wordTable.put(word, new Integer(1));
        } else {                                    // increment count of existing word; replace wordTable entry
            frequency++;
            wordTable.put(word, frequency);
        }
        wordTable.remove("");      //remove null values
    }

    /** Task: Displays words and their frequencies of occurrence. */
    public void display()         //print the values
    {
        Set<Map.Entry<String, Integer>> allWords = wordTable.entrySet();
        Iterator<Map.Entry<String, Integer>> keyIterator = allWords.iterator();

        while (keyIterator.hasNext())   {
            Map.Entry<String, Integer> element =  keyIterator.next();
                    System.out.println(element.getKey() + " " + element.getValue());

        }
    }
} 
