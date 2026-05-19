package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {
    private static final String FILE_PATH = "src/main/resources/contracts.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void appendContract(Contract contract) {
        List<Contract> contracts = loadContracts();
        contracts.add(contract);
        saveContracts(contracts);
    }

    public List<Contract> loadContracts() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(
                    file,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Contract.class)
            );
        } catch (IOException e) {
            System.out.println("ERROR: Could not read contracts.json. " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void saveContracts(List<Contract> contracts) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), contracts);
        } catch (IOException ex) {
            System.out.println("Had a problem writing to contracts.json: " + ex.getMessage());
        }
    }
}
