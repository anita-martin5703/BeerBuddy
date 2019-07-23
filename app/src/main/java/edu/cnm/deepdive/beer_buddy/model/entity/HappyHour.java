/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
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
/**
 * Happy Hour Class holds setters and getters for fetching the columns and rows of the Bar Database.
 */
public class HappyHour {

    /**
     * In depth column and row information for Bar Class.
     */
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "bar_id", index = true)
    private long barId;
    private String name;
    private String hours;
    private String weekdays;

    /**
     * @return returns the Id of this instance.
     */
    public long getId() {
        return id;
    }

    /**
     * @param id sets the Id of this instance.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return returns the barId of this instance.
     */
    public long getBarId() {
        return barId;
    }

    /**
     * @param barId sets the barId of this instance.
     */
    public void setBarId(long barId) {
        this.barId = barId;
    }

    /**
     * @return returns the name of this instance.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name sets the name of this instance.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return returns the hours of this instance.
     */
    public String getHours() {
        return hours;
    }

    /**
     * @param hours sets the hours of this instance.
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /**
     * @return returns the weekdays of this instance.
     */
    public String getWeekdays() {
        return weekdays;
    }

    /**
     * @param weekdays sets the weekdays of this instance.
     */
    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }
}