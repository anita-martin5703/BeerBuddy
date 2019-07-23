/**
 * Copyright 2019 Anita Martin. All rights reserved.
 */
package edu.cnm.deepdive.beer_buddy.service;

import edu.cnm.deepdive.beer_buddy.BuildConfig;
import edu.cnm.deepdive.beer_buddy.model.pojo.BarSearchResponse;
import edu.cnm.deepdive.beer_buddy.model.pojo.BeerSearchResponse;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Sets context, context for Google Sign-in
 */
public interface UntappdService {

    static UntappdService getInstance() {
        return UntappdService.InstanceHolder.INSTANCE;
    }

    @GET("search/brewery")
    Single<BarSearchResponse> getBars(@Query("client_id") String clientId,
                                      @Query("client_secret") String clientSecret,
                                      @Query("q") String fragment);

    @GET("search/beer")
    Single<BeerSearchResponse> getBeer(@Query("client_id") String clientId,
                                       @Query("client_secret") String clientSecret,
                                       @Query("q") String fragment);

    /**
     * Sets up HTTP Interceptor to call on API.
     */
    class InstanceHolder {

        private static final UntappdService INSTANCE;

        static {
            // Following five lines should be removed/commented out for production release.
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .client(client) // This should be removed/commented out for production release.
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .build();
            INSTANCE = retrofit.create(UntappdService.class);

        }
    }
}
