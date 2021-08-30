package com.example.myapplication.Retrofit;

import com.example.myapplication.Config.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    private static Retrofit retrofit=null;

    public static Retrofit getClient(){

        String baseUrl="";

        if(retrofit==null){


            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            baseUrl="http://"+Config.getIp()+":8000/api/";
            retrofit= new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();

        }
            return  retrofit;
    }
}
