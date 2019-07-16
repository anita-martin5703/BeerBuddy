package edu.cnm.deepdive.beer_buddy;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.beer_buddy.service.GoogleSignInService;

public class BarApplication extends Application {

  @Override
  public void onCreate(){
    super.onCreate();
    GoogleSignInService.setContext(this);
  }

}
