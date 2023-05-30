/**
 * NOME E COGNOME: Luca Anghinolfi
 * NUMERO MATRICOLA: 0001019783
 * EMAIL: luca.anghinolfi2@studio.unibo.it
 **/

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Esercizio2 {

    public static void main(String[] args) {
        //COSTO COMPLESSITA' COMPUTAZIONALE = nlogn - mlogn - mlogn
        Sensore sensore1 = new Sensore(Integer.parseInt(args[0]));
        sensore1.inserimentoValori();
        System.out.println("prima coppia inserita: ");
        sensore1.stampaCoppia(sensore1.primaChiave);
        System.out.println("Visualizzo tutte le coppie minori della prima generata");
        sensore1.stampaCoppieMinori(sensore1.primaChiave);
        System.out.println("Visualizzo tutte le coppie maggiori della prima generata");
        sensore1.stampaCoppieMaggiori(sensore1.primaChiave);
        System.out.println("Visualizzo la coppia minore e la coppia maggiore");
        sensore1.stampaMinMax();

    }

    /**
     * La classe sensore si occupa di tutti i metodi
     * che possono essere utilizzati da ogni sensore
     */
    static class Sensore {
        private int numeroCoppie;
        private TreeMap<Integer, Character> datiSensore = new TreeMap<>();
        private int primaChiave = 0;

        public Sensore(int numeroCoppie) {
            this.numeroCoppie = numeroCoppie;
        }

        /**
         * Inserisce i valori random all'interno del TreeMap
         * e salva la prima coppia generata
         *
         * @return la TreeMap con i valori generati random al suo interno
         */
        public TreeMap<Integer, Character> inserimentoValori() {
            Random valoreRandom = new Random(1019783);
            for (int i = 0; i < numeroCoppie; i++) {
                int Chiave = valoreRandom.nextInt(2000) + 1;
                char Valore = (char) (valoreRandom.nextInt(26) + 'a');
                datiSensore.put(Chiave, Valore);
                if (i == 0)
                    primaChiave = datiSensore.firstKey();
            }
            return datiSensore;
        }

        /**
         * Visualizza una coppia in base
         * alla chiave passata come parametro
         *
         * @param valore Il numero della chiave di cui vogliamo visualizzare il valore
         */
        public void stampaCoppia(int valore) {
            Map.Entry<Integer, Character> entry = datiSensore.ceilingEntry(valore);
            if (entry != null && entry.getKey() == valore)
                System.out.println(valore + " - " + entry.getValue());
        }

        /**
         * Visualizza tutte le coppie la cui
         * chiave è numericamente inferiore alla prima coppia generata
         *
         * @param valore Indica il valore da confrontare
         */
        public void stampaCoppieMinori(int valore) {
            for (Map.Entry<Integer, Character> entry : datiSensore.entrySet()) {
                if (entry.getKey() <= valore) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }
        }

        /**
         * Visualizza tutte le coppie la cui
         * chiave è numericamente superiore alla prima coppia generata
         *
         * @param valore Indica il valore da confrontare
         */
        public void stampaCoppieMaggiori(int valore) {
            for (Map.Entry<Integer, Character> entry : datiSensore.entrySet()) {
                if (entry.getKey() > valore) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }
        }

        /**
         * Stampa i valori maggiori e minori
         * del TreeMap
         */
        public void stampaMinMax() {
            System.out.println("Minimo: " + datiSensore.firstEntry().getKey() + " - " + datiSensore.firstEntry().getValue());
            System.out.println("Massimo:" + datiSensore.lastEntry().getKey() + " - " + datiSensore.lastEntry().getValue());
        }
    }
}
