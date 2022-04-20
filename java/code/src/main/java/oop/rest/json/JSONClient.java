package oop.rest.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JSONClient implements Runnable {
    static Logger logger = LoggerFactory.getLogger(JSONClient.class);
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void run() {
        String[] cities = {"rome", "delhi", "new_york"};
        for (String city : cities) {
            String url = String.format("http://localhost:8080/timezone/%s", city);
            String json = Unirest.get(url).asString().getBody();

            // JSON to object mapping
            LocalTime localTime = null;
            try {
                localTime = mapper.readValue(json, LocalTime.class);
            } catch (IOException ignored) {}

            // logging
            logger.info(json);
            logger.info(localTime != null ? localTime.toString() : null);
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new JSONClient(), 0, 5, TimeUnit.SECONDS);
    }
}