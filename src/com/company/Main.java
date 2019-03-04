package com.company;

public class Main {

    public static void main(String[] args) {
        Table mass = new Table();
        mass.add(8,9);
        mass.add(1,1);
        mass.add(6,7);
        //mass.findX(2);
        System.out.println(mass.getY(2));

        //System.out.println(mass.interpolate(9));
        //mass.showAll();
    }
}
