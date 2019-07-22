package edu.cnm.deepdive.beer_buddy.model.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.*;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.entity.HappyHour;
import edu.cnm.deepdive.beer_buddy.service.HappyHourService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import java.util.LinkedList;
import java.util.List;

public class HappyHourViewModel extends AndroidViewModel {

    private MutableLiveData<List<HappyHour>> happyHourBars;
    private CompositeDisposable pending = new CompositeDisposable();

    public HappyHourViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<HappyHour>> gethappyHourBars(String term) {
        if (happyHourBars == null) {
            happyHourBars = new MutableLiveData<List<edu.cnm.deepdive.beer_buddy.model.entity.HappyHour>>();
        }
        if (term != null) {
            pending.add(
                    HappyHourService.getInstance().searchBarsForHappyHour(term)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((happyHours -> happyHourBars.setValue(happyHours))
            ));
        }else {
            happyHourBars.setValue(new LinkedList<edu.cnm.deepdive.beer_buddy.model.entity.HappyHour>());
        }
        return happyHourBars;
    }

    public void insert(Bar bar) {
        happyHourBars.getValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disposePending() {
        pending.clear();
    }
}
