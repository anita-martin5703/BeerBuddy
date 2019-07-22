package edu.cnm.deepdive.beer_buddy.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Bar.class,
            parentColumns = "id",
            childColumns = "bar_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class HappyHour {

  @PrimaryKey(autoGenerate = true)
  private long id;
  @ColumnInfo(name = "bar_id", index = true)
  private long barId;
  private String name;
  private String hours;
  private String weekdays;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getBarId() {
    return barId;
  }

  public void setBarId(long barId) {
    this.barId = barId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHours() {
    return hours;
  }

  public void setHours(String hours) {
    this.hours = hours;
  }

  public String getWeekdays() {
    return weekdays;
  }

  public void setWeekdays(String weekdays) {
    this.weekdays = weekdays;
  }
}