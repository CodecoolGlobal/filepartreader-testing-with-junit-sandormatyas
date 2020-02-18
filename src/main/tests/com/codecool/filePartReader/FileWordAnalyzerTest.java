package com.codecool.filePartReader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileWordAnalyzerTest {
    @Test
    public void testPalindrome() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("/home/sandormatyas/codecool/oop/filepartreader-testing-with-junit-sandormatyas/src/main/java/com/codecool/filePartReader/test.txt", 1,4);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("racecar");
        assertEquals(expected, fwa.getStringsWhichPalindromes());
    }

    @Test
    public void testGetWordsOrderedAlphabetically() {
        List<String> expected = Arrays.asList("bababuj", "line", "racecar", "second", "third.");
        FilePartReader fpr = new FilePartReader();
        fpr.setup("/home/sandormatyas/codecool/oop/filepartreader-testing-with-junit-sandormatyas/src/main/java/com/codecool/filePartReader/test.txt", 1,4);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        assertEquals(expected, fwa.getWordsOrderedAlphabetically());
    }

    @Test
    public void testSubstringWithoutResult() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("/home/sandormatyas/codecool/oop/filepartreader-testing-with-junit-sandormatyas/src/main/java/com/codecool/filePartReader/test.txt", 1,4);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        assertEquals(new ArrayList<>(), fwa.getWordsContainingSubstring("token"));
    }

    @Test
    public void testGetWordsContainingSubstring() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("/home/sandormatyas/codecool/oop/filepartreader-testing-with-junit-sandormatyas/src/main/java/com/codecool/filePartReader/test.txt", 1,5);
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        assertEquals(Arrays.asList("second", "corridor"), fwa.getWordsContainingSubstring("co"));
    }
}