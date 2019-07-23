/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;

import java.util.List;

/**
 * Returns the {@link Bar} specified by <code>movieId</code> from the database.
 *
 * @param :id {@link Bar} primary key value.
 * @return {@link LiveData LiveData&lt;Bar&gt;} instance.
 */

@Dao
public interface BarDao {

    @Insert
    long insert(Bar bar);

    @Query("SELECT * FROM bar")
    LiveData<List<Bar>> getAll();

    @Query("SELECT * FROM Bar WHERE id = :id")
    LiveData<Bar> findById(Long id);

}
