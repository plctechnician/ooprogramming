package oop.rest.basic;

import static spark.Spark.get;
import static spark.Spark.port;

public class BasicServer {

    public void run() {
        // Start embedded server at this port
        port(8080);

        // Configure resources
        get("/italian", (request, response) -> "Ciao Mondo!");
        get("/english", (request, response) -> "Hello World!");
        get("/german", (request, response) -> "Hallo Welt!");
    }

    public static void main(String[] args) {
        new BasicServer().run();
    }
}