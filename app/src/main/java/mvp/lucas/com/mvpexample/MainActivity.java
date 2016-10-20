package mvp.lucas.com.mvpexample;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import mvp.lucas.com.mvpexample.Model.ListData;
import mvp.lucas.com.mvpexample.Model.MovieData;
import mvp.lucas.com.mvpexample.Mvp.Adapter.LucasRecyclerViewAdpater;
import mvp.lucas.com.mvpexample.Mvp.Adapter.MovieRecyclerViewAdapter;
import mvp.lucas.com.mvpexample.Mvp.base.MvpBaseActivity;
import mvp.lucas.com.mvpexample.Mvp.contract.MainContract;
import mvp.lucas.com.mvpexample.Mvp.presenter.MainPresenter;


public class MainActivity extends MvpBaseActivity implements MainContract.View {

    @Bind(R.id.swiprefreshlayout)
    SwipeRefreshLayout mSwipRefreshLayout;
    @Bind(R.id.list)
    android.support.v7.widget.RecyclerView mRecyclerView;
    @Bind(R.id.txt_day)
    TextView txtDay;

    private MainPresenter presenter = null;
    private MovieRecyclerViewAdapter movieAdapter = null;
    private List<ListData> data = null;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate() {
        initRecycler();
        presenter = new MainPresenter(this, this);
        presenter.apiMovie();

        mSwipRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.apiMovie();
            }
        });
    }

    private void initRecycler() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showLoading() {
        mSwipRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mSwipRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "네트워크 문제", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setMovie(MovieData mData) {

        data = mData.getBoxOfficeResult().getWeeklyBoxOfficeList();

        Log.d("lucas", "movieData NAME == " + data.get(0).getMovieNm());

        txtDay.setText("(" + mData.getBoxOfficeResult().getYearWeekTime().substring(0, 4) + "년 " + mData.getBoxOfficeResult().getYearWeekTime().substring(4) + "주차)");

        if (movieAdapter == null) {

            movieAdapter = new MovieRecyclerViewAdapter(MainActivity.this, data);
            movieAdapter.setOnItemClickListener(new LucasRecyclerViewAdpater.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                }
            });

            mRecyclerView.setAdapter(movieAdapter);

        } else {
            movieAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

}
