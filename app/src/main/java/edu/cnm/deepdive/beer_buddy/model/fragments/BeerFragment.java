/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.fragments;


import android.os.Bundle;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;
import edu.cnm.deepdive.beer_buddy.model.viewModel.BeerViewModel;
/**
 * Beer Fragment Class encapsulates the information to set up views to send to the viewModel.
 */
public class BeerFragment extends Fragment {
    /**
     * Fields to be used in the this Beer Fragment
     */
    private BeerViewModel beerViewModel;
    private EditText selectBeer;
    private EditText selectBrewery;
    private EditText selectBeerAbv;
    private EditText selectBeerStyle;
    private ImageButton searchButton;
    private ImageButton clearButton;
    private ListView searchResultsBeer;

    /**
     * Required empty constructor
     */
    public BeerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBeerViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        /**
         * Inflates the layout for this fragment
         */
        View beerInfoView = inflater.inflate(R.layout.fragment_beer, container, false);
        setupBeerSearch(beerInfoView);
        return beerInfoView;
    }
    /**
     * Sets up the search results according to the user input in a List View.
     */
    private void setupBeerSearch(View view) {
        selectBeer= view.findViewById(R.id.select_beer_name);
        selectBrewery = view.findViewById(R.id.select_brewery);
        selectBeerAbv = view.findViewById(R.id.select_beer_abv);
        selectBeerStyle = view.findViewById(R.id.select_beer_style);
        searchButton = view.findViewById(R.id.search_beer_button);
        clearButton = view.findViewById(R.id.clear_beer_button);
        searchResultsBeer = view.findViewById(R.id.list_of_beers);
        searchButton.setOnClickListener((v -> beerViewModel.getAllBeers(selectBeer.getText().toString().trim())));
        clearButton.setOnClickListener((v -> {
            selectBeer.getText().clear();
            beerViewModel.getAllBeers(null);
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
    /**
     * Sets up the View Model output into a generic layout.
     */
    private void setupBeerViewModel() {
        beerViewModel = ViewModelProviders.of(this).get(BeerViewModel.class);
        getLifecycle().addObserver(beerViewModel);
        beerViewModel.getAllBeers("").observe(this, (beers) -> {
            ArrayAdapter<Beer> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, beers);
//            ArrayAdapter<Beer> adapter = new ArrayAdapter<>(getContext(), R.layout.fragment_bar, beers);
            // TODO build a custom Array Adapter to match the layout
            searchResultsBeer.setAdapter(adapter);
        });
    }

}