package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void add() {
    }

    @Test
    public void remove() {//
    }//

    @Test
    public void showAll() {
    }

    @Test
    public void findX() {
    }

    @Test
    public void interpolate() {
        Table expected = new Table();
        expected.add(0, 0);
        expected.add(1,1);
        expected.add(2,2);

        assertEquals(3.0, expected.interpolate(3), 0.000001);

        expected.clear();
        expected.add(0, 0);
        expected.add(1,1);
        expected.add(2,4);
        expected.add(10, 100);

        assertEquals(25.0, expected.interpolate(5), 0.000001);

        expected.clear();
        expected.add(1, 2);
        expected.add(6,-1.5);
        expected.add(8.7,12.55);

        assertEquals(14.8011, expected.interpolate(9), 0.001);
    }
}