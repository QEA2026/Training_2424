package com.revature.collections;

import java.util.List;
import java.util.Scanner;

public class LinkedVsArrayVsVector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose list type: ArrayList(1), LinkedList(2), Vector(3)");
        int number = scan.nextInt();

        while(number!=0){

            List<Object> things = ListFactory.getList(number);

            long start = System.nanoTime();
            for(int i=0; i<100000; i++){
                things.add(new Object());
            }
            long end = System.nanoTime();
            System.out.println("Add to end: " +(end-start)/1_000_000 + "ms");

            System.out.println("\nTry another: 1 ArrayList, 2 LinkedList, 3 Vector, 0 quit");
            number = scan.nextInt();
        }
    }
}
