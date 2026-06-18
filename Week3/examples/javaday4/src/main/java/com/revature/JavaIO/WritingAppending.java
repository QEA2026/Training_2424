package com.revature.JavaIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class WritingAppending {
    static void writeAndCreate() throws IOException {
        //Writing and Appending
        //Three flavors: BufferedWriter, writeString, write(List)

        Path outputDir = Paths.get("output");
        Files.createDirectories(outputDir);

        //write with BufferedWriter
        Path report = outputDir.resolve("report.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(report)){
            writer.write(" === Test Run Report === ");
            writer.newLine();
            writer.write("Generated: " + LocalDateTime.now());
            writer.newLine();

        }
        System.out.println("Wrote: " + report.toAbsolutePath());

        //Append
        try(BufferedWriter writer = Files.newBufferedWriter(report, StandardOpenOption.APPEND)){
            writer.write("PASS: LoginTest");
            writer.newLine();
            writer.write("FAIL: CheckoutTest");
            writer.newLine();

        }
        System.out.println("Appended TO: " + report.toAbsolutePath());
    }
}
