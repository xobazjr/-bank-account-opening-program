package main;

import java.time.LocalDate;

public class DateUtils {

    public static String[] getDayOptions() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }
        return days;
    }

    public static String[] getMonthOptions() {
        return new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    }

    public static String[] getYearOptions() {
        String[] years = new String[100];
        int currentYear = LocalDate.now().getYear();
        for (int i = 0; i < 100; i++) {
            years[i] = String.valueOf(currentYear - i);
        }
        return years;
    }
}

