package mvp.lucas.com.mvpexample.Mvp.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by rnj on 2016-08-11.
 */
public abstract class MvpBaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        ButterKnife.bind(this);

        onCreate();
    }


    @StringRes
    protected int getToolbarTitle() {
        return 0;
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract void onCreate();


}
