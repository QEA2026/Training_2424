package com.revature.JavaIO;

import java.io.IOException;

public class DemoIO {
    public static void main(String[] args) {
        try{
            setup.setupSampleData();
        } catch (IOException e){
            System.out.println("File error occurred: " +e.getStackTrace());
        }

    }
}
