package com.example.demoretrofit;

import android.app.Service;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.demoretrofit.Data.Model.Example;
import com.example.demoretrofit.Data.Model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private com.example.demoretrofit.Service service;
    private AnswerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service= Apiutils.getService();
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerviewhome);
        mAdapter =new AnswerAdapter(new ArrayList<Result>(0), this, new AnswerAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {

            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }
    public void loadAnswers() {
        service.getAnswers().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.isSuccessful()) {
                    mAdapter.updateAnswers(response.body().getResult());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }

}
