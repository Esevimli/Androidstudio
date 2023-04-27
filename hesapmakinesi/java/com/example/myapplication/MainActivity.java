package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);

    }

boolean ilkMi=true;
    public void rakamTiklama(View view){
        //[0-9] butonları tıklanınca bu event çalışacak
        String metin= (String) textView.getText();
        if(ilkMi){
            metin="";
            ilkMi=false;
        }

        switch (view.getId()){
            case R.id.btn0:
                metin=metin+"0";
                break;
            case R.id.btn1:
                metin=metin+"1";
                break;
            case R.id.btn2:
                metin=metin+"2";
                break;
            case R.id.btn3:
                metin=metin+"3";
                break;
            case R.id.btn4:
                metin=metin+"4";
                break;
            case R.id.btn5:
                metin=metin+"5";
                break;
            case R.id.btn6:
                metin=metin+"6";
                break;
            case R.id.btn7:
                metin=metin+"7";
                break;
            case R.id.btn8:
                metin=metin+"8";
                break;
            case R.id.btn9:
                metin=metin+"9";
                break;


        }

        textView.setText(""+metin);

    }

    ArrayList<Double> sayilar=new ArrayList<>();
    int sayi1=0;
    int sayi2=0;
    char islem;
    public void işlemYap(View view){
        sayilar.add(Double.parseDouble((String)textView.getText()));

        ilkMi=true;

        switch (view.getId()){
            case R.id.btnTopla:
                islem='+';
                break;
            case R.id.btnCikar:
                islem='-';
                break;
            case R.id.btnCarp:
                islem='*';
                break;
            case R.id.btnbol:
                islem='/';
                break;
        }
    }

    public void Temizle(View view){
        textView.setText("0");
        sayilar.clear();
    }

    public void işlemSonuc(View view){
        sayilar.add(Double.parseDouble((String)textView.getText()));
        double sonuc=sayilar.get(0);
        ilkMi=true;
        if(islem=='+'){
            for(int i = 1;i< sayilar.size();i++){
                sonuc+=sayilar.get(i);
            }
            textView.setText(""+sonuc);
        }

        else if(islem=='-'){
            for(int i = 1;i< sayilar.size();i++){
                sonuc= sonuc-sayilar.get(i);
            }
            textView.setText(""+sonuc);
        }
        else if(islem=='*'){
            for(int i = 1;i< sayilar.size();i++){
                sonuc= sonuc*sayilar.get(i);
            }
            textView.setText(""+sonuc);
        }
        if(islem=='/'){
            for(int i = 1;i< sayilar.size();i++){
                sonuc= sonuc/sayilar.get(i);
            }
            textView.setText(""+sonuc);
        }

        sayilar.clear();
    }
}