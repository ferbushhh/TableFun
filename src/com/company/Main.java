package com.company;

public class Main {

    public static void main(String[] args) {
        Table mass = new Table();
        mass.add(1.0, 1.0);
        mass.add(7, 8);

        System.out.println(mass.interpolate(9));
        //mass.showAll();
    }
}
