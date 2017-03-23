package testMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Macbeth {
    //Program tasks
    //1) Read the file 'macbeth.txt'.
    //2) Eliminate all words that are 4 characters or less
    //3) Account for words that followed by punctuation
    //4) Output the 2nd most common word and the number of times it appears

    public static void main(String[]args) throws Exception {
        System.out.println("file root: "+File.listRoots()[0].getAbsolutePath());
        List<String> macBethWords = readMacBethFile("/macbeth.txt");
        HashMap<String, Integer> wordCountMap = new HashMap<String,Integer>();
        String keyWord = null;
        int countValue = 0;

        for(int i=0; i < macBethWords.size(); i++) {
            keyWord = macBethWords.get(i);
            if(wordCountMap.containsKey(keyWord)){
                countValue = wordCountMap.get(keyWord) + 1;
                wordCountMap.put(keyWord, countValue);
            } else {
                wordCountMap.put(keyWord, 0);
            }
        }

        Map sortedCountMap = sortByValue(wordCountMap);
        Object[] sortedKeyArray = sortedCountMap.keySet().toArray();

        //Not sure where the single missing instance Macbeth is and why it's not being picked in the count.
        System.out.println("Should be macbeth: "+sortedKeyArray[0]);
        System.out.println("And it's count is: "+sortedCountMap.get("macbeth"));

        System.out.println("Second most common greater than 4 word is: "+sortedKeyArray[1]);
        System.out.println("And it's count is: "+sortedCountMap.get(sortedKeyArray[1]));


        //To look at the full sorted list and their numbers uncomment
//        for(int i=0; i < sortedKeyArray.length; i++) {
//            System.out.println("Sorted word: " + sortedKeyArray[i]);
//            System.out.println("Sorted word Count: "+ sortedCountMap.get(sortedKeyArray[i]));
//
//        }
    }

    private static Map sortByValue(Map unsortedMap){
        Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

    private static List<String> readMacBethFile(String filename) throws Exception {
        String line = null;
        String word = null;
        List<String> records = new ArrayList<String>();

        // wrap a BufferedReader around FileReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        // use the readLine method of the BufferedReader to read one line at a time.
        // the readLine method returns null when there is nothing else to read.
        while ((line = bufferedReader.readLine()) != null)
        {
            //Remove special characters, replacing them with spaces to count as different words
            // (ie. "Macbeth's" should still count Macbeth)
            line = line.replaceAll("\\W", " ");

            //Separate the line into individual words
            String[] words = line.split(" ");

            for(int i = 0; i < words.length; i++) {

                //Lower case all words to make them easier to tell as similar
                word = words[i].toLowerCase();

                //Remove any words that are 4 characters or less
                if (word.length() > 4) {
                    records.add(word);
                }
            }
        }

        // close the BufferedReader when we're done
        bufferedReader.close();
        return records;
    }
}

//Comparator to sort the Word Count Map
class ValueComparator implements Comparator {
    Map map;

    public ValueComparator(Map map){
        this.map = map;
    }

    public int compare(Object keyA, Object keyB) {
        Comparable valueA = (Comparable) map.get(keyA);
        Comparable valueB = (Comparable) map.get(keyB);
        return valueB.compareTo(valueA);
    }
}
