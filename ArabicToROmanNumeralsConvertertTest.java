package com.company;

import org.junit.Test;
import static org.junit.Assert.*;
import com.company.NumberConverter;

public class ArabicToROmanNumeralsConvertertTest {

    NumberConverter converter = new NumberConverter();

    @Test
    public void testCleanMultipleOfTenThousands() {
        //By clean multiple it means every digit following the starting is 0

        //Thousands
        assertEquals("MMM", converter.generate(3000));

        //Hundreads
        assertEquals("CC", converter.generate(200));
        assertEquals("CD", converter.generate(400));
        assertEquals("DCC", converter.generate(700));
        assertEquals("CM", converter.generate(900));

        //Tens
        assertEquals("XX", converter.generate(20));
        assertEquals("XL", converter.generate(40));
        assertEquals("LX", converter.generate(60));
        assertEquals("XC", converter.generate(90));

        //Ones
        assertEquals("III", converter.generate(3));
        assertEquals("IV", converter.generate(4));
        assertEquals("VIII", converter.generate(8));
        assertEquals("IX", converter.generate(9));
    }

    @Test
    public void testMultipleDigitsWithRepeatingDigits() {
        //multiple digit with repeating digits

        //Thousands
        assertEquals("MMMCCCXXXIII", converter.generate(3333));

        //Hundreads
        assertEquals("CXI", converter.generate(111));
        assertEquals("CDXLIV", converter.generate(444));
        assertEquals("DCCLXXVII", converter.generate(777));
        assertEquals("CMXCIX", converter.generate(999));

        //Tens
        assertEquals("XXII", converter.generate(22));
        assertEquals("XXXIII", converter.generate(33));
        assertEquals("LXVI", converter.generate(66));
        assertEquals("XCIX", converter.generate(99));
    }

    @Test
    public void testMultipleDigits() {
        //multiple digit

        //Thousands
        assertEquals("MMMCDLVII", converter.generate(3457));

        //Hundreads
        assertEquals("CLXXXIII", converter.generate(183));
        assertEquals("CDLVI", converter.generate(456));
        assertEquals("DCCXXV", converter.generate(725));
        assertEquals("CMXCIX", converter.generate(999));

        //Tens
        assertEquals("XXIX", converter.generate(29));
        assertEquals("XLVI", converter.generate(46));
        assertEquals("LXIV", converter.generate(64));
        assertEquals("XCII", converter.generate(92));
    }

    @Test
    public void testSingleDigits() {
        //Testing single digit roman numerals

        //Thousands
        assertEquals("M", converter.generate(1000));

        //Hundreads
        assertEquals("C", converter.generate(100));
        assertEquals("D", converter.generate(500));

        //Tens
        assertEquals("X", converter.generate(10));
        assertEquals("L", converter.generate(50));

        //Ones
        assertEquals("I", converter.generate(1));
        assertEquals("V", converter.generate(5));
    }

    @Test
    public void testZero() {
        //Test cases that are out of bounds

        assertEquals("Number not supported. Please enter numbers between 1 and 3999.", converter.generate(0));
        assertEquals("Number not supported. Please enter numbers between 1 and 3999.", converter.generate(5000));
    }


}
