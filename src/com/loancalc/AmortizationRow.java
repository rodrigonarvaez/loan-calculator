package com.loancalc;

public record AmortizationRow(
    int month,
    double payment,
    double principal,
    double interest,
    double balance
) {}