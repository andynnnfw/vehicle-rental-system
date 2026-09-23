# 🚗 Vehicle Rental System

A command-line vehicle rental management system built in Java, applying core Object-Oriented Programming principles, custom exceptions, and collections.

## 📋 About

This project simulates a simple vehicle rental agency where users can register cars and motorcycles, rent and return them, and manage the available stock — all through an interactive terminal menu.

It was built as a portfolio project to consolidate fundamental Java concepts learned through daily practice: encapsulation, inheritance, polymorphism, interfaces, custom exceptions, and collections (`List`/`Map`).

## ✨ Features

- Register new vehicles (Car or Motorcycle) with input validation
- List all registered vehicles and their status (available/rented)
- Rent a vehicle by license plate
- Return a rented vehicle by license plate
- Remove a vehicle from the stock
- Graceful error handling — invalid input never crashes the program

## 🧠 Concepts Applied

- **Encapsulation** — private fields with validated getters/setters
- **Inheritance** — `Carro` and `Moto` extend an abstract `Veiculo` class
- **Polymorphism** — shared behavior handled through the `Alugavel` interface
- **Interfaces** — `Alugavel` defines a rentable contract, decoupled from the class hierarchy
- **Custom Exceptions** — `AnoInvalidoException`, `ModeloInvalidoException`, `ItemNaoEncontradoException` (all extending `RuntimeException`)
- **Collections** — `HashMap<String, Alugavel>` for O(1) lookup by license plate
- **Exception Handling** — `try/catch` blocks preventing crashes from invalid user input

## 🗂️ Project Structure

```
src/
└── vehiclerental/
    ├── Main.java                 # Entry point — interactive CLI menu
    │
    ├── model/
    │   ├── Veiculo.java          # Abstract base class
    │   ├── Carro.java            # Car (extends Veiculo, implements Alugavel)
    │   ├── Moto.java             # Motorcycle (extends Veiculo, implements Alugavel)
    │   └── Alugavel.java         # Interface: alugar(), devolver(), isAlugado()
    │
    ├── exception/
    │   ├── AnoInvalidoException.java
    │   ├── ModeloInvalidoException.java
    │   └── ItemNaoEncontradoException.java
    │
    └── service/
        └── Estoque.java          # Manages the vehicle stock (HashMap-based)
```

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/andynnnfw/vehicle-rental-system.git
   ```
2. Compile and run with Java (JDK 17+ recommended):
   ```bash
   javac -d out src/vehiclerental/**/*.java src/vehiclerental/*.java
   java -cp out vehiclerental.Main
   ```
   *(or simply open the project in IntelliJ IDEA and run `Main.java`)*

## 📖 Example

```
=== Locadora de Veículos ===
1. Cadastrar veículo
2. Listar veículos
3. Alugar veículo
4. Devolver veículo
5. Remover veículo
6. Sair
Escolha uma opção:
```

## 🔮 Possible Future Improvements

- Persist data to a file or database (currently in-memory only)
- Add unit tests (JUnit)
- Support editing an existing vehicle's data
- Add rental duration and pricing logic

## 👤 Author

**Anderson Melo do Nascimento**
GitHub: [@andynnnfw](https://github.com/andynnnfw)
