package com.smoothstack.day.five;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Rob Maes
 * Sat Feb 27 2021
 */
public class DateTime {

  /**
   * Gets the last Thursday relative to the given date
   * @param date The date to get the previous Thursday from
   * @return The date of the previous Thursday
   */
  public static LocalDate getPreviousThursday(LocalDate date) {
    return date.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
  }

  /**
   * Prints out the length of each month in days of the given year
   * @param year The year to count the number of days in months from
   */
  public static void printLengthOfEachMonthInYear(int year) {
    // loop through each month
    for (int i = 1; i <= 12; i++) {
      // create a YearMonth object for the current year and month
      YearMonth yM = YearMonth.of(year, i);
      // print out the number of days in the current month
      int days = yM.lengthOfMonth();
      System.out.println(days);
    }
  }

  /**
   * Prints out all Monday dates in a specific month in the current year
   * @param m The month containing mondays
   */
  public static void printAllMondaysInMonth(Month m) {
    // get the current year
    int currentYear = LocalDate.now().getYear();
    // construct a LocalDate with the current year, given month on the first day
    LocalDate firstOfMonth = LocalDate.of(currentYear, m, 1);
    // if day 1 of the month is a monday, print out the date
    if (firstOfMonth.getDayOfWeek() == DayOfWeek.MONDAY) {
      System.out.println(firstOfMonth);
    }
    // keep looping as long as we are in the specified month
    while (firstOfMonth.getMonth() == m) {
      // set the date to the date of the next monday
      firstOfMonth =
        firstOfMonth.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
      // ensure we did not jump to the next month
      if (firstOfMonth.getMonth() == m) {
        // print out the date of the monday
        System.out.println(firstOfMonth);
      }
    }
  }

  /**
   * Determines whether a given date is a Friday and the 13th of the month
   * @param date The date to check
   * @return True if the date is Fri the 13th, false if not
   */
  public static boolean isFridayThirteenth(LocalDate date) {
    return (
      date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13
    );
  }

  public static void main(String[] args) {
    // 1) I would use the LocalDateTime class
    LocalDateTime myBirthday = LocalDateTime.of(
      1996,
      Month.OCTOBER,
      8,
      12,
      12,
      0,
      0
    );

    // 2) Given a random date, find the date of the previous thursday
    LocalDate randomDate = LocalDate.of(2021, Month.FEBRUARY, 27);
    System.out.println("\nPrevious Thursday");
    System.out.println("-------------------");
    // find the previous thursday relative to 02/27/2021
    System.out.println(getPreviousThursday(randomDate));

    // 3) ZoneId adjusts the time for a geographic region, ZoneOffset accounts for things like Daylight Savings Time
    LocalDateTime winter = LocalDateTime.of(2021, Month.JANUARY, 1, 1, 1, 1, 1);
    LocalDateTime summer = LocalDateTime.of(2021, Month.JUNE, 1, 1, 1, 1, 1);
    ZoneId central = ZoneId.of("America/Chicago");
    ZoneOffset winterOffset = central.getRules().getOffset(winter);
    ZoneOffset summerOffset = central.getRules().getOffset(summer);
    // summer offset is an hour behind vs winter due to DST
    System.out.println("\nZoneId vs ZoneOffset");
    System.out.println("----------------------");
    System.out.println("DateTime with U.S. Central Zone and Winter Offset");
    System.out.println(OffsetDateTime.now(winterOffset));
    System.out.println("DateTime with U.S. Central Zone and Summer Offset");
    System.out.println(OffsetDateTime.now(summerOffset));

    // 4)
    Instant now = Instant.now();
    // instant to ZDT
    ZonedDateTime zdt = ZonedDateTime.ofInstant(
      now,
      ZoneId.of("America/Chicago")
    );
    //ZDT to instant
    Instant now2 = zdt.toInstant();

    // 5)
    System.out.println("\nPrint length of each month in year");
    System.out.println("------------------------------------");
    // print the length in days of each month for 2021
    printLengthOfEachMonthInYear(2021);

    // 6)
    System.out.println("\nPrint all mondays in month");
    System.out.println("----------------------------");
    // print out each monday for Feb 2021
    printAllMondaysInMonth(Month.FEBRUARY);

    // 7)
    System.out.println("\nIs date Friday the 13th");
    System.out.println("-------------------------");
    LocalDate givenDate = LocalDate.of(2020, Month.NOVEMBER, 13);
    // print out whether 11/13/2020 was Friday the 13th
    System.out.println(
      isFridayThirteenth(givenDate)
        ? "Is Friday the 13th"
        : "Not Friday the 13th"
    );
  }
}
