package edu.cnm.deepdive.beer_buddy.model.fragments;


import android.content.Context;
import android.os.Bundle;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;
import edu.cnm.deepdive.beer_buddy.model.viewModel.BarViewModel;

import java.util.List;

public class BeerFragment extends Fragment {

    private Context context;

    public BeerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_beer, container, false);

        final ListView barListView = view.findViewById(R.id.list_of_beers);

        final BarViewModel viewModel = ViewModelProviders.of(getActivity()).get(BarViewModel.class);


        viewModel.getBeerLiveData().observe(this, new Observer<List<Beer>>() {
            @Override
            public void onChanged(List<Beer> beerList) {
                final ArrayAdapter<Beer> adapter = new ArrayAdapter<Beer>
                        (context, android.R.layout.simple_list_item_1, beerList);
                barListView.setAdapter(adapter);
                barListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // TODO find out name for directional arrow bar frag to beer frag.
                    }
                });
            }
        });


        Button newBeerButton = view.findViewById(R.id.button_update_beer_list);
        newBeerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView selectBeerName = view.findViewById(R.id.select_beer_name);
                TextView selectBrewery = view.findViewById(R.id.select_brewery);
                TextView selectBeerAbv = view.findViewById(R.id.select_beer_abv);
                TextView selectBeerStyle = view.findViewById(R.id.select_beer_style);
                Beer newBeer = new Beer();
                newBeer.setName(selectBeerName.getText().toString());
                newBeer.setBreweryHouse(selectBrewery.getText().toString());
                newBeer.setBeerAbv(selectBeerAbv.getText().toString());
                newBeer.setStyle(selectBeerStyle.getText().toString());
                viewModel.updateBeers(newBeer);
            }
        });
        return view;
    }

}
