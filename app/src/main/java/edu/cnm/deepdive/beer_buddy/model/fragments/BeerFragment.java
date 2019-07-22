package edu.cnm.deepdive.beer_buddy.model.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;
import edu.cnm.deepdive.beer_buddy.model.viewModel.BarViewModel;
import edu.cnm.deepdive.beer_buddy.model.viewModel.BeerViewModel;
import edu.cnm.deepdive.beer_buddy.service.BeerService;

import java.util.List;

public class BeerFragment extends Fragment {

    private BeerViewModel beerViewModel;
    private EditText selectBeer;
    private EditText selectBrewery;
    private EditText selectBeerAbv;
    private EditText selectBeerStyle;
    private ImageButton searchButton;
    private ImageButton clearButton;
    private ListView searchResultsBeer;

    public BeerFragment() {
        //Required empty constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBeerSearch();
        setupBeerViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View beerInfoView = inflater.inflate(R.layout.fragment_beer, container, false);
        return beerInfoView;
    }

    private void setupBeerSearch() {
        selectBeer= selectBeer.findViewById(R.id.select_beer_name);
        selectBrewery = selectBrewery.findViewById(R.id.select_brewery);
        selectBeerAbv = selectBeerAbv.findViewById(R.id.select_beer_abv);
        selectBeerStyle = selectBeerStyle.findViewById(R.id.select_beer_style);
        searchButton = searchButton.findViewById(R.id.search_beer_button);
        clearButton = clearButton.findViewById(R.id.clear_beer_button);
        searchResultsBeer = searchResultsBeer.findViewById(R.id.list_of_beers);
        searchButton.setOnClickListener((v -> beerViewModel.getmAllBeers(selectBeer.getText().toString().trim())));
        clearButton.setOnClickListener((v -> {
            selectBeer.getText().clear();
            beerViewModel.getmAllBeers(null);
        }));
        searchResultsBeer.setOnItemClickListener((adapterView, view1, position, rowId) -> {
            Beer beer = (Beer) adapterView.getItemAtPosition(position);
            String term = selectBeer.getText().toString().trim();
            String beerTitle = term.isEmpty() ? getString(R.string.search_all_beer)
                    : getString(R.string.search_beer, term);
            Runnable next = (position >= adapterView.getCount() - 1) ? null : () -> {
                if (position < adapterView.getCount() - 1) {
                    searchResultsBeer.performItemClick(null, position + 1,
                            searchResultsBeer.getItemIdAtPosition(position + 1));
                }
            };
        });
    }

    private void setupBeerViewModel() {
        beerViewModel = ViewModelProviders.of(this).get(BeerViewModel.class);
        getLifecycle().addObserver((LifecycleObserver) beerViewModel);
        beerViewModel.getmAllBeers(null).observe(this, (bars -> {
            ArrayAdapter<Bar> adapter = new ArrayAdapter<>(this, R.layout.fragment_bar, bars);
            searchResultsBeer.setAdapter(adapter);
        }));
    }

}