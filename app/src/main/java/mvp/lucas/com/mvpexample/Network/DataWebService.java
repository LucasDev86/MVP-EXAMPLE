package mvp.lucas.com.mvpexample.Network;


import mvp.lucas.com.mvpexample.Model.MovieData;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by rnj on 2016-10-14.
 */

public interface DataWebService {
    /**
     * 영화목록 받아오기
     **/
    @GET("searchWeeklyBoxOfficeList.json?")
    Observable<MovieData> loadMovie(@Query("key") String key, @Query("targetDt") String targetDt);
}
