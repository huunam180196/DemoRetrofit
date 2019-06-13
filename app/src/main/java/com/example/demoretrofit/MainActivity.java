package com.example.demoretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.demoretrofit.Data.Model.Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Service service;
    private AnswerAdapter mAdapter;
    private String js;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_recyclerviewhome);

        service=Apiutils.getService();

//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewhome);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.setHasFixedSize(true);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        mRecyclerView.addItemDecoration(itemDecoration);

        loadAnswers();

    }

    public void loadAnswers() {

        service.getAnswers("Bearer 3DWIXBZtq64ZxZJv1rgfViqu-C9PjjNttYPf").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    js=response.body().string();
                    Log.d("11111111111 ",js);
                    JSONObject obj = new JSONObject(js);
                    Log.d("11111111111 ", String.valueOf(obj.getJSONArray("result")));

                    String resultObject= String.valueOf(obj.getJSONArray("result"));

                    JSONArray jsonArray=new JSONArray(resultObject);
                    int i=jsonArray.length();

                    Log.d("22222222222 ", obj.getString("result"));
                    Log.d("11111111111 ", String.valueOf(i));

                    textView=(TextView)findViewById(R.id.tv_name);

                    List<Result>list;
                    for (int j=0;j<jsonArray.length();j++){

                    }




                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


//        RTFResponse rtfResponse = Apiutils.getService();
//
//        Call<List<Result>> call = rtfResponse.getLstresul("Bearer m1hq-NC3hsdERl2e9ELBLSq3xW1-s9MjbnO6");
//        call.enqueue(new Callback<List<Result>>() {
//            @Override
//            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
//                resultList = response.body();
//                Log.d("onResponse: ", String.valueOf(resultList.get(0)));
//            }
//
//            @Override
//            public void onFailure(Call<List<Result>> call, Throwable t) {
//                Log.d("onResponse: ", t.getMessage());
//            }
//        });




    }
//public void ParseJSON{
//
//    }

}
