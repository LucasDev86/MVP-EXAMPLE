package mvp.lucas.com.mvpexample.Network;

import android.Manifest;
import android.support.annotation.RequiresPermission;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by rnj on 2016-03-22.
 */
public class RetrofitFactory {

    // Base URL: always ends with /
    public static final String URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/";

    //region Singleton Retrofit
    private static Retrofit retrofit;

    /**
     * Get {@link Retrofit} instance.
     * @return instances of {@link Retrofit}
     */
    @RequiresPermission(Manifest.permission.INTERNET)
    public static Retrofit getRetrofit(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
    //endregion
}
