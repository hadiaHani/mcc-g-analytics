package com.example.googleanalyticsassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.UUID;

public class ShoeshActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    long timer1;
    long timer2;
    long result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoesh);
        timer1=System.currentTimeMillis();


        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        screenViewEvent("shoes screen");
    }
    protected void onDestroy() {
        timer2=System.currentTimeMillis();
        timeEvent(timer1,timer2);
        super.onDestroy();
    }

    void  timeEvent(long time1, long time2){
        result=(time2- time1);
        Bundle params = new Bundle();
        params.putString("id", UUID.randomUUID().toString());
        params.putLong("time_spend",result);
        mFirebaseAnalytics.logEvent("timer",params);
    }
    void screenViewEvent(String screenName){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "ShoeshActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);


    }
}