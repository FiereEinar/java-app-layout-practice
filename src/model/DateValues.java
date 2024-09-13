package model;

import java.util.Calendar;

public class DateValues {
  public int year;
  public int month;
  public int day;

  public int hour;
  public int minute;

  public DateValues(Calendar calendar) {

    this.year = calendar.get(Calendar.YEAR);
    this.month = calendar.get(Calendar.MONTH);
    this.day = calendar.get(Calendar.DAY_OF_MONTH);
    this.hour = calendar.get(Calendar.HOUR);
    this.minute = calendar.get(Calendar.MINUTE);

  }
  
}
