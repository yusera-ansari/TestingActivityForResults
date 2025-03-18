package com.example.activityforresultapitest;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {
MaterialButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_second);
     btn = findViewById(R.id.send_data_to_intent_btn);
     btn.setOnClickListener(
             (view)->{
                 Intent intent = new Intent();
                 intent.putExtra("text", "this has been sent from the intent");
                 setResult(101,intent);
                 super.getOnBackPressedDispatcher().onBackPressed();
             }
     );
    }
}