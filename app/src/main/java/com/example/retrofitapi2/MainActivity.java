package com.example.retrofitapi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import Adapter.MyRecyclerView;
import Model.Example;
import Model.MovieResponse;
import Rest.ApiClient;
import Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private String API = "89f6216e13a1dea4c3e5967ddb7004e2";
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMovieList();
    }

    private void getMovieList() {
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = service.getMovies(API);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Example> moview = response.body().getResults();
                linearLayoutManager  = new LinearLayoutManager(MainActivity.this);
                recyclerView = findViewById(R.id.myRecyclerView);
                recyclerView.setLayoutManager(linearLayoutManager);
                MyRecyclerView myRecyclerView = new MyRecyclerView(moview);
                recyclerView.setAdapter(myRecyclerView);
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}
