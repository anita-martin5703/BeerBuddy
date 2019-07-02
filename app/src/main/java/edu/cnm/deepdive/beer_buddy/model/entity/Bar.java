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
  private String status;
  private String street;
  private String state;
  private String zip;
  private int number;
  @ColumnInfo(name = "projected_date", index = true)
  private String projectedDate;



  public long getBarId() {
    return barId;
  }

  public void setBarId(long barId) {
    this.barId = barId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
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