package org.nbicocchi.objectoriented;

/**
 * Scrivere una classe Table per rappresentare tavole pitagoriche. In
 * particolare. Metodi:
 * Table()      costruttore senza parametri che configura una tavola 10x10
 * Table(a, b)  costruttore che configura una tavola axb
 * toString()   ritorna una stringa che rappresenta la tavola
 * double sum() ritorna la somma di tutti i numeri presenti nella tavola
 * double avg() ritorna la media di tutti i numeri presenti nella tavola
 *
 * @author Nicola Bicocchi
 */
public class Table {
    int a, b;
    boolean ready = false;
    double sum;
    String table;

    public Table() {
        super();
        this.a = 10;
        this.b = 10;
    }

    public Table(int a, int b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        if (!ready)
            compute();
        return table;
    }

    public double sum() {
        if (!ready)
            compute();
        return sum;
    }

    public double avg() {
        if (!ready)
            compute();
        return sum / (a * b);
    }

    private void compute() {
        sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                sb.append(i * j).append("\t");
                sum += i * j;
            }
            sb.append("\n");
        }
        table = sb.toString();
        ready = true;
    }

    public static void main(String[] args) {
        Table t = new Table(8, 8);
        System.out.println(t);
        System.out.println(t.sum());
        System.out.println(t.avg());
    }
}