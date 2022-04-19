package oop.swing.planemanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaneStorage {

    public static List<Plane> load(Path path) throws IOException {
        List<Plane> planes = new ArrayList<>();
        Scanner scanner = new Scanner(path);
        while (scanner.hasNextLine()) {
            String[] fields = scanner.nextLine().split(";");
            planes.add(new Plane(fields[0], Double.parseDouble(fields[1]),
                    Double.parseDouble(fields[2]), LocalDate.parse(fields[3]),
                    fields[4]));
        }
        scanner.close();
        return planes;
    }

    public static void save(List<Plane> planes, Path path) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Plane plane : planes) {
            lines.add(plane.toCSV());
        }
        Files.write(path, lines);
    }
}
