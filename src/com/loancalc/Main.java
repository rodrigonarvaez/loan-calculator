package com.loancalc;

import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Loan Amortization Calculator ===\n");

        try {
            System.out.print("Loan amount ($): ");
            double principal = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Annual Rate (%): ");
            double annualRate = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Loan term (months): ");
            int termMonths = Integer.parseInt(scanner.nextLine().trim());

            Loan loan = new Loan(principal, annualRate, termMonths);

            System.out.printf("%nMonthly payment: $%.2f%n%n", loan.calculateMonthlyPayment());
            printSchedule(loan.generateSchedule());

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: please enter numeric values only.");
        } catch (InvalidLoanException e) {
            System.out.println("Invalid loan: " + e.getMessage());
        }

        scanner.close();
    }

    private static void printSchedule(List<AmortizationRow> schedule) {
        System.out.printf("%-8s %-12s %-12s %-12s %-12s%n",
                "Month", "Payment", "Principal", "Interest", "Balance");
        System.out.println("-".repeat(58));

        for (AmortizationRow row : schedule) {
            System.out.printf("%-8d $%-11.2f $%-11.2f $%-11.2f $%-11.2f%n",
                    row.month(), row.payment(), row.principal(), row.interest(), row.balance());
        }
    }
}
