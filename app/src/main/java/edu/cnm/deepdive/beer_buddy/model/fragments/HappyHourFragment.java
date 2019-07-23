/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.model.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.entity.HappyHour;

/**
 * HappyHour Fragment Class encapsulates the information to set up views to send to the viewModel.
 */
public class HappyHourFragment extends Fragment {
    /**
     * Fields to be used in the this HappyHour Fragment
     */
    private EditText selectBar;
    private EditText inputHours;
    private EditText inputWeekdays;
    private Button addHours;

    /**
     * Required empty constructor
     */
    public HappyHourFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpHappyHour();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        View happyHourInfoView = inflater.inflate(R.layout.fragment_happy_hour, container, false);
        return happyHourInfoView;
    }

    private void setUpHappyHour() {
        selectBar = selectBar.findViewById(R.id.bar_name_edit_text);
        inputHours = inputHours.findViewById(R.id.bar_hours_for_happy_hour);
        inputWeekdays = inputWeekdays.findViewById(R.id.week_days);
        addHours = addHours.findViewById(R.id.button_submit_happy_hour_time);
        if (!TextUtils.isEmpty(selectBar.getText().toString()) && !TextUtils.isEmpty(inputHours.getText().toString())
                && TextUtils.isEmpty(inputWeekdays.getText().toString())) {
            String name = selectBar.getText().toString();
            String hours = inputHours.getText().toString();
            String weekdays = inputWeekdays.getText().toString();
            HappyHour barUpdated = new HappyHour();
            selectBar.setText("@+id/set_text_bar");
            inputHours.setText("@+id/set_text_time");
            inputWeekdays.setText("@+id/set_text_weekday");
        } else {
            Toast.makeText(getActivity(), "Please Try Again", Toast.LENGTH_LONG).show();

        }

    }
}