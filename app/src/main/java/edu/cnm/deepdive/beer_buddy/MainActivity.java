package edu.cnm.deepdive.beer_buddy;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import edu.cnm.deepdive.beer_buddy.model.fragments.BarFragment;
import edu.cnm.deepdive.beer_buddy.model.fragments.BeerFragment;
import edu.cnm.deepdive.beer_buddy.model.fragments.HappyHourFragment;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation_main);
        navigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new BarFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch (menuItem.getItemId()) {

            case R.id.navigation_map:
                fragment = new BarFragment();
                break;

            case R.id.navigation_beer:
                fragment = new BeerFragment();
                break;

            case R.id.navigation_happy_hour:
                fragment = new HappyHourFragment();
                break;
        }

        return loadFragment(fragment);
    }

}