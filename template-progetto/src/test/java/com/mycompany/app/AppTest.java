package com.mycompany.app;

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
    public void testAddVeicoloConcessionaria() {
        Auto automobile = new Auto("Mercedes-Benz", "AMG", "V12", "Coupé", 65492, 100, 2022);
        Concessionaria concessionariaAuto = new Concessionaria("Mercedes-Benz Cinisello Balsamo", "Via Matteo Boca, 57 20092 Milano");
        concessionariaAuto.addVeicolo(automobile);
    }
}
