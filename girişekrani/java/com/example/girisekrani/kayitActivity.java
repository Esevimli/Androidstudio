package com.example.girisekrani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class kayitActivity extends AppCompatActivity {

    EditText editTextKAdi;//değişken oluşturuyo
    EditText editTextSifre;
    SharedPreferences sharedPreferences;//sharedpreferences nesnesini üretir sharedpreferences dosyaya veri eklemek için kullanılabilir
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        editTextKAdi=findViewById(R.id.editTextKAdiKayit);//oluşturulan değişkeni gönderilen id ile bağlıyo
        editTextSifre=findViewById(R.id.editTextSifreKayit);
    }
    public void kayit(View view){
        String kadi=editTextKAdi.getText().toString();
        String sifre=editTextSifre.getText().toString();
        if(!kadi.matches("")&& !sifre.matches(""))//!(ünlem değilse anlamına getirir)kadi eşit(matches) değilse boşluk ve sifre boşluğa eşit değilse koşulları
        {
            //kayıt
            sharedPreferences=this.getSharedPreferences("com.example.girisekrani",MODE_PRIVATE);//com lu satır package yani bu uygulamanın ismi en tepede package com.example.girisekrani; şeklinde yazıyo bakarsan
            // mode private sadece bu uygulamada kullanılabilir anlamına gelir
            //bu şekilde sharedpreferences(basit verileri depolayabiliceğin bi nesne)oluşturabilirsin
            sharedPreferences.edit().putString(kadi,sifre).apply();//veri ekleme böyle yapılır kadi anahtahdır veriyi alıren kadi ni yazarak alırsın sifrede yanında gelir mainactivity de olduğu gibi
            Toast.makeText(kayitActivity.this,"Kayıt işlemi başarıyla gerçekleştirildi", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(kayitActivity.this,MainActivity.class);
            startActivity(i);
        }
        else{

            Toast.makeText(kayitActivity.this,"Kullanıcı Adi ya da Şifre Hatalı", Toast.LENGTH_SHORT).show();//kayitactivity de kullanıcı adı yada şifre hatalı alertini gösterir toast bu uyarılarda kullanılıyor
        }
    }
}