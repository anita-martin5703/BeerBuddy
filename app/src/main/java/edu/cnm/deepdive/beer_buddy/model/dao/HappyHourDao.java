/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.entity.HappyHour;

import java.util.List;

/**
 * Returns the Happy Hour specified by bar from the database.
 */

@Dao
public interface HappyHourDao {

    @Insert
    long insert(HappyHour happyHour);

    @Query("SELECT * FROM bar")
    LiveData<List<Bar>> getAll();

}
