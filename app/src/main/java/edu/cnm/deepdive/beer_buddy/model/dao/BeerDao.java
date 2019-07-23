/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;

import java.util.List;

/**
 * Returns the Beer specified by beer from the database.
 */

@Dao
public interface BeerDao {

    @Insert
    long insert(Beer beer);

    @Query("SELECT * FROM beer")
    LiveData<List<Beer>> getAll();

    @Query("SELECT * FROM Beer WHERE id = :id")
    LiveData<Beer> findById(Long id);


}
