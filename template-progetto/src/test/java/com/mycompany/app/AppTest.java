package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testGetTipologiaAuto() {
        Auto automobile = new Auto("Mercedes-Benz", "AMG", "V12", "Coupé", 65492, 100, 2022);
        assertEquals("Coupé", automobile.getTipologia());
    }
}
