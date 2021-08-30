package com.example.myapplication.GUI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Config.Config;
import com.example.myapplication.Domain.Account;
import com.example.myapplication.Domain.User;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.ApiClient;
import com.example.myapplication.Retrofit.ApiInterface;
import com.example.myapplication.Service.Service;

import java.io.IOException;
import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        new Config(this);
        apiInterface= ApiClient.getClient().create(ApiInterface.class);

    }

    public void SettingsClick(View view) {
        Intent intent = new Intent(this,SettingsIpActivity.class);
        this.startActivity(intent);
    }
    public void RegisterShow(View view){

        Intent intent = new Intent(this,RegisterActivity.class);
        this.startActivity(intent);

    }
    public void AccountsShow(View view){

        final Intent intent = new Intent(this, AccountActivity.class);
        EditText text=(EditText) findViewById(R.id.emailTextField);
        String email=text.getText().toString();
        text=(EditText) findViewById(R.id.passwordTextField);
        String password=text.getText().toString();
        final User user =new User(email,password);


        //attempt login

        Call<String> call=apiInterface.Login(user);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                    if(response.code()==200){
                        user.setToken("Bearer "+response.body());

                    }
                    else {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("Email or password dont match!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }




            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {


                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage(String.valueOf(t));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(user.getToken());
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        token is no updated
        if(!user.getToken().equals("null")){

            intent.putExtra("User", user);
            intent.putExtra("ApiInterface", (Serializable) apiInterface);
            this.startActivity(intent);
        }




    }

}
