package com.mycompany.app;

public class App 
{
    public static void main( String[] args )
    {
        Auto auto1 = new Auto("Audi","Q8","Benzina","sportiva",2000000,120000, 2010);
        Auto auto2 = new Auto("BMW","Q8","Diesel","berlina",2000000,120000, 2010);
        Auto auto3 = new Auto("Fiat","500","Diesel","berlina",2000000,120000, 2010);
        Concessionaria con1 = new Concessionaria("a", "via");
        System.out.println(auto1.calcValore());
        System.out.println(con1.calcAssicurazione(auto1));

        con1.addVeicolo(auto1);
        con1.addVeicolo(auto2);
        con1.addVeicolo(auto3);
        //System.out.println(con1.getInventario());

        System.out.println("\nRICERCA: ");
        //System.out.println(con1.cercaVeicolo("audi, 2006,SpORtiva, ,benzina,.,"));
        //System.out.println(con1.cercaVeicolo("q8 bmw audi"));
        //con1.cercaVeicolo("q8 bmw audi");
        con1.cercaVeicolo("q8 bmw audi 2010");
    }
}
