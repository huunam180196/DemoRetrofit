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
import java.util.ArrayList;
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
    private ArrayList<Result> resultsList = new ArrayList<>();

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

        service.getAnswers("Bearer Ve7enip-XkylygJ7e1DX-oL23B037rRTG6XB").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    js=response.body().string();
                    JSONObject obj = new JSONObject(js);
                    String resultObject= String.valueOf(obj.getJSONArray("result"));

                    JSONArray jsonArray=new JSONArray(resultObject);


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonobject = jsonArray.getJSONObject(i);

                        String id = jsonobject.getString("id");
                        String first_name = jsonobject.getString("first_name");
                        String lastName =jsonobject.getString("lastName");
                        String email =jsonobject.getString("email");
                        String phone =jsonobject.getString("phone");
                        String website =jsonobject.getString("website");

                        addData(id,first_name,lastName,email,phone,website);
                    }

//                    textView=(TextView)findViewById(R.id.tv_name);
//                    for (int j=0;j<jsonArray.length();j++){
//                        jsonArray.getJSONObject(j);
//
//                    }

                } catch (IOException | JSONException e) {
                    Log.d("erorrrrrr ",e.getMessage());
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
    public void addData(String id,String first_name,String lastName,String email,String phone,String website){
        Result result=new Result(id,first_name,lastName,email,phone,website);
        resultsList.add(result);
    }
//public void ParseJSON{
//
//    }

}
