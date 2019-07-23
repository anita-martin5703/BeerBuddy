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
     * Returns the Id of this instance.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the Id of this instance.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the barId of this instance.
     */
    public long getBarId() {
        return barId;
    }

    /**
     * Sets the barId of this instance.
     */
    public void setBarId(long barId) {
        this.barId = barId;
    }

    /**
     * Returns the name of this instance.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this instance.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the hours of this instance.
     */
    public String getHours() {
        return hours;
    }

    /**
     * Sets the hours of this instance.
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /**
     * Returns the weekdays of this instance.
     */
    public String getWeekdays() {
        return weekdays;
    }

    /**
     * Sets the weekdays of this instance.
     */
    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }
}