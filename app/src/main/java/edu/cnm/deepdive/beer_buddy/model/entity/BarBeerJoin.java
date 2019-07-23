/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

/**
 * Sets up the BarBeerJoin table with @Entity, @ForeignKeys, and @Index.
 */
@Entity(primaryKeys = {"beer_id", "bar_id"},
        indices = {@Index("beer_id"), @Index("bar_id")},
        foreignKeys = {
                @ForeignKey(entity = Beer.class,
                        parentColumns = "id",
                        childColumns = "beer_id"),
                @ForeignKey(entity = Bar.class,
                        parentColumns = "id",
                        childColumns = "bar_id")
        })
/**
 * BarBeerJoin Class holds setters and getters for fetching the columns and rows of the Bar Database.
 */
public class BarBeerJoin {
    /**
     * In depth column and row information for BarBeerJoin Class.
     */
    @ColumnInfo(name = "beer_id")
    private long beerId;
    @ColumnInfo(name = "bar_id")
    private long barId;

    /**
     * Returns the Id of this instance.
     */
    public long getBeerId() {
        return beerId;
    }

    /**
     * Sets the Id of this instance.
     */
    public void setBeerId(long beerId) {
        this.beerId = beerId;
    }

    /**
     * Returns the BarId of this instance.
     */
    public long getBarId() {
        return barId;
    }

    /**
     * Sets the BarId of this instance.
     */
    public void setBarId(long barId) {
        this.barId = barId;
    }
}
