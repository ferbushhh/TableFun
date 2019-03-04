package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import static org.junit.Assert.*;

public class TableTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    Table expected = new Table();

    @Before
    public void setUpStreams() {
        expected.add(8,9);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        expected.clear();
        System.setOut(null);
    }

    @Test
    public void add() {
        assertEquals(9.0, expected.getY(8), 0.001);

        expected.clear();
        expected.add(0,0);
        expected.add(3,6);
        assertEquals(0.0, expected.getY(0), 0.001);
        assertEquals(6, expected.getY(3), 0.001);
    }

    @Test
    public void remove() {
        Table actual = new Table();
        expected.remove(8,9);
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void showAll() {
        expected.add(7,9);
        expected.showAll();
        Assert.assertEquals("8.0 9.0\r\n7.0 9.0\r\n", outContent.toString());
    }

    @Test
    public void findX() {
        expected.add(1,1);
        expected.add(6,7);
        assertEquals(1, expected.findX(2).getX(), 0.01);
    }

    @Test
    public void interpolate() {
        expected.clear();
        expected.add(0, 0);
        expected.add(1,1);
        expected.add(2,2);

        assertEquals(3.0, expected.interpolate(3), 0.001);

        expected.clear();
        expected.add(0, 0);
        expected.add(1,1);
        expected.add(2,4);
        expected.add(10, 100);

        assertEquals(25.0, expected.interpolate(5), 0.001);

        expected.clear();
        expected.add(1, 2);
        expected.add(6,-1.5);
        expected.add(8.7,12.55);

        assertEquals(14.8011, expected.interpolate(9), 0.001);
    }

}