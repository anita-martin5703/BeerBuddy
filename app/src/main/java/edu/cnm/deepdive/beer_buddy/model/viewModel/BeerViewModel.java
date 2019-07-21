package edu.cnm.deepdive.beer_buddy.model.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.beer_buddy.model.database.BarDatabase;
import edu.cnm.deepdive.beer_buddy.model.entity.BarBeerJoin;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;
import java.util.List;

public class BeerViewModel extends AndroidViewModel {

  private LiveData<List<Beer>> beers;

  public BeerViewModel(@NonNull Application application) {
    super(application);
  }

  public LiveData<List<Beer>> getBeers(long barId){
    beers = BarDatabase.getInstance(getApplication()).barBeerJoinDao().getbarBeerJoinTable(barId);
    return beers;
  }

  public void addNewBeer (final Long barId, final Beer newBeer) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        long beerId = BarDatabase.getInstance(getApplication()).getBeerListingDao().insert(newBeer);
        BarBeerJoin barBeerjoin = new BarBeerJoin();
        barBeerjoin.setBarId(beerId);
        barBeerjoin.setBeerId(barId);
        BarDatabase.getInstance(getApplication()).barBeerJoinDao().insert(barBeerjoin);
      }
    }).start();
  }


}
