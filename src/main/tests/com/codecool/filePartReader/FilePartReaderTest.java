package com.codecool.filePartReader;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testConstructorSetsInvalidFields() {
        FilePartReader fpr = new FilePartReader();
        assertTrue(fpr.getFromLine() <= 0);
    }

    @Test
    public void testSetupThrowsIllegalArgumentException() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class , ()-> fpr.setup("/home/sandormatyas/codecool/oop/filepartreader-testing-with-junit-sandormatyas/src/main/java/com/codecool/filePartReader/test.txt", -1, 1));
    }

    @Test
    public void testIsIOExceptionThrownOnFileNotFound() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("", 1, 1);
        assertThrows(IOException.class, fpr::read);
    }

    @Test
    public void testReadLines() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("/home/sandormatyas/codecool/oop/filepartreader-testing-with-junit-sandormatyas/src/main/java/com/codecool/filePartReader/test.txt", 2, 2);
        assertEquals("second line", fpr.readLines());
    }
}