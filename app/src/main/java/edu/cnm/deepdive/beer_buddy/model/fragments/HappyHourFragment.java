package edu.cnm.deepdive.beer_buddy.model.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.entity.Beer;
import edu.cnm.deepdive.beer_buddy.model.entity.HappyHour;
import edu.cnm.deepdive.beer_buddy.model.viewModel.BeerViewModel;
import edu.cnm.deepdive.beer_buddy.model.viewModel.HappyHourViewModel;

public class HappyHourFragment extends Fragment implements View.OnClickListener {

    private View happyHourInfoView = null;
    private HappyHourViewModel happyHourViewModel;

    public HappyHourFragment() {
        //Required empty constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        happyHourViewModel = ViewModelProviders.of(getActivity()).get(HappyHourViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        happyHourInfoView = inflater.inflate(R.layout.fragment_happy_hour, container, false);
        initViews(happyHourInfoView);
        return happyHourInfoView;
    }

    private EditText selectBar;
    private EditText inputHours;
    private EditText inputWeekdays;
    private Button addHours;


    private void initViews(View view) {

        selectBar = (EditText) view.findViewById(R.id.bar_name_edit_text);
        inputHours = (EditText) view.findViewById(R.id.bar_hours_for_happy_hour);
        inputWeekdays = (EditText) view.findViewById(R.id.week_days);
        addHours = (Button) view.findViewById(R.id.button_submit_happy_hour_time);
        addHours.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_submit_happy_hour_time) {
            addInHours();
        }
    }

    private void addInHours() {
        if (!TextUtils.isEmpty(selectBar.getText().toString()) && !TextUtils.isEmpty(inputHours.getText().toString())
                && TextUtils.isEmpty(inputWeekdays.getText().toString())) {
            String name = selectBar.getText().toString();
            String hours = inputHours.getText().toString();
            String weekdays = inputWeekdays.getText().toString();
            HappyHour barUpdated = new HappyHour(name, hours, weekdays);
            happyHourInfoView.isActivated();
            selectBar.setText("barTestHR");
            inputHours.setText("hoursHR");
            inputWeekdays.setText("weekdaysHR");
        } else {
            Toast.makeText(getActivity(), "Please Try Again", Toast.LENGTH_LONG).show();
        }
    }
}
