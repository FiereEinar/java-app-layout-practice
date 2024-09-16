package model;

import java.util.Calendar;

public class DateValues {
  public Calendar origin;

  public int year;
  public int month;
  public int day;

  public int hour;
  public int minute;

  public DateValues(Calendar calendar) {
    setValues(calendar);
  }

  public DateValues(int year, int month, int day, int hour, int minutes) {
    Calendar date = Calendar.getInstance();
    date.set(Calendar.YEAR, year);
    date.set(Calendar.MONTH, month);
    date.set(Calendar.DAY_OF_MONTH, day);
    date.set(Calendar.HOUR, hour);
    date.set(Calendar.MINUTE, minutes);
    
    origin = date;
    setValues(date);
  }
  
  private void setValues(Calendar calendar) {
    this.year = calendar.get(Calendar.YEAR);
    this.month = calendar.get(Calendar.MONTH);
    this.day = calendar.get(Calendar.DAY_OF_MONTH);
    this.hour = calendar.get(Calendar.HOUR);
    this.minute = calendar.get(Calendar.MINUTE);
  }
  
}
