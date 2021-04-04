package com.example.googleanalyticsassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
Button buttonFood;
Button buttonClothes;
Button buttonElectronic;
long timer1;
long timer2;
long result;
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFood=findViewById(R.id.button1);
        buttonClothes=findViewById(R.id.button2);
        buttonElectronic=findViewById(R.id.button3);

     timer1=System.currentTimeMillis();

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        screenViewEvent("main screen");
        buttonFood.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view) {
                Intent intent=new Intent(getBaseContext(),FoodhActivity.class);
                startActivity(intent);
                SelectC(UUID.randomUUID().toString(),buttonFood.getText().toString());
            }

        });
        buttonClothes.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view) {
                Intent intent=new Intent(getBaseContext(),FoodhActivity.class);
                startActivity(intent);
                SelectC(UUID.randomUUID().toString(),buttonClothes.getText().toString());

            }

        });
        buttonElectronic.setOnClickListener(new View.OnClickListener(){

            public void onClick (View view) {
                Intent intent=new Intent(getBaseContext(),FoodhActivity.class);
                startActivity(intent);
                SelectC(UUID.randomUUID().toString(),buttonElectronic.getText().toString());

            }

        });

       // selectContent("","","");
      //  xEvent("2164","");
}

    private void SelectC(String toString, String toString1) {
    }

    void  selectContent(String id,String name,String contentType) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

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
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);


    }
    void xEvent (String id,String name){

        Bundle xEventBundle =new Bundle();
        xEventBundle.putString("id",id);
        xEventBundle.putString("name",name);
        mFirebaseAnalytics.logEvent("xEvent",xEventBundle);


    }
}