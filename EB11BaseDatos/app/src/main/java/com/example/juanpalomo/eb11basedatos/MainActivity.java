package com.example.juanpalomo.eb11basedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrar(View v){
        Intent intencion = new Intent(this, Main2Activity.class);
        startActivity(intencion);
    }

    public void calificar(View v){
        Intent intencion = new Intent(this, Main3Activity.class);
        startActivity(intencion);
    }

    public void mostrar(View v){
        Intent intencion = new Intent(this, Main4Activity.class);
        startActivity(intencion);
    }


}
