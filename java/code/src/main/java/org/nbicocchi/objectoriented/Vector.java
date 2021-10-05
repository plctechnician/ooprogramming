package org.nbicocchi.objectoriented;

import java.util.Random;

/**
 *
 * Implementare una classe Vector che rappresenta un vettore di interi dotato di funzioalità (metodi) aggiuntive.
 * In particolare:
 * void init() inizializza il vettore con numeri interi randomici compresi fra 0 e 100.
 * void sort() ordina il vettore in modo crescente utilizzando l'algoritmo Bubble Sort.
 * void show() mostra il contenuto del vettore a video.
 * int search(int value) ritorna l'indice di value all'interno del vettore, -1 in caso non sia presente.
 *
 * @author Nicola Bicocchi
 */
public class Vector {
    int[] v;

    public Vector(int capacity) {
        this.v = new int[capacity];
        init();
    }

    void init() {
        Random rnd = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = rnd.nextInt(100);
        }
    }

    void sort() {
        boolean changed;
        for (int i = 0; i < v.length-1; i++) {
            changed = false;
            for (int j = 0; j < v.length - i - 1; j++) {
                if (v[j] > v[j + 1]) {
                    changed = true;
                    int tmp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = tmp;
                }
            }
            if (!changed) break;
        }
    }

    int search(int value) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == value) {
                return i;
            }
        }
        return -1;
    }

    void show() {
        for (int i = 0; i < v.length; i++) {
            System.out.printf("[%d] %d\n", i, v[i]);
        }
    }

    public static void main(String[] args) {
        Vector v = new Vector(20);
        v.sort();
        v.show();
        System.out.printf("%d index = %d\n", 10, v.search(10));
    }
}
