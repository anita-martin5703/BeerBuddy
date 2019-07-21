package edu.cnm.deepdive.beer_buddy.model.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class BeerFragment extends Fragment implements View.OnClickListener {

    private View beerInfoView = null;
    private BeerViewModel beerViewModel;

    public BeerFragment() {
        //Required empty constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beerViewModel = ViewModelProviders.of(getActivity()).get(BeerViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        beerInfoView = inflater.inflate(R.layout.fragment_beer, container, false);
        initViews(beerInfoView);

        return beerInfoView;
    }

    private EditText selectBeer;
    private EditText selectBrewery;
    private EditText selectBeerAbv;
    private EditText selectBeerStyle;
    private Button updateBeerSearch;

    @SuppressLint("WrongViewCast")
    private void initViews(View view) {
        selectBeer= (EditText) view.findViewById(R.id.select_beer_name);
        selectBrewery = (EditText) view.findViewById(R.id.select_brewery);
        selectBeerAbv = (EditText) view.findViewById(R.id.select_beer_abv);
        selectBeerStyle = (EditText) view.findViewById(R.id.select_beer_style);
        updateBeerSearch = (Button) view.findViewById(R.id.button_update_beer_list);
        updateBeerSearch.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_update_beer_list) {
            updateBarInfo();
        }
    }

    private void updateBarInfo() {
        if (!TextUtils.isEmpty(selectBeer.getText().toString()) && !TextUtils.isEmpty(selectBrewery.getText().toString())
                && TextUtils.isEmpty(selectBeerAbv.getText().toString()) && TextUtils.isEmpty(selectBeerStyle.getText().toString())) {
            String name = selectBeer.getText().toString();
            String brewery = selectBrewery.getText().toString();
            String beerAbv = selectBeerAbv.getText().toString();
            String beerStyle = selectBeerStyle.getText().toString();
            Beer beer = new Beer(name, brewery, beerAbv, beerStyle);
            beerInfoView.isActivated();
            selectBeer.setText("beerTest");
            selectBrewery.setText("beerTest");
            selectBeerAbv.setText("beerTest");
            selectBeerStyle.setText("beerTest");
        } else {
            Toast.makeText(getActivity(), "Please Try Again", Toast.LENGTH_LONG).show();
        }
    }
}