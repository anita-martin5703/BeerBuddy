package edu.cnm.deepdive.beer_buddy.model.viewModel;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.repository.BarRepository;

import java.util.List;

public class BarViewModel extends AndroidViewModel {

  private BarRepository barRepository;
  private LiveData<List<Bar>> mAllBars;

  public BarViewModel(@NonNull Application application) {
    super(application);
    barRepository = new BarRepository(application);
    mAllBars = BarRepository.getAllBars();
  }

  public LiveData<List<Bar>> getAllBars() {
    return mAllBars;
  }

  public void insert (Bar bar) {
    barRepository.insert(bar);
  }}