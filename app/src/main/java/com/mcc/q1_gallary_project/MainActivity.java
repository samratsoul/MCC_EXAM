package com.mcc.q1_gallary_project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.mcc.q1_gallary_project.Adapter.ImageItemViewAdapter;
import com.mcc.q1_gallary_project.Interface.ImageApi;
import com.mcc.q1_gallary_project.Pojo.Contentfilelist;
import com.mcc.q1_gallary_project.Pojo.Contentfilelist_;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private List<Contentfilelist_> itemViewList;
    private ImageItemViewAdapter imageItemViewAdapter;
    private ProgressBar graphprogressbar;
    private RecyclerView recyclerView;
    StaggeredGridLayoutManager stagaggeredGridLayoutManager;
    private static final String TAG = "MainActivity";

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
                intent.putExtra(Constant.IMAGE_SRC,itemViewList.get(position).getIMG());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(imageItemViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        //Test();

         fetchImage();
    }

    public void fetchImage() {

        Retrofit retrofit = NetworkClient.getRetrofitClient();
        /*
        The main purpose of Retrofit is to create HTTP calls from the Java interface based on the annotation associated with each method. This is achieved by just passing the interface class as parameter to the create method
        */
        ImageApi imageApi = retrofit.create(ImageApi.class);
        /*
        Invoke the method corresponding to the HTTP request which will return a Call object. This Call object will used to send the actual network request with the specified parameters
        */
        Call<Contentfilelist> call = imageApi.getImageDetails("9", "35");
        /*
        This is the line which actually sends a network request. Calling enqueue() executes a call asynchronously. It has two callback listeners which will invoked on the main thread
        */
        call.enqueue(new Callback<Contentfilelist>() {
            @Override
            public void onResponse(@NonNull Call<Contentfilelist> call, @NonNull Response<Contentfilelist> response) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response.isSuccessful()) {
                    Log.d("XXX", response.body().getContentfilelist().size()+"");
                   itemViewList.addAll(response.body().getContentfilelist());
                   imageItemViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Contentfilelist> call, Throwable t) {
                /*
                Error callback
                */

                Log.d("XXX","Error");
            }
        });
    }

    public void Test(){
        Contentfilelist_ imagePojo= new Contentfilelist_();//("https://homepages.cae.wisc.edu/~ece533/images/airplane.png");
        imagePojo.setIMG("https://homepages.cae.wisc.edu/~ece533/images/airplane.png");
        itemViewList.add(imagePojo);
        itemViewList.add(imagePojo);
        itemViewList.add(imagePojo);
        itemViewList.add(imagePojo);
        itemViewList.add(imagePojo);
        itemViewList.add(imagePojo);

        imageItemViewAdapter.notifyDataSetChanged();

    }
}
