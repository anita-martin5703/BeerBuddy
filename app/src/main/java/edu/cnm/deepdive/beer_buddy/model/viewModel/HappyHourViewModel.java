package edu.cnm.deepdive.beer_buddy.model.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.beer_buddy.model.entity.HappyHour;

import java.util.List;

public class HappyHourViewModel extends AndroidViewModel {

    private LiveData<List<HappyHour>> happyHour;

    public HappyHourViewModel(@NonNull Application application) {
        super(application);
    }




    public LiveData<List<HappyHour>> getBars(long barId){
        return happyHour;
    }

}
