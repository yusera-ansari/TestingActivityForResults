package com.example.activityforresultapitest;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    MaterialButton mainButton;
    ActivityResultLauncher<String[]> launcher =   registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(),

                 ( isGranted) ->{
                     Log.d("launcher","Permission granted: "+ isGranted);

                }
            );
    ActivityResultLauncher<Intent> getResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            (result)->{
                int code=result.getResultCode();
                Intent intent =result.getData();
                if(code==101 &&  intent!=null){
                 String text=   intent.getStringExtra("text");
                 Log.d("text",""+ text);
                    Toast.makeText(this, text, Toast.LENGTH_LONG).show();
                }
            }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launcher.launch( new String[]{Manifest.permission.POST_NOTIFICATIONS});

        mainButton = findViewById(R.id.main_btn);
        mainButton.setOnClickListener((view)->{
           Intent intent = new Intent(this, SecondActivity.class);
           getResult.launch(intent);
        });
    }
}