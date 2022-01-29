package oop.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Class for listing the content of a directory
 *
 * @author Nicola Bicocchi
 */
public class DirectoryListing {
    public static void main(String[] args) throws IOException {
        File path = new File(System.getProperty("user.home"));
        if (!path.isDirectory()) {
            throw new IOException();
        }

        /* without filtering */
        // File[] files = path.listFiles();

        /* with filtering */
		List<File> files = Arrays.asList(
                Objects.requireNonNull(path.listFiles((dir, file) -> file.endsWith("s"))));

        /* show files */
        System.out.println(files);
    }

}