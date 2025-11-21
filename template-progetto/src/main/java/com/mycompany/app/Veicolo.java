package com.mycompany.app;

import java.time.LocalDate;

public abstract class Veicolo {
    private String marca, modello, motore, tipologia;
    private int prezzo, cilindrata, anno;
    private final int assicurazioneBase = 100003;
    private final int scontoMax = 500000;

    public Veicolo(String marca, String modello, String motore, String tipologia, int prezzo, int cilindrata, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.motore = motore;
        this.tipologia = tipologia;
        this.prezzo = prezzo;
        this.cilindrata = cilindrata;
        this.anno = anno;
    }


    public int calcValore() {
        int eta = LocalDate.now().getYear() - anno;

        if (eta == anno)
            return prezzo;

        float valore = prezzo/100f;

        for (int i = 0; i < eta; i++) {
            valore *= 0.90f;
        }

        if (this.getClass().getSimpleName().equals("Auto") && this.getMotore().equalsIgnoreCase("elettrico")){
            if (valore <= (scontoMax/100f) * 4) {
                valore *= 0.75f;
                valore = (Math.round(valore * 100.0f) / 100.0f) * 100f;
            } else {
                valore -= scontoMax;
                valore = (Math.round(valore * 100.0f) / 100.0f) * 100f;
            }
        }
        return (int)valore;
    }

    public String getMotore() {
        return motore;
    }

    public String getTipologia() {
        return tipologia;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getAssicurazioneBase() {
        return assicurazioneBase;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    @Override
    public String toString() {
        return marca + " " + modello + " " + motore + " " + tipologia + " " + prezzo + " " + cilindrata + " " + anno;
    }
}

