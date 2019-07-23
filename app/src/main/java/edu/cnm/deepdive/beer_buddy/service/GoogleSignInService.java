/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.service;

import android.app.Application;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/**
 * This is a singleton class, private constructor, static method to return single instance fo this class.
 */
public class GoogleSignInService {

    private static Application context;

    private GoogleSignInAccount account;
    private GoogleSignInClient client;

    private GoogleSignInService() {
        GoogleSignInOptions options = new GoogleSignInOptions.Builder()
                .requestEmail()
                .requestId()
                .build();
        client = GoogleSignIn.getClient(context, options);
    }

    /**
     * Sets context, context for Google Sign-in
     * @param context set Context, Context
     */
    public static void setContext(Application context) {
        GoogleSignInService.context = context;
    }

    /**
     * @return Returns Instance of Google Sign-in
     */
    public static GoogleSignInService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * @return Returns client for Google-Sign in.
     */
    public GoogleSignInClient getClient() {
        return client;
    }

    /**
     * @return Returns account for Google Sign-in
     */
    public GoogleSignInAccount getAccount() {
        return account;
    }

    /**
     * Sets account for Google Sign-in
     * @param account sets account according to sign-in
     */
    public void setAccount(GoogleSignInAccount account) {
        this.account = account;
    }

    private static class InstanceHolder {
        private static final GoogleSignInService INSTANCE = new GoogleSignInService();
    }
}
