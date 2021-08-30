package com.example.myapplication.Config;

import android.content.Context;

import com.example.myapplication.GUI.MainActivity;
import com.example.myapplication.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public  class Config {

    public static Context context;

    public Config(Context context){
        this.context=context;
    }
    public static String getIp( ){

        String FILENAME = "config";
        String data="ss";

        FileInputStream fis= null;
        try {
            fis = context.openFileInput(FILENAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            StringBuffer fileContent = new StringBuffer("");

            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }
            data= String.valueOf(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;

    }

    public static void setIp(String ip) throws FileNotFoundException {

        String FILENAME = "config";
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(FILENAME, context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(ip.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

