package com.example.googleanalyticsassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.UUID;

public class ClotheshActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    Button buttonDress;
    Button buttonShirts;
    Button buttonShoes;
    long timer1;
    long timer2;
    long result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothesh);
        buttonDress=findViewById(R.id.dresses);
        buttonShirts=findViewById(R.id.shirts);
        buttonShoes=findViewById(R.id.shoes);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        screenViewEvent("Clothes screen");
        timer1=System.currentTimeMillis();

        buttonDress.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view) {
                Intent intent=new Intent(getBaseContext(),ClotheshActivity.class);
                startActivity(intent);
                SelectC(UUID.randomUUID().toString(),buttonDress.getText().toString());

            }

        });

        buttonShirts.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view) {
                Intent intent=new Intent(getBaseContext(),ClotheshActivity.class);
                startActivity(intent);
                SelectC(UUID.randomUUID().toString(),buttonShirts.getText().toString());

            }

        });
        buttonShoes.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view) {
                Intent intent=new Intent(getBaseContext(),ClotheshActivity.class);
                startActivity(intent);
                SelectC(UUID.randomUUID().toString(),buttonShoes.getText().toString());

            }

        });

    }

    private void SelectC(String toString, String toString1) {
    }

      //  selectContent("","","");

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
    void  selectContent(String id,String name,String contentType) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

    }
    void screenViewEvent(String screenName){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "ClotheshActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);


    }
    }