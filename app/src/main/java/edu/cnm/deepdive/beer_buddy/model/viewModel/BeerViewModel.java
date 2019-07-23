/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.*;
import edu.cnm.deepdive.beer_buddy.BuildConfig;
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

  public LiveData<List<Beer>> getAllBeers(String term) {
    if (mAllBeer == null) {
      mAllBeer = new MutableLiveData<>();
    }
    if (term != null) {
      pending.add(
              BeerService.getInstance().getBeer(BuildConfig.CLIENT_ID, BuildConfig.CLIENT_SECRET, term)
                      .subscribeOn(Schedulers.io())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe((beers -> mAllBeer.setValue(beers))
                      ));
    } else {
      mAllBeer.setValue(new LinkedList<>());
    }
    return mAllBeer;
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void disposePending() {
    pending.clear();
  }
}
