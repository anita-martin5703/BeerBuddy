/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Bar Class holds setters and getters for fetching the columns and rows of the Bar Database.
 */
@Entity
public class Bar {
    /**
     * In depth column and row information for Bar Class.
     */
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "bar_id", index = true)
    private long barId;
    @NonNull
    private String name;
    private String type;
    private String location;
    @ColumnInfo(name = "projected_date", index = true)
    private String projectedDate;

    public Bar(String name, String type, String location, String projectedDate) {
    }

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
     * Returns the type of this instance.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of this instance.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the location of this instance.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of this instance.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the projected date of this instance.
     */
    public String getProjectedDate() {
        return projectedDate;
    }

    /**
     * Sets the projected date of this instance.
     */
    public void setProjectedDate(String projectedDate) {
        this.projectedDate = projectedDate;
    }


    @NonNull
    public String toString() {
        return name;
    }

}