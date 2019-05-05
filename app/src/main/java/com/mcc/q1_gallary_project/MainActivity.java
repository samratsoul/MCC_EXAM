package com.mcc.q1_gallary_project;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mcc.q1_gallary_project.Adapter.ImageItemViewAdapter;
import com.mcc.q1_gallary_project.Interface.ImageApi;
import com.mcc.q1_gallary_project.Interface.QuoteOfTheDayRestService;
import com.mcc.q1_gallary_project.Pojo.ImagePojo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImagePojo> itemViewList;
    private ImageItemViewAdapter imageItemViewAdapter;
    private ProgressBar graphprogressbar;
    private RecyclerView recyclerView;
    StaggeredGridLayoutManager stagaggeredGridLayoutManager;
    private TextView textViewQuoteOfTheDay;
    private Button buttonRetry;

    private static final String TAG = "MainActivity";
    private QuoteOfTheDayRestService service;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        graphprogressbar = findViewById(R.id.progressbar);
        graphprogressbar.setVisibility(View.GONE);
        stagaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(stagaggeredGridLayoutManager);
        itemViewList = new ArrayList<>();
        imageItemViewAdapter = new ImageItemViewAdapter(itemViewList, this);
        imageItemViewAdapter.setOnItemClickListhener(new ImageItemViewAdapter.ClickListhener() {
            @Override
            public void ItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this,ImageViewActivity.class);
                intent.putExtra(Constant.IMAGE_SRC,itemViewList.get(position).getImagePath());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(imageItemViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        //fetchImage();
    }

    public void fetchImage() {

        Retrofit retrofit = NetworkClient.getRetrofitClient();
        /*
        The main purpose of Retrofit is to create HTTP calls from the Java interface based on the annotation associated with each method. This is achieved by just passing the interface class as parameter to the create method
        */
        ImageApi weatherAPIs = retrofit.create(ImageApi.class);
        /*
        Invoke the method corresponding to the HTTP request which will return a Call object. This Call object will used to send the actual network request with the specified parameters
        */
        Call call = weatherAPIs.getImageDetails("9", "35");
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response.body() != null) {
                    Log.d("XXX", response.toString());
                   // ImagePojo imagePojo = (ImagePojo) response.body();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                /*
                Error callback
                */
            }
        });
    }
}
