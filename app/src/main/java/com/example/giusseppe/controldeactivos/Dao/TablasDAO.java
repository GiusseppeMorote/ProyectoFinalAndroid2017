package com.example.giusseppe.controldeactivos.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.giusseppe.controldeactivos.Bean.CentrosBean;
import com.example.giusseppe.controldeactivos.Bean.GruposBean;
import com.example.giusseppe.controldeactivos.Bean.ResponsablesBean;
import com.example.giusseppe.controldeactivos.Bean.TiposBean;
import com.example.giusseppe.controldeactivos.Bean.UbicacionesBean;
import com.example.giusseppe.controldeactivos.Database.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by Giusseppe on 03/07/2017.
 */

public class TablasDAO {
    //1.Declaro mi contexto
    Context context;
    //2.Creo costructor para el Contexto
    public  TablasDAO(Context ctt){
        context = ctt;
    }
    //3.Creacion de los metodos para las tablas
    public ArrayList<ResponsablesBean>Responsables(){
        ArrayList<ResponsablesBean> responsable = new ArrayList<ResponsablesBean>();
        DatabaseHelper helper = new DatabaseHelper(context,null,null,1);
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM RESPONSABLES",null);
        ResponsablesBean bean = null;
        try {
            while (cursor.moveToNext()){
                bean = new ResponsablesBean();
                bean.setCodigoResponsable(cursor.getInt(0));
                bean.setNombreResponsable(cursor.getString(1));
                responsable.add(bean);
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al Listar Responsables :" + e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return responsable;
    }

    public ArrayList<CentrosBean>Centros(){
        ArrayList<CentrosBean>centro= new ArrayList<CentrosBean>();
        DatabaseHelper helper = new DatabaseHelper(context,null,null,1);
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM CENTRO_COSTOS",null);
        CentrosBean bean = null;
        try {
            while (cursor.moveToNext()){
                bean = new CentrosBean();
                bean.setCodigoCentro(cursor.getInt(0));
                bean.setDescripcionCentro(cursor.getString(1));
                centro.add(bean);
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al Listar Centros :" + e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        return centro;
    }

    public ArrayList<UbicacionesBean>Ubicaciones(){
        ArrayList<UbicacionesBean>ubicacion = new ArrayList<UbicacionesBean>();
        DatabaseHelper helper = new DatabaseHelper(context,null,null,1);
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM UBICACIONES",null);
        UbicacionesBean bean = null;
        try{
            while (cursor.moveToNext()){
                bean = new UbicacionesBean();
                bean.setCodigoUbicacion(cursor.getInt(0));
                bean.setDescripcionUbicacion(cursor.getString(1));
                ubicacion.add(bean);
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al Listar Ubicaciones: "+e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return ubicacion;
    }


    public ArrayList<TiposBean>Tipos(){
        ArrayList<TiposBean>tipos = new ArrayList<TiposBean>();
        DatabaseHelper helper = new DatabaseHelper(context,null,null,1);
        SQLiteDatabase  database = helper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM TIPOS",null);
        TiposBean bean = null;
        try {
            while (cursor.moveToNext()){
                bean = new TiposBean();
                bean.setCodigoTipo(cursor.getInt(0));
                bean.setDescripcionTipo(cursor.getString(1));
                tipos.add(bean);
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al Listar Tipos: "+e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return tipos;
    }


    public ArrayList<GruposBean>Grupos(){
        ArrayList<GruposBean>grupo = new ArrayList<GruposBean>();
        DatabaseHelper helper = new DatabaseHelper(context,null,null,1);
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM GRUPO",null);
        GruposBean bean = null;
        try{
            while (cursor.moveToNext()){
                bean = new GruposBean();
                bean.setCodigoGrupo(cursor.getInt(0));
                bean.setDescripcionGrupo(cursor.getString(1));
                grupo.add(bean);
            }
        }catch (Exception e){
            Toast.makeText(context,"Error al Listar Grupos: "+e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return grupo;
    }

}
