package model;

import java.util.Calendar;

public class DateValues {
  public int month;
  public int day;

  public int hour;
  public int minute;
  public int second;

  public DateValues(Calendar calendar) {

    this.month = calendar.get(Calendar.MONTH);
    this.day = calendar.get(Calendar.DAY_OF_MONTH);
    this.hour = calendar.get(Calendar.HOUR);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);

  }
  
}
