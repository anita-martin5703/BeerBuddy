package edu.cnm.deepdive.beer_buddy.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.entity.HappyHour;
import java.util.List;

@Dao
public interface HappyHourDao {

  @Insert
  long insert(HappyHour happyHour);

  @Query("SELECT * FROM bar")
  LiveData<List<Bar>> getAll();

}
