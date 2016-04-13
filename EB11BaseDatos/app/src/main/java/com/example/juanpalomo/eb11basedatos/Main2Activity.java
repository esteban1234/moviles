package com.example.juanpalomo.eb11basedatos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;



public class Main2Activity extends AppCompatActivity {

    EditText txtNombre,txtMatricula,txtSemestre;
    Button btnAgregar;
    SQLiteDatabase bd = null;
    Cursor cursor  = null;
    String sql =" ", n = " ", m=" ";
    int s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtMatricula = (EditText) findViewById(R.id.txtMatricula);
        txtSemestre = (EditText) findViewById(R.id.txtSemestre);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
    }

    public void Registro(View v)
    {
        bd = this.openOrCreateDatabase("escolar.db", MODE_PRIVATE, null);
        String tabla = "create table if not exists estudiante (matricula text PRIMARY KEY, nombre text, semestre text)";
        bd.execSQL(tabla);
        sql = "INSERT INTO estudiante (matricula, nombre, semestre)" +
                "VALUES ('"+ txtMatricula.getText().toString()+"','"+txtNombre.getText().toString()+"','"+txtSemestre.getText().toString()+"')";
        bd.execSQL(sql);
        this.limpiar(v);

        //Intent i = new Intent(this, Main4Activity.class);startActivity(i);
    }

    public void limpiar(View v){
        txtMatricula.setText("");
        txtNombre.setText("");
        txtSemestre.setText("");

    }
}
