/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.viewModel.BarViewModel;


public class BarFragment extends Fragment {

    private BarViewModel barViewModel;
    private ListView searchResultsBar;
    private EditText barName;
    private EditText barType;
    private EditText barLocation;
    private EditText barProjectedDate;
    private ImageButton updateSearch;
    private ImageButton clear;

    public BarFragment() {
        //Required empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBarViewModel();
        setupBarSearch();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View barInfoView = inflater.inflate(R.layout.fragment_bar, container, false);
        return barInfoView;
    }

    private void setupBarSearch() {
        barName = barName.findViewById(R.id.select_bar_name);
        barType = barType.findViewById(R.id.select_type_of_bar);
        barLocation = barLocation.findViewById(R.id.select_bar_location);
        barProjectedDate = barType.findViewById(R.id.projected_date);
        updateSearch = updateSearch.findViewById(R.id.search);
        clear = clear.findViewById(R.id.clear);
        searchResultsBar = searchResultsBar.findViewById(R.id.list_of_bars);
        updateSearch.setOnClickListener((v -> barViewModel.getAllBars(barName.getText().toString().trim())));
        clear.setOnClickListener((v -> {
            barName.getText().clear();
            barViewModel.getAllBars(null);
        }));
        searchResultsBar.setOnItemClickListener((adapterView, view1, position, rowId) -> {
            Bar bar = (Bar) adapterView.getItemAtPosition(position);
            String term = barName.getText().toString().trim();
            String barTitle = term.isEmpty() ? getString(R.string.search_all_bar)
                    : getString(R.string.search_bar, term);
            Runnable next = (position >= adapterView.getCount() - 1) ? null : () -> {
                if (position < adapterView.getCount() - 1) {
                    searchResultsBar.performItemClick(null, position + 1,
                            searchResultsBar.getItemIdAtPosition(position + 1));
                }
            };
        });
    }

    private void setupBarViewModel() {
        barViewModel = ViewModelProviders.of(this).get(BarViewModel.class);
        getLifecycle().addObserver((LifecycleObserver) barViewModel);
        barViewModel.getAllBars("").observe(this, (bars) -> {
            ArrayAdapter<Bar> adapter = new ArrayAdapter<>(getContext(), R.layout.fragment_bar, bars);
            searchResultsBar.setAdapter(adapter);
        });
    }
}
