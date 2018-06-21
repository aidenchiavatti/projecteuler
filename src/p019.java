import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class p019 {

    public static void main(String[] args) {
        List<Date> dates = new ArrayList<>();

        Day day = Day.TUESDAY; //Jan 1, 1901
        //for each year
        for(int year = 1901; year <= 2000; year++) {
            //for each month
            for(Month month: Month.values()) {
                //for each day
                for(int value = 1; value <= month.days(year); value++) {
                    //create and store day
                    Date date = new Date();
                    date.value = value;
                    date.month = month;
                    date.year = year;
                    date.day = day;
                    dates.add(date);
                    day = day.next();
                }
            }
        }
        //filter days on Sunday and first day of month
        List<Date> filteredDays = dates.stream().filter(d -> d.value == 1).filter(d -> d.day == Day.SUNDAY).collect(Collectors.toList());

        filteredDays.forEach(System.out::println);
        System.out.println(filteredDays.size());
    }

    static class Date {
        Month month;
        int value;
        int year;
        Day day;

        @Override
        public String toString() {
            return String.format("%s %d, %d: %s", month, value, year, day);
        }
    }

    enum Day {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;

        Day next() {
            return values()[(this.ordinal()+1) % values().length];
        }
    }

    enum Month {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER;

        int days(int year) {
            switch(this) {
                case SEPTEMBER:
                case APRIL:
                case JUNE:
                case NOVEMBER:
                    return 30;
                case FEBRUARY:
                    return year % 4 == 0 ? 29 : 28;
                default:
                    return 31;
            }
        }
    }

    @Test
    public void testNextDay() {
        assertEquals(Day.MONDAY, Day.SUNDAY.next());
        assertEquals(Day.SUNDAY, Day.SATURDAY.next());
    }

    @Test
    public void testDaysInMonth() {
        assertEquals(30, Month.SEPTEMBER.days(1900));
        assertEquals(31, Month.OCTOBER.days(1984));
        assertEquals(28, Month.FEBRUARY.days(1901));
        assertEquals(29, Month.FEBRUARY.days(1900));
    }
}
