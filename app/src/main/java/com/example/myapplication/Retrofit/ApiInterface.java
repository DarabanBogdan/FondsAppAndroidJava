package com.example.myapplication.Retrofit;


import com.example.myapplication.Domain.Account;
import com.example.myapplication.Domain.Transaction;
import com.example.myapplication.Domain.User;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ApiInterface {

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("User/login")
    Call<String>Login(@Body User user);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("User")
    Call<Void>SignUp(@Body User user);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("Account")
    Call<Void>AddAccount(@Body Account account, @Header("Authorization") String authHeader);


    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("User/AllAccounts")
    Call<List<Account>>GetAllAccount(@Header("Authorization") String authHeader);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @DELETE("Account/{id}")
    Call<Void> DeleteAccount(@Path("id") int id, @Header("Authorization") String authHeader);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @PUT("Account/{id}")
    Call<Void> UpdateAccount(@Path("id") int id, @Body Account account, @Header("Authorization") String authHeader);


    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @GET("Account/AllTransaction/{id}")
    Call<List<Transaction>>GetAllTransaction(@Path("id") int id, @Header("Authorization") String authHeader);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST("Transaction")
    Call<Void>AddTransaction(@Body Transaction transaction, @Header("Authorization") String authHeader);


    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @PUT("Transaction/{id}")
    Call<Void> UpdateTransaction(@Path("id") int id, @Body Transaction transaction, @Header("Authorization") String authHeader);

}
