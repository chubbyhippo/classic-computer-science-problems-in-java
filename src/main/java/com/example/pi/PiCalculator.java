package com.example.pi;

// Leibniz formula, π = 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11...
public class PiCalculator {
    private PiCalculator() {
        throw new IllegalStateException("Utility class");
    }

    public static double calculatePi(int nTerms) {
        final double numerator = 4.0;
        double denominator = 1.0;
        double operation = 1.0;
        double pi = 0.0;
        for (int i = 0; i < nTerms; i++) {
            pi += operation * (numerator / denominator);
            denominator += 2.0;
            operation *= -1.0;
        }
        return pi;
    }
}
