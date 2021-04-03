package com.example.googleanalyticsassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button buttonFood;
Button buttonClothes;
Button buttonElectronic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFood=findViewById(R.id.button1);
        buttonClothes=findViewById(R.id.button2);
        buttonElectronic=findViewById(R.id.button3);

}
}