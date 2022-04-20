package oop.rest.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.port;

public class JSONServer {
    ObjectMapper mapper;

    public void run() {
        mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.findAndRegisterModules();

        Map<String, String> map = new HashMap<>(Map.of(
                "rome", "Europe/Rome",
                "delhi", "India/Delhi",
                "new_york", "America/New_York"
        ));

        // Start embedded server at this port
        port(8080);

        // Configure resources
        get("/timezone", (request, response) -> {
            List<LocalTime> localTimes = new ArrayList<>();
            for (String tz : map.values()) {
                localTimes.add(getTimeZone(tz));
            }
            return mapper.writeValueAsString(localTimes);
        });

        get("/timezone/:id", (request, response) -> {
            String id = request.params(":id");
            return mapper.writeValueAsString(getTimeZone(map.get(id)));
        });

    }

    LocalTime getTimeZone(String name) {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone(name));
        return new LocalTime(name, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
    }

    public static void main(String[] args) {
        new JSONServer().run();
    }
}