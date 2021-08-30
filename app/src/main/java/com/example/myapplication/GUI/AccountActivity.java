package com.example.myapplication.GUI;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Config.Config;
import com.example.myapplication.Domain.Account;
import com.example.myapplication.Domain.User;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.ApiInterface;
import com.example.myapplication.Service.Service;

import java.io.IOException;
import java.util.List;

public class AccountActivity extends AppCompatActivity {

    private Service service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        service=new Service((User) getIntent().getSerializableExtra("User"),
                (ApiInterface) getIntent().getSerializableExtra("ApiInteraface"));

        try {
            showAccounts();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void showAccounts() throws IOException {


        List<Account> listAccounts= (List<Account>) service.findAllAccounts();
        CustomAdapter adapter = new CustomAdapter (AccountActivity.this, listAccounts);
        ListView listView =findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }
}
