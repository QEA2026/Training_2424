package com.revature.JavaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class readingData {

    //reading line-by-line (classic BufferedReader)
    //Use this for large files - it never loads the entire file into memory

    static void readWithBufferedReader() {
        Path path = Paths.get("data/scores.csv");

        //try-with-resources guarentees the reader is ALWAYS closed
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String line;
            int lineNum = 0;
            while((line = reader.readLine()) != null){
                lineNum++;
                System.out.printf("  Line %2d: %s%n", lineNum, line);
            }
        } catch (IOException e){
            System.err.println("Could not read file");
        }
    }

}
