package oop.io.exercises.trains;

import java.io.IOException;
import java.util.List;

public interface Storage {
    void store(List<Train> trains) throws IOException;
    List<Train> load() throws IOException, ClassNotFoundException;
}
