package oop.rest.basic;

import static spark.Spark.get;
import static spark.Spark.port;

public class BasicServer {

    public void run() {
        // Start embedded server at this port
        port(8080);

        // Configure resources
        get("/", (request, response) -> "Hello World!");
    }

    public static void main(String[] args) {
        new BasicServer().run();
    }
}