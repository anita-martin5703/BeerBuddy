package edu.cnm.deepdive.beer_buddy.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.beer_buddy.LoginActivity;
import edu.cnm.deepdive.beer_buddy.R;
import edu.cnm.deepdive.beer_buddy.model.database.BarDatabase;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import edu.cnm.deepdive.beer_buddy.model.fragments.BarFragment;
import edu.cnm.deepdive.beer_buddy.model.fragments.BeerFragment;
import edu.cnm.deepdive.beer_buddy.model.fragments.HappyHourFragment;
import edu.cnm.deepdive.beer_buddy.service.BarService;
import edu.cnm.deepdive.beer_buddy.service.GoogleSignInService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private static Retrofit retrofit = null;
//    private RecyclerView recyclerView = null;
//
//    BarService barService = retrofit.create(BarService.class);
//
//    Call<Bar> call = (Call<Bar>) barService.search("q");
//
//    public void onResponse(Call<BarService> call, Response<BarService> response) {
//        List<Bar> bars = (List<Bar>) BarService.getInstance();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
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

    // This method is used to sign-out from Google.
    private void signOut() {
        GoogleSignInService service = GoogleSignInService.getInstance();
        service.getClient().signOut().addOnCompleteListener((task) -> {
            service.setAccount(null);
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }

    // Navigation is used to navigate between main windows.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.navigation_bar:
                fragment = new BarFragment();
                break;
            case R.id.navigation_beer:
                fragment = new BeerFragment();
                break;
            case R.id.navigation_happy_hour:
                fragment = new HappyHourFragment();
                break;
            case R.id.sign_out:
                signOut();
        }
        return loadFragment(fragment);
    }

}