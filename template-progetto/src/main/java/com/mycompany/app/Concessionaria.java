package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Concessionaria {
    private String nome, indirizzo;
    private ArrayList<Veicolo> inventario;

    public Concessionaria(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        inventario = new ArrayList<>();
    }

    public void addVeicolo(Veicolo v) {
        inventario.add(v);
    }

    public int calcValoreInventario() {
        int valore = 0;

        for (Veicolo v : inventario) {
            valore += v.getPrezzo();
        }
        return valore;
    }

    public ArrayList<Veicolo> getInventario() {
        return inventario;
    }

    public void cercaVeicolo(String ricerca) {
        TreeMap<Integer, List<Veicolo>> risultati = new TreeMap<>();

        String separatori = "[,\\.\\s]+";
        String[] listaFiltri = ricerca.toLowerCase().split(separatori);

        for (Veicolo veicoloInv : inventario) {
            int i;
            i = 0;

            for (String filtro : listaFiltri) {
                if (veicoloInv.toString().toLowerCase().contains(filtro))
                    i++;
            }
            if (i > 0) {
                if (!risultati.containsKey(i)) {
                    risultati.put(i, new ArrayList<>());
                }
                risultati.get(i).add(veicoloInv);
            }
        }
        printRisultati(risultati);
    }

    private void printRisultati(Map<Integer, List<Veicolo>> risultati) {
        for(Map.Entry<Integer, List<Veicolo>> entry : risultati.entrySet()) {
            System.out.println("Liv. Corrispondenza " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public int calcAssicurazione(Veicolo v) {
        float assicurazione = v.getAssicurazioneBase()/100f;

        if (v.getClass().getSimpleName().equals("Auto") && v.getTipologia().equalsIgnoreCase("sportiva")) {
            assicurazione *= 1.20f;

            assicurazione = (Math.round(assicurazione * 100.0) / 100.0f) * 100f;

            return (int)assicurazione;
        }

        if (v.getClass().getSimpleName().equals("Moto")) {
            if (v.getCilindrata() <= 250) {
                return (int)assicurazione*100;
            }
            if (v.getCilindrata() <= 700) {
                assicurazione *= 1.07f;
                assicurazione = (Math.round(assicurazione * 100.0f) / 100.0f) * 100f;
                return (int)assicurazione;
            }
            if (v.getCilindrata() <= 1000) {
                assicurazione *= 1.10f;
                assicurazione = (Math.round(assicurazione * 100.0f) / 100.0f) * 100f;
                return (int)assicurazione;
            }
            if (v.getCilindrata() > 1000) {
                assicurazione *= 1.15f;
                assicurazione = (Math.round(assicurazione * 100.0f) / 100.0f) * 100;
                return (int)assicurazione;
            }
        }
        return (int)assicurazione;
    }
}
