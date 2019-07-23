/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.*;
import edu.cnm.deepdive.beer_buddy.BuildConfig;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.pojo.BarSearchResponse;
import edu.cnm.deepdive.beer_buddy.service.UntappdService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import java.util.LinkedList;
import java.util.List;

/**
 * BarViewModel models the domain of our database by calling on our API via HTTP.
 */
public class BarViewModel extends AndroidViewModel implements LifecycleObserver {

    private MutableLiveData<List<Bar>> mAllBars;
    private CompositeDisposable pending = new CompositeDisposable();

    /**
     * BarViewModel returns a super.
     *
     * @param application super created.
     */
    public BarViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * LiveData is used to display LiveData of Bars
     *
     * @param term inputs the query of the String searching
     * @return returns Live Data of Bars
     */
    public LiveData<List<Bar>> getAllBars(String term) {
        if (mAllBars == null) {
            mAllBars = new MutableLiveData<>();
        }
        if (term != null) {
            if (term.trim().isEmpty()) {
                term = "new mexico";
            }
            pending.add(
                    UntappdService.getInstance().getBars(BuildConfig.CLIENT_ID, BuildConfig.CLIENT_SECRET, term)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe((searchResponse) -> {
                                List<BarSearchResponse.Item> items = searchResponse.getResponse().getBrewery().getItems();
                                List<Bar> bars = new LinkedList<>();
                                for (BarSearchResponse.Item item : items) {
                                    bars.add(item.getBrewery());
                                }
                                mAllBars.setValue(bars);
                            }));
        } else {
            mAllBars.setValue(new LinkedList<>());
        }
        return mAllBars;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disposePending() {
        pending.clear();
    }

}
