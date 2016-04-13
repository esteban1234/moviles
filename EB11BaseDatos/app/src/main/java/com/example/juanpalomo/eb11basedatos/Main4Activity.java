package com.example.juanpalomo.eb11basedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Main4Activity extends AppCompatActivity {

    private TextView txtDatos;
    private SQLiteDatabase baseDatos;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        txtDatos=(TextView)findViewById(R.id.txtDatos);
        //Abrir o crear la base de datos

        baseDatos=this.openOrCreateDatabase("escolar.db",MODE_PRIVATE,null);

        //Abrir o crear una tabla
        String consultaSQL="Create Table if not exists estudiante (matricula text, "+
                "nombre text, semestre text);";
        baseDatos.execSQL(consultaSQL);//ahora si consultamos

        //insertamos la base datos
        //insertaBD();

        //explorar la base de datos
        exploraDB();
    }


    public void exploraDB(){
        String sql="SELECT * From calificacion;";
        //devuelve 0 1 o muchos registro el cursos apunta al primero y lo vamos moviendo recordar PDF
        cursor = baseDatos.rawQuery(sql, null);
        String respuesta=" ";
        cursor.moveToFirst();//garantizar que empiece desde el principio el cursor
        for (int i=0; i<cursor.getCount(); i++){
            respuesta+= cursor.getString(0) + "\t"; //tabulador 8 espacios
            respuesta += cursor.getString(1) + "\t";
            respuesta += ""+cursor.getString(2) + "\n";//salto de linea
            //Esto le falta al PDF
            cursor.moveToNext();
        }
        //mostrarlo
        txtDatos.setText(respuesta);
    }

}
