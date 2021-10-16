package com.project.foodapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.foodapp.R;
import com.project.foodapp.pojo.postModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
postViewModel Postviewmodel;
RecyclerView RV;
postAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Postviewmodel= ViewModelProviders.of(this).get(postViewModel.class);
        Postviewmodel.getPosts();
        RV=findViewById(R.id.rv);
        RV.setLayoutManager(new LinearLayoutManager(this));

        Postviewmodel.listMutableLiveData.observe(this, new Observer<List<postModel>>() {
            @Override
            public void onChanged(List<postModel> postModels) {
                adapter=new postAdapter(postModels);
                RV.setAdapter(adapter);
            }
        });

        
    }
}