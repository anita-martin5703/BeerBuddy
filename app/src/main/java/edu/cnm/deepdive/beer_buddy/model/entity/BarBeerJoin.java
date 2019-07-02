package edu.cnm.deepdive.beer_buddy.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

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

public class BarBeerJoin {

  @ColumnInfo(name = "beer_id")
  private long beerId;
  @ColumnInfo(name = "bar_id")
  private long barId;



  public long getBeerId() {
    return beerId;
  }

  public void setBeerId(long beerId) {
    this.beerId = beerId;
  }

  public long getBarId() {
    return barId;
  }

  public void setBarId(long barId) {
    this.barId = barId;
  }
}
