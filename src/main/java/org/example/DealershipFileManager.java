package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DealershipFileManager {
    private static final String FILE_PATH = "src/main/resources/dealership.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Dealership getDealership() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("File not found. Using default dealership info.");
            return new Dealership("Hop Motors", "123 Wherever St.", "555-1234");
        }

        try {
            return objectMapper.readValue(file, Dealership.class);
        } catch (IOException e) {
            System.out.println("ERROR: Could not read dealership.json. " + e.getMessage());
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), dealership);
        } catch (IOException ex) {
            System.out.println("Had a problem writing to dealership.json: " + ex.getMessage());
        }
    }
}
