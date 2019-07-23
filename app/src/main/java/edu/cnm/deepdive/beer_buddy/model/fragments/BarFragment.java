/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.viewModel.BarViewModel;

/**
 * Bar Fragment Class encapsulates the information to set up views to send to the viewModel.
 */
public class BarFragment extends Fragment {
    /**
     * Fields to be used in the this Bar Fragment
     */
    private BarViewModel barViewModel;
    private ListView searchResultsBar;
    private EditText barName;
    private EditText barType;
    private EditText barLocation;
    private EditText barProjectedDate;
    private ImageButton updateSearch;
    private ImageButton clear;

    /**
     * Required empty constructor
     */
    public BarFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBarViewModel();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        /**
         * Inflates the layout for this fragment
         */
        View barInfoView = inflater.inflate(R.layout.fragment_bar, container, false);
        setupBarSearch(barInfoView);
        return barInfoView;
    }

    private void setupBarSearch(View view) {
        barName = view.findViewById(R.id.select_bar_name);
        barType = view.findViewById(R.id.select_type_of_bar);
        barLocation = view.findViewById(R.id.select_bar_location);
        barProjectedDate = view.findViewById(R.id.projected_date);
        updateSearch = view.findViewById(R.id.search);
        clear = view.findViewById(R.id.clear);
        searchResultsBar = view.findViewById(R.id.list_of_bars);
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
        getLifecycle().addObserver(barViewModel);
        barViewModel.getAllBars("").observe(this, (bars) -> {
            ArrayAdapter<Bar> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, bars);
//            ArrayAdapter<Bar> adapter = new ArrayAdapter<>(getContext(), R.layout.fragment_bar, bars);
            // TODO build a custom Array Adapter to match the layout
            searchResultsBar.setAdapter(adapter);
        });
    }
}
