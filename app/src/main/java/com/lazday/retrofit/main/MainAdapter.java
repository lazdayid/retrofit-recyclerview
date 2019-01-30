package com.lazday.retrofit.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lazday.retrofit.R;
import com.lazday.retrofit.second.SecondActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MainModel.Results> results;
    private Context context;

    public MainAdapter(Context context, List<MainModel.Results> results) {
        this.results    = results ;
        this.context    = context ;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, int i) {
        final MainModel.Results result = results.get(i);

        viewHolder.txtTitle.setText( result.getTitle());
        viewHolder.txtShortDesc.setText( result.getRelease_date());

        viewHolder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra(context.getString(R.string.intent_title),
                        result.getTitle());
                intent.putExtra(context.getString(R.string.intent_backdrop_path),
                        result.getBackdrop_path());
                intent.putExtra(context.getString(R.string.intent_overview),
                        result.getOverview());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtShortDesc;
        Button btnMore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtShortDesc = itemView.findViewById(R.id.txtShortDesc);
            btnMore = itemView.findViewById(R.id.btnMore);
        }
    }
}
