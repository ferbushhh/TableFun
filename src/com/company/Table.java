package com.company;

import java.util.ArrayList;
import static java.lang.Math.*;
import java.util.List;

import static java.lang.Double.MAX_VALUE;

public class Table {

    private ArrayList<Pair> table = new ArrayList<>();

    public Table(){
    }

    public Pair getPair(int i) { //выдает пару по индексу
        Pair pair = table.get(i);
        return (pair);
    }

    public int size() { //вычисляет размер
        return table.size();
    }

    public double getY(double x) { //выдает y по данному x
        boolean flag = false;
        try {
        for (int i = 0; i < table.size(); i++) {
                if (table.get(i).getX() == x) {
                    flag = true;
                    return table.get(i).getY();
                }
            }
        throw new IllegalArgumentException(" ");
        } catch (IllegalArgumentException e) {
            System.out.println("No pair");
        }
        return 0;
    }

    public void add(double x, double y) { //добавляет пару в таблицу
        int size = table.size();
        Pair pair = new Pair(x, y);
        try {
            for (int i = 0; i < size; i++) {
                if (table.get(i).getX() == x) throw new IllegalArgumentException("");
            }
            table.add(size, pair);
        } catch (IllegalArgumentException p) {
            System.out.println("A pair with such x(" + x +") is already in this table!");
        }

    }

    public void remove (double x, double y) { //удаляет пару из таблицы
        boolean flag = false;
        try {
            for (int i = 0; i < table.size(); i++) {
                if (table.get(i).getX() == x && table.get(i).getY() == y) {
                    flag = true;
                    table.remove(i);
                }
            }
            if (!flag) throw new IllegalArgumentException("");
        } catch (IllegalArgumentException p) {
            System.out.println("This element (" + x + ", " + y + ") is not");
        }
    }

    public void showAll() { //показать все пары
        for (int i = 0; i < table.size(); i++) {
            System.out.print(table.get(i).getX() + " ");
            System.out.println(table.get(i).getY());
        }
    }

    public Pair findX(double x0) { //найти ближайшую пару по x
        int n = table.size();
        int index = -1;
        double min = MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (Math.abs(x0 - table.get(i).getX()) < min){
                min = Math.abs(x0 - table.get(i).getX());
                index = i;
            }
        }
        return table.get(index);
    }

    public boolean contains(double x, double y) { //проверка - есть ли пара в таблице
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getX() == x && table.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }

    public void clear() { //очистить всю таблицу
        int n = table.size();
        for (int i = 0; i < n; i++) {
            table.remove(0);
        }
    }

    public void removeDuplicate() { //удаление всех повторяющихся
        int n = table.size();
        Table tableHelp = new Table();
        for (int i = 0; i < n; i++) {
            if (!tableHelp.contains(table.get(i).getX(), table.get(i).getY())) {
                tableHelp.add(table.get(i).getX(), table.get(i).getY());
            }
        }
        table.clear();
        for (int i = 0; i < tableHelp.size(); i++) {
            Pair pair = new Pair(tableHelp.getPair(i).getX(), tableHelp.getPair(i).getY());
            table.add(i, pair);
        }
    }

    public double interpolate(double node) { //интерполяция

        double lag = 0;
        double polinom;
        int size = table.size();


        for (int i = 0; i < size; i++) {
            polinom = 1;
            for (int j = 0; j < size; j++) {
                if (i != j)
                    polinom *= (node - table.get(j).getX())/(table.get(i).getX() - table.get(j).getX());
            }
            lag += polinom * table.get(i).getY();
        }

        return lag;
    }
}

