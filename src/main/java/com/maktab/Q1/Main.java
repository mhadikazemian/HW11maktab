package com.maktab.Q1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        Cat.createCatList(cats);
        Cat.assignBreeds(cats);
        System.out.println(Cat.filterCats(cats));
    }//End of main method
}//End of Main class
