package org.nbicocchi.io.exercises.trains;

import java.io.*;
import java.util.List;

public class StorageBinaryObject implements Storage {
    String filename;

    public StorageBinaryObject(String filename) {
        this.filename = filename;
    }

    @Override
    public void store(List<Train> tList) throws IOException {
        // http://java.sun.com/javase/technologies/core/basic/serializationFAQ.jsp#appendSerialStream
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(tList);
        out.close();
    }

    @Override
    public List<Train> load() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        List<Train> tList = (List<Train>) in.readObject();
        in.close();
        return tList;
    }
}
