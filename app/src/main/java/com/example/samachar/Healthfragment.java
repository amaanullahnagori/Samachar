package com.example.samachar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Healthfragment extends Fragment {
    String api="6c052c42ae834af0a4edc5ca35d50bef";
    Adapter adapter;
    ArrayList<ModelClass> modelClassArrayList;
    String country="in";
    private RecyclerView recyclerViewofHealth;
    private  String category="health";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.healthfragment,null);
        recyclerViewofHealth=v.findViewById(R.id.recyclerviewOfhealth);
        modelClassArrayList=new ArrayList<>();
        recyclerViewofHealth.setAdapter(adapter);
        findNews();;
    return v;}
    private void findNews() {
        ApiUtilities.getInstance().getCategoryNews(country,category,100,api).enqueue(new Callback<NewsCall>() {
            @Override
            public void onResponse(Call<NewsCall> call, Response<NewsCall> response) {
                if (response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsCall> call, Throwable t) {

            }
        });
    }
}

