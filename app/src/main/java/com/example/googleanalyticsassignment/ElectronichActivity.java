package com.example.googleanalyticsassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.UUID;

public class ElectronichActivity extends AppCompatActivity {
    Button buttonLaps;
    Button buttonTv;
    Button buttonIphone;
    long timer1;
    long timer2;
    long result;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electronich);
        buttonLaps=findViewById(R.id.laptop);
        buttonTv=findViewById(R.id.smart);
        buttonIphone=findViewById(R.id.iphone);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        screenViewEvent("Electronic screen");

        timer1=System.currentTimeMillis();

        buttonLaps.setOnClickListener(new View.OnClickListener(){

        public void onClick (View view) {
            Intent intent=new Intent(getBaseContext(),ClotheshActivity.class);
            startActivity(intent);
            SelectC(UUID.randomUUID().toString(),buttonLaps.getText().toString());

        }

    });
        buttonTv.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view) {
                Intent intent=new Intent(getBaseContext(),ClotheshActivity.class);
                startActivity(intent);
                SelectC(UUID.randomUUID().toString(),buttonTv.getText().toString());

            }

        });
        buttonIphone.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view) {
                Intent intent=new Intent(getBaseContext(),ClotheshActivity.class);
                startActivity(intent);
                SelectC(UUID.randomUUID().toString(),buttonIphone.getText().toString());

            }

        });


}

    private void SelectC(String toString, String toString1) {
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
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "ElectronichActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);


    }
}