package edu.cnm.deepdive.beer_buddy.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bar {

  @PrimaryKey(autoGenerate = true)
  private long id;
  @ColumnInfo(name = "bar_id", index = true)
  private long barId;
  private String name;
  private String type;
  private String location;
  @ColumnInfo(name = "projected_date", index = true)
  private String projectedDate;


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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getProjectedDate() {
    return projectedDate;
  }

  public void setProjectedDate(String projectedDate) {
    this.projectedDate = projectedDate;
  }


  @NonNull
  public String toString() {
    return name;
  }

}