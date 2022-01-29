package oop.objectoriented.exercises;

import java.util.Arrays;

/**
 * Implementare una classe StringProcessor per effettuare operazioni su array di
 * stringhe. Metodi:
 *
 * public StringProcessor(String[] v): Costruttore
 * public int findShortest(): ritorna l'indice della stringa più corta
 * public int search(String key): ritorna l'indice dell'elemento key. -1 se non trovato.
 * public void reverse(): capovolge l'ordine delle stringhe
 * public boolean equals(Object obj)
 *
 * @author Nicola Bicocchi
 */
public class StringProcessor {
    String[] v;

    public StringProcessor(String[] v) {
        super();
        this.v = v;
    }

    public int findShortest() {
        if (v.length == 0) {
            return -1;
        }

        int shortestIndex = 0;
        int shortestLength = v[0].length();
        for (int i = 0; i < v.length; i++) {
            if (v[i].length() < shortestLength) {
                shortestIndex = i;
                shortestLength = v[i].length();
            }
        }
        return shortestIndex;
    }

    public int search(String key) {
        for (int i = 0; i < v.length; i++) {
            if (v[i].equals(key))
                return i;
        }
        return -1;
    }

    public void reverse() {
        for (int i = 0; i < v.length / 2; i++) {
            String tmp = v[i];
            v[i] = v[v.length - 1 - i];
            v[v.length - 1 - i] = tmp;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringProcessor)) return false;
        StringProcessor that = (StringProcessor) o;
        return Arrays.equals(v, that.v);
    }

    public static void main(String[] args) {
        String[] v1 = {"Nicola", "Marzia", "Agata", "Dharma"};
        String[] v2 = {"Nicola", "Marzia", "Agata", "Dharma"};
        StringProcessor sp1 = new StringProcessor(v1);
        StringProcessor sp2 = new StringProcessor(v2);

        System.out.println("shortest=" + sp1.findShortest());
        System.out.println("search=" + sp1.search("Marzia"));
        sp1.reverse();
        // False because sp1 has been reversed
        System.out.println("equals=" + sp1.equals(sp2));
    }
}
