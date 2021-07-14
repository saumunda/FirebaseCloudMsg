package com.leosword.saurabh.msons;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class ActivitySplash extends Activity {

    final private static int SPLASH_TIME_OUT = 7000;
    TextView appname;
    //to get user session data
  //  private UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

     //   session =new UserSession(SplashActivity.this);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.seasrn);

         appname= findViewById(R.id.appname);
        appname.setTypeface(typeface);

        YoYo.with(Techniques.Bounce)
                .duration(7000)
                .playOn(findViewById(R.id.logo));

        YoYo.with(Techniques.FadeInUp)
                .duration(5000)
                .playOn(findViewById(R.id.appname));

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent intent = new Intent(getBaseContext(), Welcome.class);
                startActivity(intent);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}