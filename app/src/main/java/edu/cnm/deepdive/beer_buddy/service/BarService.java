package edu.cnm.deepdive.beer_buddy.service;

import edu.cnm.deepdive.beer_buddy.BuildConfig;
import edu.cnm.deepdive.beer_buddy.model.entity.Bar;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface BarService {
    @GET("bar/search")
    Observable<List<Bar>> getBars(@Query("q") String fragment);

    static BarService getInstance() {
        return BarService.InstanceHolder.INSTANCE;
    }

    class InstanceHolder {

        private static final BarService INSTANCE;

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
            INSTANCE = retrofit.create(BarService.class);

        }
    }
}
