package mvp.lucas.com.mvpexample.Mvp.presenter;

import android.content.Context;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import mvp.lucas.com.mvpexample.Model.MovieData;
import mvp.lucas.com.mvpexample.Mvp.contract.MainContract;
import mvp.lucas.com.mvpexample.Network.DataWebService;
import mvp.lucas.com.mvpexample.Network.RetrofitFactory;
import mvp.lucas.com.mvpexample.R;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rnj on 2016-10-14.
 */

public class MainPresenter implements MainContract.Presenter {

    private final Context context;
    private final MainContract.View view;

    public MainPresenter(Context context, MainContract.View view) {
        this.context = context;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void apiMovie() {
        view.showLoading();
        DataWebService service = RetrofitFactory.getRetrofit(RetrofitFactory.URL).create(DataWebService.class);
        Observable<MovieData> call = service.loadMovie(context.getString(R.string.movieKey), getCalsDate(3, -1, "yyyyMMdd"))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        call.subscribe(new Observer<MovieData>() {
            @Override
            public void onCompleted() {
                view.hideLoading();
                Log.d("lucas", "lucas 완료완료 ");
            }

            @Override
            public void onError(Throwable e) {
                view.showError();
                Log.d("lucas", "lucas e == " + e.getMessage());
                Log.d("lucas", "lucas e == " + e.toString());
                Log.d("lucas", "lucas e == " + e.getStackTrace());
            }

            @Override
            public void onNext(MovieData movieData) {
                view.setMovie(movieData);

                Log.d("lucas", "movieData == " + movieData.getBoxOfficeResult().getWeeklyBoxOfficeList().size());
            }
        });

        Log.d("lucas", "lucas param 1 == " + context.getString(R.string.movieKey) + " param 2 ==" + getCalsDate(3, -1, "yyyyMMdd"));
    }

    public static String getCalsDate(int y, int z, String date_type) {

        Calendar cal = Calendar.getInstance(Locale.KOREAN);
        TimeZone timezone = cal.getTimeZone();
        timezone = timezone.getTimeZone("Asia/Seoul");
        cal = Calendar.getInstance(timezone);

        cal.add(y, z);
        Date currentTime = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(date_type, Locale.KOREAN);
        String timestr = formatter.format(currentTime);

        return timestr;
    }

}
