# Loan Amortization Calculator

A command-line tool that calculates monthly loan payments and generates a full amortization schedule. Built in Java as a portfolio project to demonstrate core OOP principles, clean architecture, and modern Java features.

## Features

- Calculates monthly payment using the standard amortization formula
- Generates a full month-by-month amortization schedule
- Validates all user input with descriptive error messages
- Clean separation of concerns across focused, single-responsibility classes.

## Tech Stack

- **Java 25** (JDK Temurin)
- **IntelliJ IDEA**
- No external dependencies — pure Java standard library

## Getting Started

### Prerequisites

- JDK 17 or higher
- IntelliJ IDEA (recommended) or any Java IDE
### Run

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run `Main.java`
4. Enter loan details when prompted
### Example

```
=== Loan Amortization Calculator ===
 
Loan amount ($): 200000
Annual interest rate (%): 6.5
Loan term (months): 360
 
Monthly payment: $1,264.14
 
Month    Payment      Principal    Interest     Balance
----------------------------------------------------------
1        $1,264.14    $180.81      $1,083.33    $199,819.19
2        $1,264.14    $181.79      $1,082.35    $199,637.40
...
360      $1,264.14    $1,257.32    $6.82        $0.00
```

## Concepts Demonstrated

- **OOP** — encapsulation, single-responsibility, private validation logic
- **Java Records** — `AmortizationRow` as an immutable data carrier (Java 16+)
- **Collections** — `List<AmortizationRow>` built with a typed `ArrayList`
- **Exception Handling** — custom `InvalidLoanException` with two distinct catch paths
- **String Formatting** — `printf` with column-aligned tabular output

## Roadmap

This project is intended to grow into a full-stack loan management application. Planned extensions:

- [ ] **Spring Boot** — expose amortization logic as a REST API (`POST /loans/calculate`)
- [ ] **Hibernate + PostgreSQL** — persist loan scenarios and schedules to a database
- [ ] **Spring Data JPA** — repository pattern for loan storage and retrieval
- [ ] **Spring Security** — JWT-based auth to scope loan data per user
- [ ] **Docker** — containerize the Spring Boot app for cloud deployment
- [ ] **JUnit 5** — unit tests for `Loan` calculation and validation logic

## Author

**Rodrigo Narvaez** - Software Engineer  
[rodrigonarvaez.com](https://rodrigonarvaez.com) · [GitHub](https://github.com)