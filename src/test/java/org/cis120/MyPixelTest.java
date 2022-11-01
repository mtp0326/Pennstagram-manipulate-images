package org.cis120;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Use this file to test your implementation of Pixel.
 * 
 * We will manually grade this file to give you feedback
 * about the completeness of your test cases.
 */

public class MyPixelTest {

    /*
     * Remember, UNIT tests should ideally have one point of failure. Below we
     * give you two examples of unit tests for the Pixel constructor, one that
     * takes in three ints as arguments and one that takes in an array. We use
     * the getRed(), getGreen(), and getBlue() methods to check that the values
     * were set correctly. These two tests do not comprehensively test all of
     * Pixel so you must add your own.
     *
     * You might want to look into assertEquals, assertTrue, assertFalse, and
     * assertArrayEquals at the following:
     * http://junit.sourceforge.net/javadoc/org/junit/Assert.html
     *
     * Note, if you want to add global variables so that you can reuse Pixels
     * in multiple tests, feel free to do so.
     */

    @Test
    public void testConstructInBounds() {
        Pixel p = new Pixel(40, 50, 60);
        assertEquals(40, p.getRed());
        assertEquals(50, p.getGreen());
        assertEquals(60, p.getBlue());
    }

    @Test
    public void testConstructArrayLongerThan3() {
        int[] arr = { 10, 20, 30, 40 };
        Pixel p = new Pixel(arr);
        assertEquals(10, p.getRed());
        assertEquals(20, p.getGreen());
        assertEquals(30, p.getBlue());
    }

    /* ADD YOUR OWN TESTS BELOW */

    @Test
    public void testConstructOutOfBounds() {
        Pixel p = new Pixel(1000, -30, 27);
        assertEquals(255, p.getRed());
        assertEquals(0, p.getGreen());
        assertEquals(27, p.getBlue());
    }

    @Test
    public void testConstructArrayShorterThan3() {
        int[] arr = { 10, 3900 };
        Pixel p = new Pixel(arr);
        assertEquals(10, p.getRed());
        assertEquals(255, p.getGreen());
        assertEquals(0, p.getBlue());
    }

    @Test
    public void testConstructArrayOutOfBounds() {
        int[] arr = { 10, 1000, -49 };
        Pixel p = new Pixel(arr);
        assertEquals(10, p.getRed());
        assertEquals(255, p.getGreen());
        assertEquals(0, p.getBlue());
    }

    @Test
    public void testGetComponents() {
        int[] arr = { 100, 392, 221 };
        Pixel p = new Pixel(arr);
        assertEquals(100, p.getComponents()[0]);
        assertEquals(255, p.getComponents()[1]);
        assertEquals(221, p.getComponents()[2]);
    }

    @Test
    public void testDistance() {
        int[] arr = { 0, 0, 0 };
        Pixel pArr = new Pixel(arr);
        int[] arr1 = { 10, 20, 30 };
        Pixel pArr1 = new Pixel(arr1);
        assertEquals(60, pArr.distance(pArr1));
    }

    @Test
    public void testDistanceFlipped() {
        int[] arr = { 3, 52, 5 };
        Pixel pArr = new Pixel(arr);
        int[] arr1 = { 0, 0, 0 };
        Pixel pArr1 = new Pixel(arr1);
        assertEquals(60, pArr.distance(pArr1));
    }

    @Test
    public void testToString() {
        int[] arr = { 255, 0, 128 };
        Pixel p = new Pixel(arr);
        assertEquals("(255, 0, 128)", p.toString());
    }

    @Test
    public void testToStringVoid() {
        int[] arr = {};
        Pixel p = new Pixel(arr);
        assertEquals("(0, 0, 0)", p.toString());
    }

    @Test
    public void testEqualTo() {
        int[] arr1 = { 10, 20, 30, 40 };
        Pixel p1 = new Pixel(arr1);
        int[] arr2 = { 10, 20, 30, 40 };
        Pixel p2 = new Pixel(arr2);
        assertTrue(p1.equals(p2));
    }

    public void testEqualToVoid() {
        int[] arr1 = {};
        Pixel p1 = new Pixel(arr1);
        int[] arr2 = {};
        Pixel p2 = new Pixel(arr2);
        assertTrue(p1.equals(p2));
    }
}