package edu.cnm.deepdive.beer_buddy.model.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.*;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;
import edu.cnm.deepdive.beer_buddy.service.BeerService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import java.util.LinkedList;
import java.util.List;

public class BeerViewModel extends AndroidViewModel {


  private MutableLiveData<List<Beer>> mAllBeer;
  private CompositeDisposable pending = new CompositeDisposable();

  public BeerViewModel(@NonNull Application application) {
    super(application);
  }

  public LiveData<List<Beer>> getmAllBeers(String term) {
    if (mAllBeer == null) {
      mAllBeer = new MutableLiveData<List<edu.cnm.deepdive.beer_buddy.model.entity.Beer>>();
    }
    if (term != null) {
      pending.add(
              BeerService.getInstance().getBeer(term)
                      .subscribeOn(Schedulers.io())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe((beers -> mAllBeer.setValue(beers))
                      ));
    } else {
      mAllBeer.setValue(new LinkedList<edu.cnm.deepdive.beer_buddy.model.entity.Beer>());
    }
    return mAllBeer;
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void disposePending() {
    pending.clear();
  }
}
