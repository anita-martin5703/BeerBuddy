/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.database;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.beer_buddy.model.dao.BarBeerJoinDao;
import edu.cnm.deepdive.beer_buddy.model.dao.BarDao;
import edu.cnm.deepdive.beer_buddy.model.dao.BeerDao;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.entity.BarBeerJoin;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;

/**
 * Class BarDatabase sets up the mapping for Room to build the database.
 */
@Database(entities = {Bar.class, Beer.class, BarBeerJoin.class}, version = 1, exportSchema = false)
public abstract class BarDatabase extends RoomDatabase {

    private static BarDatabase INSTANCE;
    private static BarDatabase.Callback sBarDatabaseCallback = new BarDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbTask(INSTANCE).execute();
        }
    };

    /**
     * Method returns the built database.
     */
    public static BarDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (BarDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        BarDatabase.class, "bar_room_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                                new PopulateDbTask(INSTANCE).execute();
                            }
                        }).build();
            }
        }

        return INSTANCE;
    }

    public abstract BarDao getBarListingDao();

    public abstract BeerDao getBeerListingDao();

    public abstract BarBeerJoinDao barBeerJoinDao();

    /**
     * Method creates a dummy database on first open of the app.
     */
    private static class PopulateDbTask extends AsyncTask<Void, Void, Void> {

        private final BarDatabase db;

        PopulateDbTask(BarDatabase db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Bar marble = new Bar("", "", "", "");
            marble.setName("Marble");
            marble.setType("Brewery");
            marble.setLocation("ABQ");
            marble.setProjectedDate("N/A");
            db.getBarListingDao().insert(marble);
            return null;
        }

    }
}