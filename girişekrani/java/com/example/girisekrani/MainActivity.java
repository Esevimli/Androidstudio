package com.example.girisekrani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editTextKAdi;
    EditText editTextSifre;
    SharedPreferences veri;//veri isminde sharedpreference nesnesini oluştur
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextKAdi=findViewById(R.id.editTextKadiana);
        editTextSifre=findViewById(R.id.editTextSifreAna);
        textView = findViewById(R.id.TextViewKayitAna);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //anaActivity nesneinden kayit activity nesnesine geçer
                //Intent : bir başa activity yada bir başka uygulama çalıştırmak istediğimizde intent sınıfını kullanırız
                Intent intent=new Intent(MainActivity.this,kayitActivity.class);//ana activity den kayit activity classına geçer
                startActivity(intent);//intenti çalıştırır
            }
        });
    }

    public void giriş(View view){
        String sifre=editTextSifre.getText().toString();
        String kadi=editTextKAdi.getText().toString();

        if(sifre.matches("") || kadi.matches("")){
            //alert
            Toast.makeText(MainActivity.this,"Kullanıcı Adi ya da Şifre boş!", Toast.LENGTH_LONG).show();
        }else {
            //girilen kullanıcı adı var mı? varsa girişActivity nesnesini aç
            veri=this.getSharedPreferences("com.example.girisekrani",MODE_PRIVATE);
            String gelenSifre= veri.getString(kadi,"YOK");

                if (gelenSifre.matches(sifre)){
                    //kadi ve sifre
                    Intent giriş=new Intent(MainActivity.this,girisActivity.class);
                    giriş.putExtra("kullanici",kadi);//extra olarak veri göndermek için kullanabilirsin
                    startActivity(giriş);
                }
                else {
                    //yanlış giriş ya da kayıt yok
                    Toast.makeText(this,"Kullanıcı Adi ya da Şifre Hatalı!",Toast.LENGTH_SHORT).show();
                }
        }

    }
}