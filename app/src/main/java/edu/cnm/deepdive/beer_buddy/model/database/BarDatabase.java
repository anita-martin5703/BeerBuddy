package edu.cnm.deepdive.beer_buddy.model.database;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.entity.BarBeerJoin;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;
import edu.cnm.deepdive.beer_buddy.model.dao.BarBeerJoinDao;
import edu.cnm.deepdive.beer_buddy.model.dao.BarDao;
import edu.cnm.deepdive.beer_buddy.model.dao.BeerDao;

@Database(entities = {Bar.class, Beer.class, BarBeerJoin.class}, version = 1)
public abstract class BarDatabase extends RoomDatabase {

  public abstract BarDao getBarListingDao();
  public abstract BeerDao getBeerListingDao();
  public abstract BarBeerJoinDao barBeerJoinDao();
  private static BarDatabase INSTANCE;


  public static BarDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      synchronized (BarDatabase.class) {
        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
            BarDatabase.class, "bar_room")
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

  private static class PopulateDbTask extends AsyncTask<Void, Void, Void> {

    private final BarDatabase db;

    PopulateDbTask(BarDatabase db) {
      this.db = db;
    }

    @Override
    protected Void doInBackground(Void... voids) {
      Bar marble = new Bar();
      marble.setName("Marble");
      db.getBarListingDao().insert(marble);
      return null;
    }
  }
}
