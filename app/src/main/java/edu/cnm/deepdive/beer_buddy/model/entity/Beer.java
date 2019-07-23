/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * Beer Class holds setters and getters for fetching the columns and rows of the Bar Database.
 */
@Entity(
        indices = {
                @Index(value = "name", unique = true)
        }
)
/**
 * Beer Class holds setters and getters for fetching the columns and rows of the Bar Database.
 */
public class Beer implements Serializable {

    private static final long serialVersionUID = 1l;
    /**
     * In depth column and row information for Bar Class.
     */
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "beer_id", index = true)
    private Long beerId;
    private String name;
    @ColumnInfo(name = "brewery_house", index = true)
    private String breweryHouse;
    @ColumnInfo(name = "beer_Abv", index = true)
    private int beerAbv;
    private String description;
    private String style;

    /**
     * @return Returns the Id of this instance.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id sets the Id of this instance.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return returns the beerId of this instance.
     */
    public Long getBeerId() {
        return beerId;
    }

    /**
     * @param beerId sets the beerId of this instance.
     */
    public void setBeerId(Long beerId) {
        this.beerId = beerId;
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
     * @return returns the breweryHouse of this instance.
     */
    public String getBreweryHouse() {
        return breweryHouse;
    }

    /**
     * @param breweryHouse sets the breweryHouse of this instance.
     */
    public void setBreweryHouse(String breweryHouse) {
        this.breweryHouse = breweryHouse;
    }

    /**
     * @return returns the beerAbv of this instance.
     */
    public int getBeerAbv() {
        return beerAbv;
    }

    /**
     * @param beerAbv sets the beerABv of this instance.
     */
    public void setBeerAbv(int beerAbv) {
        this.beerAbv = beerAbv;
    }

    /**
     * @return Returns the description of this instance.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description sets the description of this instance.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return returns the style of this instance.
     */
    public String getStyle() {
        return style;
    }

    /**
     * @param style sets the style of this instance.
     */
    public void setStyle(String style) {
        this.style = style;
    }


    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
