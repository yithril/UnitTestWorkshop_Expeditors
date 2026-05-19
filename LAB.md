# Workshop 5: Vehicle Dealership Lab

**When:** afternoon session (after this morning’s unit-testing lesson)  
**How long:** about **2–3 hours** in one sitting  
**What you are doing:** writing **unit tests** for a small car dealership program.

---

## Before you start — use your workbook

Assignment checklists, business rules, BigDecimal examples, boundary tests, and how to read the coverage report are in your **Unit Testing Workbook — Workshop 5** (not in this file).

This document only gets you **set up** and shows how to **run tests and JaCoCo**.

---

## What is this project?

Employees use this program to search inventory, add or remove cars, and create sales or lease contracts. The menus already work. Your job is to write **tests** that check whether searches and contract math match the **rules in the workbook**.

If a test **passes**, the code matched what you expected. If it **fails**, your test might be wrong — or you may have found a **bug**. Your instructor may ask you to list bugs you find. You do not have to fix them unless told to (extra credit).

---

## Part 1 — Get the project running (~15 minutes)

### Step 1: Open the project in IntelliJ

1. Open IntelliJ.
2. **File → Open** and choose this project folder (the folder that contains `pom.xml`).
3. Wait for indexing and Maven import to finish (first open may download libraries).

**Set Java 17:** **File → Project Structure → Project** → **SDK: 17** and **Language level: 17**.  
Also: **Settings → Build Tools → Maven → Runner → JRE: 17**.  
The project is built for Java 17; using JDK 24 can cause JaCoCo warnings.

### Step 2: Run the program once

1. Open `src/main/java/org/example/Main.java`
2. Click the green **Run** triangle next to `main`.
3. Try menu option **1** (view all vehicles) to confirm inventory loaded.

**Missing file error?** Open the **whole project folder**, not a single file. The app reads `src/main/resources/dealership.json`.

### Step 3: Run the example test

1. Open `src/test/java/org/example/DealershipTest.java`
2. Run the class or `testAddVehicle` — you should see **1 test passed**.

That test shows the pattern you will copy (see workbook): `@BeforeEach` setup, Arrange → Act → Assert.

Add more tests in `DealershipTest.java` and `ContractTest.java` per the workbook.

---

## Part 2 — Run tests and JaCoCo coverage

### Run all tests

- Right-click `src/test/java` → **Run 'Tests in …'**, or  
- Maven tool window → **Lifecycle** → **test**

All tests should pass before you submit.

### JaCoCo HTML report (for your screenshot)

1. Maven tool window (**View → Tool Windows → Maven**)
2. Expand your project → **Lifecycle**
3. Double-click **verify** (runs tests, then builds the report)
4. Open in a browser:

   `target/site/jacoco/index.html`

5. Click **org.example** → open **Dealership**, **SalesContract**, or **LeaseContract**

**Turn-in target:** about **60% or higher** instruction coverage on those three classes only. Ignore `UserInterface` and `Main`. Details are in the workbook.

**Command line (optional):**

```bash
mvn verify
```

### Quick feedback while coding (optional)

Right-click `src/test/java` → **Run 'Tests in …' with Coverage** for green/red highlights in the editor. You may use this or JaCoCo for your screenshot; JaCoCo from **verify** is preferred.

### JaCoCo troubleshooting

| Problem | What to do |
|---------|------------|
| Long error mentioning **major version 68** | Project is running on JDK 24 — switch to **JDK 17** (see Step 1) and run **verify** again |
| Build says **SUCCESS** but log looks scary | Report may still be at `target/site/jacoco/index.html` — open it |
| No `site/jacoco` folder | Run **verify**, not only **test** |

---

## Part 3 — Afternoon schedule

| Time | Focus |
|------|--------|
| First ~15 min | This setup + skim workbook assignments |
| Next ~75 min | `Dealership` tests (workbook Assignment A) |
| Next ~45 min | `SalesContract` and `LeaseContract` tests (workbook B & C) |
| Last ~15 min | Run **verify** → coverage screenshot → note any bugs |

If you are behind: finish most of Assignment A and at least one cash-sale and one financed-sale test before polishing every branch.

---

## Part 4 — Turn-in

Submit what your instructor specifies (Canvas, GitHub, etc.):

1. **Test files** in `src/test/java/org/example/` (`DealershipTest.java`, `ContractTest.java`)
2. **Screenshot** of coverage for `Dealership`, `SalesContract`, and `LeaseContract` (JaCoCo HTML or IntelliJ Coverage)
3. **Bug list** (if any) — use the bug-report format in the workbook

---

## Need help?

1. Compare your test to `testAddVehicle` in `DealershipTest.java`
2. Re-read the **rule** for that method in the **workbook**
3. Ask: “Am I testing the workbook rule, or only copying what the code returns?”
4. Ask your instructor — that is what lab time is for
