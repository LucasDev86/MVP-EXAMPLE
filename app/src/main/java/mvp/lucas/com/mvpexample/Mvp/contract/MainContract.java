package mvp.lucas.com.mvpexample.Mvp.contract;

import mvp.lucas.com.mvpexample.Model.MovieData;
import mvp.lucas.com.mvpexample.Mvp.base.BasePresenter;
import mvp.lucas.com.mvpexample.Mvp.base.BaseView;

/**
 * Created by rnj on 2016-10-14.
 */

public interface MainContract {

    interface View extends BaseView<MainContract.Presenter> {

        void showLoading();

        void hideLoading();

        void showError();

        void setMovie(MovieData md);

    }

    interface Presenter extends BasePresenter {

        void apiMovie();

    }

}
