package edu.cnm.deepdive.beer_buddy.model.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.*;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.service.BarService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import java.util.LinkedList;
import java.util.List;

public class BarViewModel extends AndroidViewModel {

    private MutableLiveData<List<Bar>> mAllBars;
    private CompositeDisposable pending = new CompositeDisposable();

    public BarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Bar>> getmAllBars(String term) {
        if (mAllBars == null) {
            mAllBars = new MutableLiveData<>();
        }
        if (term != null) {
            pending.add(
                    BarService.getInstance().getBars(term)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe((bars -> mAllBars.setValue(bars))
                            ));
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
