package edu.cnm.deepdive.beer_buddy.model.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;

import java.util.List;

public class HappyHourViewModel extends AndroidViewModel {

    private LiveData<List<Bar>> happyHourBars;

    public HappyHourViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Bar>> getAllBars() {
        return happyHourBars;
    }

    public void insert(Bar bar) {
        happyHourBars.getValue();
    }
}
