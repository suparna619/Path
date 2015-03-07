package com.paths;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile{
    public String readFile(String fileName) {
        String text = null;
        File file = new File(fileName);
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            text = new String(chars);
            reader.close();
        } catch (IOException e) {
            System.out.println("Error : "+e);
        }
        return text;
    }
}