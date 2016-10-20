package mvp.lucas.com.mvpexample.Mvp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import mvp.lucas.com.mvpexample.Model.ListData;
import mvp.lucas.com.mvpexample.R;

/**
 * Created by rnj on 2016-10-14.
 */

public class MovieRecyclerViewAdapter extends LucasRecyclerViewAdpater<ListData, MovieRecyclerViewAdapter.GoodsListViewHolder> {

    public MovieRecyclerViewAdapter(Activity activity) {
        super(activity);
    }

    public MovieRecyclerViewAdapter(Context context, List<ListData> arrayList) {
        super(context, arrayList);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.row_movie, parent, false);
        return new GoodsListViewHolder(view);
    }

    @Override
    public void onBindView(final GoodsListViewHolder holder, final int position) {

        holder.getTxt_rank().setText(position + 1 + "");
        holder.getTxt_nm().setText(arrayList.get(position).getMovieNm());
        holder.getTxt_audi().setText(setCommaNumber(arrayList.get(position).getAudiCnt()) + "명");
    }

    public class GoodsListViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_rank;
        private TextView txt_nm;
        private TextView txt_audi;


        public GoodsListViewHolder(View itemView) {
            super(itemView);
            txt_rank = (TextView) itemView.findViewById(R.id.txt_rank);
            txt_nm = (TextView) itemView.findViewById(R.id.txt_nm);
            txt_audi = (TextView) itemView.findViewById(R.id.txt_cnt);
        }

        public TextView getTxt_rank() {
            return txt_rank;
        }

        public TextView getTxt_nm() {
            return txt_nm;
        }

        public TextView getTxt_audi() {
            return txt_audi;
        }
    }

    public static String setCommaNumber(String num) {

        int inValues = Integer.parseInt(num);
        DecimalFormat Commas = new DecimalFormat("#,###");
        String result_int = (String) Commas.format(inValues);
        return result_int;

    }

}
