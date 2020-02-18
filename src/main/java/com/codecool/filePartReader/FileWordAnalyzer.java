package com.codecool.filePartReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically() {
        List words = Arrays.asList(filePartReader.readLines().split("\\s+"));
        Collections.sort(words);
        return words;
    }

    public List getWordsContainingSubstring(String subString) {
        List<String> words = Arrays.asList(filePartReader.readLines().split("\\s+"));
        List<String> wordsContainingSubstring = new ArrayList<>();
        for (String word: words) {
            if (word.contains(subString)) {
                wordsContainingSubstring.add(word);
            }
        }
        return wordsContainingSubstring;
    }

    public List getStringsWhichPalindromes() {
        List<String> words = Arrays.asList(filePartReader.readLines().split("\\s+"));
        List<String> palindromes = new ArrayList<>();
        for (String word: words) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    private boolean isPalindrome(String word) {
        StringBuilder palindrome = new StringBuilder();
        palindrome.append(word);
        palindrome = palindrome.reverse();
        return palindrome.toString().equals(word);
    }
}
