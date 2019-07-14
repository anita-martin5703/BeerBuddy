package edu.cnm.deepdive.beer_buddy.model.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.beer_buddy.R;

public class HappyHourFragment extends Fragment {

    private Context context;

    public HappyHourFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_happy_hour, container, false);

        final ListView barListView = view.findViewById(R.id.list_of_happy_hour_times);

        return view;
    }
}
