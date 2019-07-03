package edu.cnm.deepdive.beer_buddy.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(
    indices = {
        @Index(value = "name", unique = true)
    }
)
  public class Beer implements Serializable {

  private static final long serialVersionUID = 1l;

  @PrimaryKey(autoGenerate = true)
  private Long id;
  @ColumnInfo(name = "beer_id", index = true)
  private Long beerId;
  private String name;
  @ColumnInfo(name = "brewery_house", index = true)
  private String breweryHouse;
  private String type;
  private String style;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getBeerId() {
    return beerId;
  }

  public void setBeerId(Long beerId) {
    this.beerId = beerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBreweryHouse() {
    return breweryHouse;
  }

  public void setBreweryHouse(String breweryHouse) {
    this.breweryHouse = breweryHouse;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }


  @NonNull
  @Override
  public String toString() {
    return name;
  }
}
