package com.revature.SetsMaps;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetsMapsEx {
    public static void main(String[] args) {
        Set<Sku> hash = new HashSet<>();
        hash.add(new Sku("A"));
        hash.add(new Sku("A"));
        hash.add(new Sku("a"));
        System.out.println(hash.size());
        System.out.println(hash);

        TreeSet<Sku> tree = new TreeSet<>();
        tree.add(new Sku("A"));
        tree.add(new Sku("A"));
        tree.add(new Sku("a"));

    }
}
