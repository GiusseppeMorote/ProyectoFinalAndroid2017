package com.example.giusseppe.controldeactivos.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.giusseppe.controldeactivos.Bean.ResponsablesBean;
import com.example.giusseppe.controldeactivos.Database.DatabaseHelper;

/**
 * Created by Giusseppe on 14/07/2017.
 */

    public class ResponsablesDAO {
    //1.Creamos el Contexto
    Context context;
    //2.Creamos el constructor
    public ResponsablesDAO(Context ctt){
        context = ctt;
    }

    public ResponsablesBean LoginUsuario(String usuario, String password){
        ResponsablesBean responsable = null;
        DatabaseHelper helper = new DatabaseHelper(context,null,null,1);
        SQLiteDatabase database = helper.getReadableDatabase();
        Log.e("llego al responsable","perro");

        Cursor cursor = database.rawQuery("SELECT * FROM RESPONSABLES WHERE USUARIO = ? AND PASSWORD=?",new String[]{usuario,password});
        try {
            if(cursor.moveToNext()){
                responsable = new ResponsablesBean();
                responsable.setUsuarioResponsable(cursor.getString(2));
                responsable.setPassword(cursor.getString(3));
                Log.e("Usuario => " ,responsable.getUsuarioResponsable());
                Log.e("Pasword => " ,responsable.getPassword());
            }

        }catch (Exception e){
            Toast.makeText(context,"Error en ResponsableDAO: " + e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return  responsable;
    }

}
