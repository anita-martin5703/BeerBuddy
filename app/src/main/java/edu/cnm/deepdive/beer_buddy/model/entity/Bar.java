/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("brewery_id")
    @ColumnInfo(name = "bar_id", index = true)
    private long barId;
    @NonNull
    @SerializedName("brewery_name")
    private String name;
    private String type;
    transient private String location; // FIXME Temporarily ignored for deserialization.
    @ColumnInfo(name = "projected_date", index = true)
    private String projectedDate;

    /**
     * @return Returns the Id of this instance.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the Id of this instance.
     *
     * @param id creates an id of Bars
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return Returns the barId of this instance.
     */
    public long getBarId() {
        return barId;
    }

    /**
     * Sets the barId of this instance.
     *
     * @param barId sets up the bar Id for retrieving bars
     */
    public void setBarId(long barId) {
        this.barId = barId;
    }

    /**
     * @return Returns the name of this instance.
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
     * @return Returns the type of this instance.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type sets the type of this instance.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Returns the location of this instance.
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location sets the location of this instance.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return Returns the projected date of this instance.
     */
    public String getProjectedDate() {
        return projectedDate;
    }

    /**
     * @param projectedDate sets the projected date of this instance.
     */
    public void setProjectedDate(String projectedDate) {
        this.projectedDate = projectedDate;
    }


    @NonNull
    public String toString() {
        return name;
    }

}