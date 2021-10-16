package com.project.foodapp.data;

import com.project.foodapp.data.postInterface;

import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import com.project.foodapp.pojo.postModel;

public class PostClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    private postInterface Postinterface;
    private static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        Postinterface = retrofit.create(postInterface.class);

    }

    public static PostClient getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }

    public Call<List<postModel>> getposts() {
        return Postinterface.getPost();

    }
}
