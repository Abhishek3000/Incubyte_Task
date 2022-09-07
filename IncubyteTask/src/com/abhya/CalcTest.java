package com.abhya;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalcTest {

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("com.abhya.CalcTest");
    }

    @Test
    public void testEString() {
        assertEquals(0, Calcu.add(""));
    }

    @Test
    public void test1Number() {
        assertEquals(1, Calcu.add("1"));
    }

    @Test
    public void test2Numbers(){
        assertEquals(3, Calcu.add("1,2"));
    }

    @Test
    public void differentAmountNumbers(){
        assertEquals(6, Calcu.add("1,2,3"));
    }

    @Test
    public void testNewLine(){
        assertEquals(6, Calcu.add("1\n2,3"));
    }

    @Test
    public void testAlphabets(){
        assertEquals(7, Calcu.add("1,2,a,c"));
    }



    @Test
    public void testNegativeNumber(){
        try {
            Calcu.add("-1,2");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -1");
        }

        try {
            Calcu.add("2,-4,3,-5");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
        }
    }

    @Test
    public void testOverThousand(){
        assertEquals(2, Calcu.add("1000,2"));
    }


    @Test
    public void testOtherDelimiter(){
        assertEquals(3, Calcu.add("//;\n1;2"));
    }


}