package edu.cnm.deepdive.beer_buddy.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.beer_buddy.model.entity.BarBeerJoin;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;
import java.util.List;

@Dao
public interface BarBeerJoinDao {

  @Insert
  void insert (BarBeerJoin barBeerJoin);

  @Query("SELECT beer.* FROM beer INNER JOIN BarBeerJoin ON " +
      "Beer.id = BarBeerJoin.beer_id WHERE " +
      "BarBeerJoin.bar_id = :barId")
  LiveData<List<Beer>> getbarBeerJoinTable(long barId);

}