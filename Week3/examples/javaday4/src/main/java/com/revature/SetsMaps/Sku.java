package com.revature.SetsMaps;

import java.util.Objects;

public class Sku implements Comparable<Sku>{
    private final String code;

    public Sku(String code) {
        this.code = code;
    }

    /* equals() defines LOGICAL equality.
    * USED BY:
    * - HashSet (duplicate prevention)
    * - HashMap (key matching)
    * Two SKUs are equal if their "code" matches exactly*/

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sku sku = (Sku) o;
        return Objects.equals(code, sku.code);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    //will ignore case when comparing
    public int compareTo(Sku o) {
        return code.compareToIgnoreCase(o.code);
    }

    @Override
    public String toString() {
        return code;
    }
}
