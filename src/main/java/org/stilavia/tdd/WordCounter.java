package org.stilavia.tdd;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Counts the amount of words in a text stream. A word is a sequence of characters that does not contains
 * characters specified in java.lang.Character.isWhitespace.
 */
public class WordCounter {

    /**
     * Given an input stream, counts the amount of words. The return object is a map where
     * keys are the words, and the value of each key is the number of times that the word appears
     * in the text.
     *
     * For example given the text: "Today is not a sunny day, also not my day." the outcome would
     * be a map such that:
     *      "Today" -> 1
     *      "is" -> 1
     *      "not" -> 2
     *      "a" -> 1
     *      "sunny" -> 1
     *      "day," -> 1
     *      "also" -> 1
     *      "my" -> 1
     *      "day." -> 1
     *
     * @param is text input stream.
     * @return Returns the mapping of words and counts.
     */
    public Map<String, Integer> count(InputStream is) {
        throw new UnsupportedOperationException("org.stilavia.tdd.WordCounter.count");
    }

}
