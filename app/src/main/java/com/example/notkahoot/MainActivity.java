package com.example.notkahoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;



    public class MainActivity extends AppCompatActivity {


        Button login, Signin;
        Image slika;
        public static Boolean status;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            login = findViewById(R.id.log_in);
            Signin = findViewById(R.id.Sign_in);



        }

        public void login(View v) {
            //Prijava
            status = true;

            Intent i = new Intent(MainActivity.this, Izradi_racun.class);
            startActivity(i);


        }


        public void Signin(View v) {

            //registriranje
            status = false;
            Intent i = new Intent(MainActivity.this, Izradi_racun.class);
            startActivity(i);

        }

    }
