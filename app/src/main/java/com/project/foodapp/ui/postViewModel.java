package com.project.foodapp.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.project.foodapp.pojo.postModel;
import com.project.foodapp.data.PostClient;



import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class postViewModel extends ViewModel {
    MutableLiveData<List<postModel>>listMutableLiveData=new MutableLiveData<>();
    MutableLiveData<String > posts=new MutableLiveData<>();
    public void getPosts(){
        PostClient.getINSTANCE().getposts().enqueue(new Callback<List<postModel>>() {
            @Override
            public void onResponse(Response<List<postModel>> response, Retrofit retrofit) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                posts.setValue("err");

            }
        });

    }
}
