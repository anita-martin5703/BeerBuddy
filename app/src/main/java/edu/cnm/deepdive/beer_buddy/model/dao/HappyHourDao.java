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
 * Returns the {@link HappyHour} specified by <code>movieId</code> from the database.
 *
 * @param :id {@link HappyHour} primary key value.
 * @return {@link LiveData LiveData&lt;Movie&gt;} instance.
 */

@Dao
public interface HappyHourDao {

    @Insert
    long insert(HappyHour happyHour);

    @Query("SELECT * FROM bar")
    LiveData<List<Bar>> getAll();

}
