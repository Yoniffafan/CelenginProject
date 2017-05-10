package me.yoniffafan.android.celengin;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndikaWahyu on 10/05/2017.
 */

public class MyListAdapter extends BaseAdapter {
    List<String> gambar, mimpi;
    List<Integer> total, progressValue;

    private static LayoutInflater layoutInflater = null;
    Context mContext;

    public MyListAdapter(List<String> gambar, List<String> mimpi, List<Integer> total, List<Integer> progressValue, Context mContext) {
        this.gambar = gambar;
        this.mimpi = mimpi;
        this.total = total;
        this.progressValue = progressValue;
        this.mContext = mContext;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mimpi.size();
    }

    @Override
    public Object getItem(int position) {
        return mimpi.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.card_list, null);
        Holder holder = new Holder();
        holder.gambar = (ImageView) view.findViewById(R.id.thumbnail);
        holder.mimpi = (TextView) view.findViewById(R.id.title);
        holder.total = (TextView) view.findViewById(R.id.harga);
        holder.progressBar = (ProgressBar) view.findViewById(R.id.progressbar);

        try {
            holder.gambar.setImageURI(Uri.parse(gambar.get(position)));
        } catch (Exception e) {
            holder.gambar.setImageResource(R.drawable.no_image);
        }

        holder.mimpi.setText(mimpi.get(position));
        holder.total.setText(String.valueOf(total.get(position)));
        try {
//            holder.progressBar.setProgress(50);
            holder.progressBar.setProgress(progressValue.get(position));
        } catch (Exception e){
            Log.e("E: ", e.getLocalizedMessage());
            holder.progressBar.setProgress(0);
        }
        return view;
    }

    public class Holder{
        TextView mimpi;
        TextView total;
        ImageView gambar;
        ProgressBar progressBar;
    }
}
