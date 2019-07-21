package edu.cnm.deepdive.beer_buddy.model.fragments;

import android.annotation.SuppressLint;
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
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.viewModel.BarViewModel;


public class BarFragment extends Fragment implements View.OnClickListener {

    private View barInfoView = null;
    private BarViewModel barViewModel;

    public BarFragment() {
        //Required empty constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        barViewModel = ViewModelProviders.of(getActivity()).get(BarViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        barInfoView = inflater.inflate(R.layout.fragment_bar, container, false);
        initViews(barInfoView);

        return barInfoView;
    }

    private EditText selectBar;
    private EditText selectType;
    private EditText selectLocation;
    private EditText projectedDate;
    private Button updateSearch;

    @SuppressLint("WrongViewCast")
    private void initViews(View view) {
        selectBar = (EditText) view.findViewById(R.id.select_bar_name);
        selectType = (EditText) view.findViewById(R.id.select_type_of_bar);
        selectLocation = (EditText) view.findViewById(R.id.select_bar_location);
        projectedDate = (EditText) view.findViewById(R.id.projected_date);
        updateSearch = (Button) view.findViewById(R.id.button_update_bar_list);
        updateSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_update_bar_list) {
            updateBarInfo();
        }
    }

    private void updateBarInfo() {
        if (!TextUtils.isEmpty(selectBar.getText().toString()) && !TextUtils.isEmpty(selectType.getText().toString())
                && TextUtils.isEmpty(selectLocation.getText().toString()) && TextUtils.isEmpty(projectedDate.getText().toString())) {
            String name = selectBar.getText().toString();
            String type = selectType.getText().toString();
            String location = selectLocation.getText().toString();
            String getProjectedDate = projectedDate.getText().toString();
            Bar bar = new Bar(name, type, location, getProjectedDate);
            barViewModel.insert(bar);
            selectBar.setText("");
            selectBar.setText("");
            selectLocation.setText("");
            projectedDate.setText("");
        } else {
            Toast.makeText(getActivity(), "Incorrect Information", Toast.LENGTH_LONG).show();
        }
    }
}
