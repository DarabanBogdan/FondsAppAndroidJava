package com.example.myapplication.Service;


import com.example.myapplication.Domain.Account;
import com.example.myapplication.Domain.Transaction;
import com.example.myapplication.Domain.User;
import com.example.myapplication.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private User user;
    private ApiInterface apiInterface;



    Iterable<Account> temp;
    private int code=400;

    public Service(User user, ApiInterface apiInterface) {
        this.user=user;
        this.apiInterface=apiInterface;
    }
    public int AddAccount(Account account) throws IOException {

        Call<Void> call=apiInterface.AddAccount(account, user.getToken());
       Response response = call.execute();

        return response.code();

    }

    public Iterable<Account> findAllAccounts() throws IOException {


        temp=new ArrayList<>();

        code=400;
        Call<List<Account>> call=apiInterface.GetAllAccount(user.getToken());


        Response<List<Account>> response = call.execute();
        temp=response.body();
        code=response.code();
        return temp;
    }

    public int DeleteAccount(int idAccount) throws IOException {
        Call<Void> call=apiInterface.DeleteAccount(idAccount, user.getToken());
        Response response = call.execute();

        return response.code();
    }

    public int UpdateAccount(Account account) throws IOException {

        Call<Void> call=apiInterface.UpdateAccount(account.getId(),account, user.getToken());
        Response response = call.execute();

        return response.code();
    }

    public Iterable<Transaction> findAllTransaction(int id) throws IOException {

        Iterable<Transaction> tempTrasaction=new ArrayList<>();

        code=400;
        Call<List<Transaction>> call=apiInterface.GetAllTransaction(id,user.getToken());


        Response<List<Transaction>> response = call.execute();
        tempTrasaction=response.body();
        code=response.code();
        return tempTrasaction;
    }

    public int AddTransaction(Transaction transaction) throws IOException {

        Call<Void> call=apiInterface.AddTransaction(transaction, user.getToken());
        Response response = call.execute();

        return response.code();


    }

    public int UpdateTransaction(Transaction transaction) throws IOException {

        Call<Void> call=apiInterface.UpdateTransaction(transaction.getId(),transaction, user.getToken());
        Response response = call.execute();

        return response.code();
    }
}
