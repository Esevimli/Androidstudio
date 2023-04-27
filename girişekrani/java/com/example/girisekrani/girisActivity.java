package com.example.girisekrani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class girisActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        Intent girişal=getIntent();
        String gelenkullanici=girişal.getStringExtra("kullanici");
        textView=findViewById(R.id.textViewGiriş);
        textView.setText("Hoşgeldin :"+gelenkullanici);
    }
}