package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addition(){
        assertEquals(7,App.addition(2,5));
        assertEquals(-5,App.addition(-7,2));
    }

    @Test
    public void subtraction(){
        assertEquals(7,App.subtraction(9,2));
        assertEquals(-9,App.subtraction(-7,2));
    }

    @Test
    public void multiplication(){
        assertEquals(10,App.multiplication(2,5));
        assertEquals(-14,App.multiplication(-7,2));
    }

    @Test
    public void division(){
        assertEquals(4,App.division(20,5));
        assertEquals(-35,App.division(-70,2));
    }
}
