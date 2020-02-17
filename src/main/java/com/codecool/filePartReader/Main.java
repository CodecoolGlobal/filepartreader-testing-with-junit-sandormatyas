package com.codecool.filePartReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("/home/sandormatyas/codecool/oop/filepartreader-testing-with-junit-sandormatyas/src/main/java/com/codecool/filePartReader/test.txt", 1, 2);
        String content = fpr.readLines();
        System.out.println(content);
    }
}
