package oop.io.exercises.trains;

import oop.utils.Utils;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Si supponga di voler progettare parte del sistema informativo di una azienda
 * di trasporti su rotaia. E' necessario salvare oggetti di classe Train (vedi codice)
 * in 3 modalità differenti:
 * 1. file di testo
 * 2. file binario (nella forma di strutture dati)
 * 3. file binario (nella forma di oggetti serializzati)
 *
 * @author Nicola Bicocchi
 */
public class TestApp {

    public static void testWriteRead(Storage storage, List<Train> trains) throws IOException, ClassNotFoundException {
        System.out.println(storage.getClass());
        storage.store(trains);
        System.out.println(storage.load());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Storage storage;
        List<Train> trains = new ArrayList<>();

        trains.add(new Train("06:00:00", "20:15:00", 25, 700));
        trains.add(new Train("11:00:00", "14:30:00", 20, 600));
        trains.add(new Train("17:00:00", "22:45:00", 15, 400));

        storage = new StorageText(Paths.get(Utils.ooprogrammingdir(), "StorageText.dat").toAbsolutePath().toString());
        testWriteRead(storage, trains);

        storage = new StorageBinaryObject(Paths.get(Utils.ooprogrammingdir(), "StorageBinaryObject.dat").toAbsolutePath().toString());
        testWriteRead(storage, trains);

        storage = new StorageBinaryFields(Paths.get(Utils.ooprogrammingdir(), "StorageBinaryFields.dat").toAbsolutePath().toString());
        testWriteRead(storage, trains);
    }
}
