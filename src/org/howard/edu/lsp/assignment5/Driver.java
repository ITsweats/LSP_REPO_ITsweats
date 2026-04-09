package org.howard.edu.lsp.assignment5;

public class Driver {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + set1.union(set2));
        System.out.println("Intersection: " + set1.intersect(set2));
        System.out.println("Difference: " + set1.diff(set2));
        System.out.println("Complement: " + set1.complement(set2));
    }
}
