# Vehicle Dealership — Workshop Starter

Internal employee application for managing used vehicle inventory and creating sales/lease contracts. Data is persisted with **Jackson** and JSON files under `src/main/resources/`.

## Run the application

1. Open in IntelliJ (Java 17).
2. Run `org.example.Main`.
3. Ensure the working directory is the **project root** so `src/main/resources/dealership.json` resolves correctly.

**Menu highlights:**

- Options 1–9 — search and manage inventory
- Option 10 — create a sales contract (cash or financed)
- Option 11 — create a lease contract
- Option 0 — save and exit

Completing a contract removes the vehicle from inventory and appends the contract to `contracts.json`.

## Workshop lab

- **[LAB.md](LAB.md)** — afternoon setup: run the app, run tests, JaCoCo, turn-in checklist
- **Unit Testing Workbook — Workshop 5** — assignments, business rules, coverage concepts (provided in class)

```bash
mvn test          # run unit tests
mvn verify        # tests + JaCoCo coverage report
```

Coverage report: `target/site/jacoco/index.html` (see LAB.md for steps)

## Project structure

| Package / file | Role |
|----------------|------|
| `Dealership` | Inventory and search filters |
| `SalesContract` / `LeaseContract` | Contract pricing (`BigDecimal`) |
| `DealershipFileManager` | Load/save `dealership.json` |
| `ContractFileManager` | Append to `contracts.json` |
| `UserInterface` | Console menus (not unit tested in lab) |

## Data files

- `src/main/resources/dealership.json` — dealership info + vehicle inventory
- `src/main/resources/contracts.json` — completed contracts (array)
