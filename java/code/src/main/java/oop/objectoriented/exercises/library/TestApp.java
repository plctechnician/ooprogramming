package oop.objectoriented.exercises.library;

import oop.utils.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Una biblioteca ha la necessità di tenere traccia dei prestiti di libri e dvd (classi Book e Dvd).
 * Un prestito (classe Rent) rappresenta un legame fra uno studente ed un oggetto (classe Item, generalizzazione
 * astratta di Book e Dvd), dotato di una data di inizio e una data di fine (utilizzare le classi java.util.Date e java.text.SimpleDateFormat).
 * La classe Library rappresenta un insieme di prestiti ed implementa il metodo getLongestRent() che ritorna il
 * prestito durato più a lungo.
 *
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) throws ParseException {
        Item i1 = new Book("Soffocare", 2002, 170);
        Item i2 = new Dvd("Moon", 2011, 130);

        Student s1 = new Student("0001", "Darrell", "Abbott");
        Student s2 = new Student("0002", "Nick", "Drake");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Rent[] rents = new Rent[5];
        rents[0] = new Rent(i1, s1, sdf.parse("15/06/2020"), sdf.parse("15/07/2020"));
        rents[1] = new Rent(i1, s2, sdf.parse("10/07/2020"), sdf.parse("20/07/2020"));
        rents[2] = new Rent(i1, s1, sdf.parse("25/08/2020"), sdf.parse("14/11/2020"));
        rents[3] = new Rent(i2, s2, sdf.parse("10/07/2020"), sdf.parse("20/07/2020"));
        rents[4] = new Rent(i2, s1, sdf.parse("25/08/2020"), sdf.parse("28/08/2020"));

        Library l = new Library(rents);
        System.out.println(l.getLongestRent());
    }
}
