package com.example.giusseppe.controldeactivos.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.giusseppe.controldeactivos.Bean.ActivosBean;
import com.example.giusseppe.controldeactivos.Database.DatabaseHelper;

/**
 * Created by Giusseppe on 03/07/2017.
 */

public class ActivosDAO {
    //1.Creamos el Contexto
    Context context;
    //2.Creamos el constructor
    public ActivosDAO(Context ctt){
        context = ctt;
    }
    //3.Creo los metodos para utilizarlos en la tabla Activos

    public ActivosBean Consultar(String codigo){
        ActivosBean bean = null;
        DatabaseHelper helper = new DatabaseHelper(context,null,null,1);
        SQLiteDatabase database = helper.getReadableDatabase();
        //Creo un cursor donde me listara a los Activos pero mediante un parametro
        Cursor cursor = database.rawQuery("SELECT * FROM ACTIVOS WHERE COD_ACTIVO = ?", new String[]{codigo});
        try{
            if (cursor.moveToNext()){
                bean = new ActivosBean();
                bean.setCodigoResponsable(cursor.getInt(0));
                bean.setDescripcionActivo(cursor.getString(1));
                bean.setCodigoCentro(cursor.getInt(2));
                bean.setCodigoUbicacion(cursor.getInt(3));
                bean.setCodigoTipo(cursor.getInt(4));
                bean.setCodigoGrupo(cursor.getInt(5));
                bean.setCodigoResponsable(cursor.getInt(6));
                bean.setModeloActivo(cursor.getString(7));
                bean.setSerieActivo(cursor.getString(8));
                bean.setPlacaActivo(cursor.getString(9));
                bean.setValorCompra(cursor.getDouble(10));
                bean.setVidaUtil(cursor.getInt(11));
            }
        }catch (Exception e){
            Toast.makeText(context,"Error en Consultar ActivosDAO: "+e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return  bean;
    }


    public int Actualizar(ActivosBean bean){
        int filasAfectadas;
        try{
            DatabaseHelper helper = new DatabaseHelper(context,null,null,1);
            SQLiteDatabase database = helper.getWritableDatabase();
            database.execSQL("UPDATE ACTIVOS SET DESCRIPCION = ?, COD_CENTRO_COSTO = ?, " +
                    " COD_UBICACION =?, COD_TIPO = ?, COD_GRUPO = ?, COD_RESPONSABLE =?, " +
                    " MODELO = ?, SERIE = ?, PLACA = ?, VALOR_COMPRA = ?, VIDA_UTIL = ? " +
                    " WHERE COD_ACTIVO = ?",
                    new Object[]{bean.getDescripcionActivo(), bean.getCodigoCentro(),
                    bean.getCodigoUbicacion(), bean.getCodigoTipo(), bean.getCodigoGrupo(),
                    bean.getCodigoResponsable(), bean.getModeloActivo(), bean.getSerieActivo(),
                    bean.getPlacaActivo(), bean.getValorCompra(), bean.getVidaUtil(),
                    bean.getCodigoActivo()});
            filasAfectadas = 1;
        }catch (Exception e){
            Toast.makeText(context,"Error al Actualizar ActivosDAO:" +e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
            filasAfectadas = -1;
        }
        return filasAfectadas;
    }
}
