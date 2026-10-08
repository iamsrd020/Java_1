package java8.assignments;

import java.time.LocalDate;
import java.time.Period;

public class Assignment12PeriodBetweenDates {
    public static void main(String[] args) {
        LocalDate firstDate = LocalDate.of(2024, 1, 10);
        LocalDate secondDate = LocalDate.of(2025, 4, 25);
        Period difference = Period.between(firstDate, secondDate);

        System.out.println("Difference: " + difference.getYears() + " years, "
                + difference.getMonths() + " months, and "
                + difference.getDays() + " days.");
    }
}
