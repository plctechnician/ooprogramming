package org.nbicocchi.io.exercises.trains;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StorageBinaryFields implements Storage {
    String filename;

    public StorageBinaryFields(String filename) {
        this.filename = filename;
    }

    @Override
    public void store(List<Train> tList) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
        for (Train t : tList) {
            out.write(t.starttime.getBytes(StandardCharsets.UTF_8));
            out.write(t.endtime.getBytes(StandardCharsets.UTF_8));
            out.writeInt(t.numberOfStops);
            out.writeDouble(t.totalDistance);
        }
        out.close();
    }

    @Override
    public List<Train> load() throws IOException {
        DataInputStream din = new DataInputStream(new FileInputStream(filename));
        ArrayList<Train> tList = new ArrayList<>();

        try {
            do {
                String starttime = new String(din.readNBytes(8), StandardCharsets.UTF_8);
                String endtime = new String(din.readNBytes(8), StandardCharsets.UTF_8);
                int numberOfStops = din.readInt();
                double totalDistance = din.readDouble();
                tList.add(new Train(starttime, endtime, numberOfStops, totalDistance));
            } while (true);
        } catch (EOFException e) {
            /* do nothing */
        }
        return tList;
    }
}
