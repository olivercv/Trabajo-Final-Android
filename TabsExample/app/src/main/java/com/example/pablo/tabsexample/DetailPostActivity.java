package com.example.pablo.tabsexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailPostActivity extends AppCompatActivity {

    private TextView titulo;
    private TextView contenido;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        titulo = (TextView) findViewById(R.id.title);
        contenido = (TextView) findViewById(R.id.content);
        imagen = (ImageView) findViewById(R.id.image);

        SharedPreferences sharedPreferences = this.getSharedPreferences(
                this.getString(R.string.app_name),
                Context.MODE_PRIVATE);


        titulo.setText( sharedPreferences.getString("titulo", "Sin titulo"));
        contenido.setText(sharedPreferences.getString("contenido", "Sin contenido"));
        //imagen.setImageURI(Uri.parse(sharedPreferences.getString("urlimagen", "")));
        Glide.with(getApplicationContext()).load(Uri.parse(sharedPreferences.getString("urlimagen", ""))).into(imagen);


    }

    public void backListViewPost(View view) {
        SharedPreferences preferences = getSharedPreferences(
                getString(R.string.app_name), MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("titulo");
        editor.remove("contenido");
        editor.remove("urlimagen");
        editor.commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
