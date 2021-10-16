package com.project.foodapp.data;

import java.util.List;
import com.project.foodapp.pojo.postModel;
import retrofit.Call;
import retrofit.http.GET;

public interface postInterface {
    @GET("posts")
    Call<List<postModel>>getPost();
}
