package com.example.juanpalomo.eb11basedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Main3Activity extends AppCompatActivity {




private EditText txtMatricula;
    private TextView txtDatos, txtcali;
private SQLiteDatabase baseDatos;
private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);
        txtMatricula = (EditText)findViewById(R.id.txtMatricula);
        txtDatos=(TextView)findViewById(R.id.txtDatos);
        txtcali=(TextView)findViewById(R.id.txtCali);
        //Abrir o crear la base de datos



        //insertamos la base datos
        //insertaBD();

        //explorar la base de datos

    }


    public void consultar(View v){
        baseDatos=this.openOrCreateDatabase("escolar.db",MODE_PRIVATE,null);

        //Abrir o crear una tabla
        String consultaSQL="Create Table if not exists estudiante (matricula text, "+
                "nombre text, semestre text);";
        baseDatos.execSQL(consultaSQL);//ahora si consultamos
        String sql="SELECT * From estudiante WHERE matricula ='"+txtMatricula.getText().toString()+"' ;";
        //String sql="SELECT * From estudiante;";
        //devuelve 0 1 o muchos registro el cursos apunta al primero y lo vamos moviendo recordar PDF
        cursor = baseDatos.rawQuery(sql, null);
        String respuesta=" ";
        cursor.moveToFirst();//garantizar que empiece desde el principio el cursor
        for (int i=0; i<cursor.getCount(); i++){
           // respuesta+= cursor.getString(0) + "\t"; //tabulador 8 espacios
            respuesta = cursor.getString(1) + "\t";
            //respuesta += ""+cursor.getString(2) + "\n";//salto de linea
            //Esto le falta al PDF
            cursor.moveToNext();
        }
        //mostrarlo
        txtDatos.setText(respuesta);
    }

    public void guardar(View v)
    {
        baseDatos = this.openOrCreateDatabase("escolar.db", MODE_PRIVATE, null);
        String tabla = "create table if not exists calificacion (matricula text PRIMARY KEY,nombre text, calificacion text)";
        baseDatos.execSQL(tabla);
        String sql = "INSERT INTO calificacion (matricula, nombre, calificacion)" +
                "VALUES ('"+txtMatricula.getText().toString()+"','"+txtDatos.getText().toString()+"','"+txtcali.getText().toString()+"')";
        baseDatos.execSQL(sql);
        this.limpiar(v);

        //Intent i = new Intent(this, Main4Activity.class);startActivity(i);
    }

    public void limpiar(View v){
        txtMatricula.setText("");
        txtcali.setText("");

    }

}
