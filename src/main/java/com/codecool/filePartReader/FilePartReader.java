package com.codecool.filePartReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("Illegal argument");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        StringBuilder data = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                data.append(reader.nextLine());
                data.append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new IOException();
        }
        return data.toString();
    }

    public String readLines() {
        String data;
        StringBuilder sb = new StringBuilder();
        try {
            data = read();
            String[] dataLines = data.split("\n");
            String[] neededLines = Arrays.copyOfRange(dataLines, fromLine - 1, toLine);
            sb.append(String.join(" ", neededLines));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }
}
