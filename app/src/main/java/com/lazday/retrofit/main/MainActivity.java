package com.lazday.retrofit.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.lazday.retrofit.R;
import com.lazday.retrofit.network.Api;
import com.lazday.retrofit.network.ApiInterface;
import com.lazday.retrofit.network.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getMoviePopular();
    }

    private void getMoviePopular(){
        ApiInterface apiInterface = Api.getUrl().create(ApiInterface.class);
        Call<MainModel> call = apiInterface.getPopular( Constant.KEY, "en-US", "1");
        call.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {

                MainModel model = response.body();
                List<MainModel.Results> results = model.getResults();

                recyclerView.setAdapter(new MainAdapter(MainActivity.this, results));
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {

            }
        });
    }
}
