package com.example.myapplication.GUI;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Config.Config;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.ApiInterface;

import java.io.FileNotFoundException;

public class SettingsIpActivity extends AppCompatActivity {

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_ip);
        TextView showIp=(TextView) findViewById(R.id.ipShowText);
        showIp.setText(Config.getIp());
    }

    public void UpdateIp(View view) throws FileNotFoundException {
        EditText text=(EditText) findViewById(R.id.ipTextField);
       Config.setIp(text.getText().toString());
        TextView showIp=(TextView) findViewById(R.id.ipShowText);
        showIp.setText(Config.getIp());
        text.setText("");


    }



}
