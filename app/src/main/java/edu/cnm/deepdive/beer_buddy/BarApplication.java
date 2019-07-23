/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.beer_buddy.service.GoogleSignInService;

/**
 * Class for application setup.
 */
public class BarApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        GoogleSignInService.setContext(this);
    }

}
