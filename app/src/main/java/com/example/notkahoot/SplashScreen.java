package com.example.notkahoot;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
 ImageView logo;
 Animation logoanim;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo = findViewById(R.id.logoo);
    logoanim = AnimationUtils.loadAnimation(this,R.anim.splashscreenanimation);

    logo.setAnimation(logoanim);





     new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
                 Intent i=new Intent(SplashScreen.this,Izradi_racun.class);
                 startActivity(i);
                 finish();
             }
     },3000); // POPRAVIOTI KASNIJE

    }
}