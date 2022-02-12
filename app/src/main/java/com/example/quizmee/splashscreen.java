package com.example.quizmee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        FirebaseAuth auth=FirebaseAuth.getInstance();
        Thread thread=new Thread(){

            public void run(){
                try {
                    sleep(2000);

                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if(auth.getCurrentUser()!=null){
                        startActivity(new Intent(splashscreen.this,MainActivity.class));
                        finish();
                    }
                    else {
                        startActivity(new Intent(splashscreen.this,LoginActivity.class));
                        finish();
                    }
                }
            }
        };
        thread.start();
    }
}