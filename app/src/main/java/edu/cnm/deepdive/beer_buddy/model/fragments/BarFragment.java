package edu.cnm.deepdive.beer_buddy.model.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.viewModel.BarViewModel;


public class BarFragment extends Fragment {

    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public static BarFragment newInstance() {
        return new BarFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_bar, container, false);
        final BarViewModel viewModel = ViewModelProviders.of(this).get(BarViewModel.class);
        viewModel.getBar().observe(this, bars -> {
            final ArrayAdapter<Bar> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, bars);

            ListView barListview = view.findViewById(R.id.list_of_bars);
            barListview.setAdapter(adapter);
        });
        return inflater.inflate(R.layout.fragment_bar, null);
    }


}
