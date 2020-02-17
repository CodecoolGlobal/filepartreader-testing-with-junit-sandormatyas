package com.codecool.filePartReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
            throw new IOException(e);
        }
        return data.toString();
    }

    public String readLines() throws IOException {
        String data = read();
        String[] dataLines = data.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = fromLine - 1; i <= toLine - 1; i++) {
            sb.append(dataLines[i]);
        }
        return sb.toString();
    }
}
