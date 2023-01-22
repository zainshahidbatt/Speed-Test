package com.example.speedtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.speedtest.R;
import com.example.speedtest.models.DataInfo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    public List<DataInfo> dataList;
    Context context;

    public DataAdapter(Context context, List<DataInfo> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        DataInfo di = dataList.get(position);
        SimpleDateFormat formatter = new SimpleDateFormat(context.getString(R.string.date_format));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(di.getDate());
        holder.vDate.setText(formatter.format(calendar.getTime()));
        holder.vWifi.setText(String.valueOf(di.getPing()));
        holder.vMobile.setText(String.valueOf(di.getDownload()));
        holder.vTotal.setText(String.valueOf(di.getUpload()));
        if (position % 2 == 0) {
            holder.card_view.setBackgroundColor(context.getResources().getColor(R.color.white_10));
        } else {
            holder.card_view.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        }
    }

    public void updateData(List<DataInfo> temp) {
        this.dataList = temp;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {
        TextView vDate;
        TextView vWifi;
        TextView vMobile;
        TextView vTotal;
        ConstraintLayout card_view;

        public DataViewHolder(View itemView) {
            super(itemView);
            vDate = itemView.findViewById(R.id.id_date);
            vWifi = itemView.findViewById(R.id.id_wifi);
            vMobile = itemView.findViewById(R.id.mobile);
            vTotal = itemView.findViewById(R.id.total);
            card_view = itemView.findViewById(R.id.card_view);
        }
    }
}
