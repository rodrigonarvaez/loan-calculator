package com.loancalc;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    private final double principal;
    private final double annualRate;
    private final int termMonths;

    public Loan(double principal, double annualRate, int termMonths) {
        validate(principal, annualRate, termMonths);
        this.principal = principal;
        this.annualRate = annualRate;
        this.termMonths = termMonths;
    }

    private void validate(double principal, double annualRate, int termMonths) {
        if (principal <= 0) {
            throw new InvalidLoanException("Principal must be greater than zero.");
        }
        if (annualRate <= 0 || annualRate >= 100) {
            throw new InvalidLoanException("Annual rate must be between 0 and 100.");
        }
        if (termMonths <= 0) {
            throw new InvalidLoanException("Term must be at least 1 month.");
        }
    }

    private double calculateMonthlyRate() {
        return annualRate / 100 / 12;
    }

    public double calculateMonthlyPayment() {
        double monthlyRate = calculateMonthlyRate();
        return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termMonths));
    }

    public List<AmortizationRow> generateSchedule() {
        List<AmortizationRow> schedule = new ArrayList<>();
        double balance = principal;
        double monthlyPayment = calculateMonthlyPayment();
        double monthlyRate = calculateMonthlyRate();

        for(int month = 1; month <= termMonths; month++) {
            double interest = balance * monthlyRate;
            double principal = monthlyPayment - interest;

            balance -= principal;
            if(month == termMonths) {
                balance = 0.0;
            }

            schedule.add(new AmortizationRow(month, monthlyPayment, principal, interest, balance));
        }

        return schedule;
    }
}
