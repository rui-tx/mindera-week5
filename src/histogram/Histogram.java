package histogram;

import util.Color;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Histogram implements Iterable<String> {

    private Map<String, Integer> words = new HashMap<>();
    private int largestWordLength = 0;
    private int mostRepeatedWordValue = 0;

    public void analyseString(String stringToAnalyze) {

        String[] arrayToAnalyze = stringToAnalyze.split("[\\s.,;:!?]+");

        for (int i = 0; i < arrayToAnalyze.length; i++) {
            String currentWord = arrayToAnalyze[i].toLowerCase();
            if (words.containsKey(currentWord)) {
                Integer currentWordFrequency = words.get(currentWord) + 1;
                words.replace(currentWord, currentWordFrequency);

                // get most repeated word
                if (words.get(currentWord) > this.mostRepeatedWordValue) {
                    this.mostRepeatedWordValue = words.get(currentWord);
                }
            } else {
                words.put(currentWord, 1);
            }

            // get largest word length
            int temp = currentWord.length();
            if (temp > this.largestWordLength) {
                this.largestWordLength = temp;
            }
        }
    }

    public void analyseFile(String filePath) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String readerLine = "";
        String returnString = "";
        while (true) {
            try {
                if (!((readerLine = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String temp = readerLine;
            returnString = returnString + temp;
        }

        this.analyseString(returnString);
    }

    public int get(String word) {
        // check if exists 1st
        if (this.words.isEmpty() || !this.words.containsKey(word)) {
            throw new NoSuchElementException();
        }

        return words.get(word);
    }

    public Iterator<String> iterator() {
        return this.words.keySet().iterator();
    }

    public void printGraph() {
        Iterator<String> it = this.iterator();
        String format = "%" + this.largestWordLength + "s : %3s ";

        while (it.hasNext()) {
            String word = it.next();
            System.out.printf(format, word, this.get(word));

            int colorValue = (this.get(word) * 100) / this.mostRepeatedWordValue;
            System.out.println(this.getColor(colorValue) + "#".repeat(this.get(word)) + Color.ANSI_RESET);
        }
    }

    private String getColor(int colorValue) {
        if (colorValue <= 20)
            return Color.ANSI_WHITE;

        if (colorValue <= 40)
            return Color.ANSI_GREEN;

        if (colorValue <= 60)
            return Color.ANSI_YELLOW;

        if (colorValue <= 80)
            return Color.ANSI_RED;

        if (colorValue <= 90)
            return Color.ANSI_CYAN;

        return Color.ANSI_PURPLE;
    }


}