package com.example.giusseppe.controldeactivos.Principal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.giusseppe.controldeactivos.R;
import com.example.giusseppe.controldeactivos.Bean.ActivosBean;
import com.example.giusseppe.controldeactivos.Bean.CentrosBean;
import com.example.giusseppe.controldeactivos.Bean.GruposBean;
import com.example.giusseppe.controldeactivos.Bean.ResponsablesBean;
import com.example.giusseppe.controldeactivos.Bean.TiposBean;
import com.example.giusseppe.controldeactivos.Bean.UbicacionesBean;
import com.example.giusseppe.controldeactivos.Dao.ActivosDAO;
import com.example.giusseppe.controldeactivos.Dao.TablasDAO;


import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class ControlActivos extends AppCompatActivity {

    EditText etCodigoActivo,
            etDescripcionActivo,
            etModeloActivo,
            etSerieActivo,
            etPlacaActivo,
            etValorCompra,
            etVidaUtil;

    Button btnConsultar,
            btnActualizar,
            btnEscanear;

    Spinner spCentro,
            spUbicacion,
            spTipo,
            spGrupo,
            spResponsable;

    ArrayList<CentrosBean> centros;
    ArrayList<UbicacionesBean>ubicaciones;
    ArrayList<TiposBean>tipos;
    ArrayList<GruposBean>grupos;
    ArrayList<ResponsablesBean>responsables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_activos);

        CargarComponentes();
        CargarSpinners();

    }

    /**1.Creo el metodo para mostrar las alertas de las validaciones*/
    private void MensajeControl(AlertDialog.Builder builder, String mensaje ){
        builder.setMessage(mensaje);
        builder.show();
    }
    /**2.creo el metodo para la validacion para los editex ControlActivos*/
    public boolean ValidacionCodigoActivo() {
        boolean result = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(ControlActivos.this);
        builder.setTitle("Warning");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        /**3.Empezamos a validar campo por campo*/
        if(etCodigoActivo.getText().toString().trim().equals("")||
                etCodigoActivo.getText().toString().trim()==null)
        {
            MensajeControl(builder,"Ingresar Codigo Activo");
            result = false;
        }
        return  result;
    }
    /**1.Creo el metodo para mostrar las alertas de las validaciones*/
    private void MensajeActualizarActivo(AlertDialog.Builder builder, String mensaje){
        builder.setMessage(mensaje);
        builder.show();
    }
    /**2.creo el metodo para la validacion para los editex ControlActivos*/
    public boolean ValidacionActualizar(){
        boolean actualizate = true;

        AlertDialog.Builder builder = new AlertDialog.Builder(ControlActivos.this);
        builder.setTitle("Warning");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        /**3.Empezamos a validar campo por campo*/
        if(etModeloActivo.getText().toString().trim().equals("")||
                etModeloActivo.getText().toString().trim()==null)
        {
            MensajeActualizarActivo(builder,"Ingresar El Modelo del Activo");
            actualizate = false;
            etModeloActivo.requestFocus();
        }
        else if(etSerieActivo.getText().toString().trim().equals("")||
                etSerieActivo.getText().toString().trim()==null)
        {
            MensajeActualizarActivo(builder,"Ingresar La Serie del Activo");
            actualizate = false;
            etSerieActivo.requestFocus();
        }
        else if(etPlacaActivo.getText().toString().trim().equals("")||
                etPlacaActivo.getText().toString().trim()==null)
        {
            MensajeActualizarActivo(builder,"Ingresar La Placa del Activo");
            actualizate = false;
            etPlacaActivo.requestFocus();
        }
        else if(etValorCompra.getText().toString().trim().equals("") ||
                etValorCompra.getText().toString().trim()==null)
        {
            MensajeActualizarActivo(builder,"Ingresar El Valor de Compra");
            actualizate = false;
            etValorCompra.requestFocus();
        }
        else if(etVidaUtil.getText().toString().trim().trim().equals("")||
                etVidaUtil.getText().toString().trim()==null)
        {
            MensajeActualizarActivo(builder,"Ingresar El Valor de Vida Util");
            actualizate = false;
            etVidaUtil.requestFocus();
        }

        return  actualizate;
    }

    private void LimpiarActualizar(){
        etCodigoActivo.setText("");
        etDescripcionActivo.setText("");
        etModeloActivo.setText("");
        etSerieActivo.setText("");
        etPlacaActivo.setText("");
        etValorCompra.setText("");
        etVidaUtil.setText("");

        etCodigoActivo.requestFocus();
    }
    private void CargarComponentes() {
        /*--------------------------Editext--------------------------*/
        etCodigoActivo = (EditText) findViewById(R.id.etCodigoActivo);
        etDescripcionActivo = (EditText) findViewById(R.id.etDescripcionActivo);
        etModeloActivo = (EditText) findViewById(R.id.etModelo);
        etSerieActivo = (EditText) findViewById(R.id.etSerie);
        etPlacaActivo = (EditText) findViewById(R.id.etPlaca);
        etValorCompra = (EditText) findViewById(R.id.etValorCompra);
        etVidaUtil = (EditText) findViewById(R.id.etVidaUtil);
        /*--------------------------Button--------------------------*/
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnActualizar.setEnabled(false);

        btnEscanear = (Button) findViewById(R.id.btnEscanear);


        /*--------------------------Spinner--------------------------*/
        spCentro = (Spinner) findViewById(R.id.spCentro);
        spUbicacion = (Spinner) findViewById(R.id.spUbicacion);
        spTipo = (Spinner) findViewById(R.id.spTipo);
        spGrupo = (Spinner) findViewById(R.id.spGrupo);
        spResponsable = (Spinner) findViewById(R.id.spResponsable);
        /*--------------------------OnClickListener--------------------------*/
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 1. LLamo a mi ActivoDAO para poder usar sus metodos creados,
                 *    El cual me pedira un contexto el cual fue definido en la clase ActivoDAO
                 * 2. Llamo a mi ActivoBean para poder obtener los atributos de la Clase.
                 * */
                ActivosDAO dao = new ActivosDAO(ControlActivos.this);
                ActivosBean activos = dao.Consultar(etCodigoActivo.getText().toString());
                /*Verifico que el codigo ingresado sea diferente de null*/
                try {
                    if(ValidacionCodigoActivo()){
                        if (activos != null) {
                        /*Obtengo los valores de mi bean y los muestro en sus respectivos campos*/
                            etDescripcionActivo.setText(activos.getDescripcionActivo().toString());
                            etModeloActivo.setText(activos.getModeloActivo().toString());
                            etSerieActivo.setText(activos.getSerieActivo().toString());
                            etPlacaActivo.setText(activos.getPlacaActivo().toString());
                            etValorCompra.setText(activos.getValorCompra() + "");
                            etVidaUtil.setText(activos.getVidaUtil() + "");

                            spCentro.setSelection(getPosicionCentro(activos.getCodigoCentro()));
                            spUbicacion.setSelection(getPosicionUbicacion(activos.getCodigoUbicacion()));
                            spTipo.setSelection(getPosicionTipo(activos.getCodigoTipo()));
                            spGrupo.setSelection(getPosicionGrupo(activos.getCodigoGrupo()));
                            spResponsable.setSelection(getPosicionResponsable(activos.getCodigoResponsable()));

                            btnActualizar.setEnabled(true);

                            Toast.makeText(ControlActivos.this, "Consulta Exitosa ", Toast.LENGTH_LONG).show();
                        } else {
                            etCodigoActivo.setText("");
                            etDescripcionActivo.setText("");
                            etModeloActivo.setText("");
                            etSerieActivo.setText("");
                            etPlacaActivo.setText("");
                            etValorCompra.setText("");
                            etVidaUtil.setText("");
                            etCodigoActivo.requestFocus();
                            Toast.makeText(ControlActivos.this, "Activo No Encontrado ", Toast.LENGTH_LONG).show();
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(ControlActivos.this, "Error al Consultar Activo: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ValidacionActualizar()){
                    try{
                        ActivosDAO dao = new ActivosDAO(ControlActivos.this);
                        ActivosBean activos = new ActivosBean();
                        activos.setCodigoActivo(Integer.parseInt(etCodigoActivo.getText().toString()));
                        activos.setDescripcionActivo(etDescripcionActivo.getText().toString());
                        activos.setCodigoCentro(((CentrosBean) spCentro.getItemAtPosition(spCentro.getSelectedItemPosition())).getCodigoCentro());
                        activos.setCodigoUbicacion(((UbicacionesBean) spUbicacion.getItemAtPosition(spUbicacion.getSelectedItemPosition())).getCodigoUbicacion());
                        activos.setCodigoTipo( ((TiposBean)spTipo.getItemAtPosition(spTipo.getSelectedItemPosition())).getCodigoTipo());
                        activos.setCodigoGrupo( ((GruposBean)spGrupo.getItemAtPosition(spGrupo.getSelectedItemPosition())).getCodigoGrupo());
                        activos.setCodigoResponsable( ((ResponsablesBean)spResponsable.getItemAtPosition(spGrupo.getSelectedItemPosition())).getCodigoResponsable());
                        activos.setModeloActivo(etModeloActivo.getText().toString());
                        activos.setSerieActivo(etSerieActivo.getText().toString());
                        activos.setPlacaActivo(etPlacaActivo.getText().toString());
                        activos.setValorCompra(Double.parseDouble(etValorCompra.getText().toString()));
                        activos.setVidaUtil(Integer.parseInt(etVidaUtil.getText().toString()));

                        int resultadoActivo = dao.Actualizar(activos);

                        if(resultadoActivo >0){
                            Toast.makeText(ControlActivos.this,"Actualizacion Exitosa !",Toast.LENGTH_LONG).show();
                            LimpiarActualizar();;
                        }

                    }catch (Exception e){
                        Toast.makeText(ControlActivos.this,"Error al Actualizar Activo: " + e.getMessage(),Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }






            }
        });

        btnEscanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IntentIntegrator(ControlActivos.this).initiateScan();
            }
        });

    }

    private void CargarSpinners(){
        /**
         * 1.Para cargar los Spinner recurriremos a TablasDAO para usar sus metodos
         * 2.Se asignara los metodos de TablasDAO a sus respectivos ArrayList
         * 3.Se creara Adaptarores para cada ArrayList
         * 4.Se asignara Adaptadores a cada ArrayList
         * */
        TablasDAO dao = new TablasDAO(ControlActivos.this);
        centros      = dao.Centros();
        ubicaciones  = dao.Ubicaciones();
        tipos        = dao.Tipos();
        grupos       = dao.Grupos();
        responsables = dao.Responsables();
        /*************Creacion de los Adapters para cada Spinner******/
        ArrayAdapter<CentrosBean> adapterCentro = new ArrayAdapter<CentrosBean>(ControlActivos.this,android.R.layout.simple_list_item_1,centros);
        ArrayAdapter<UbicacionesBean>adapterUbicacion = new ArrayAdapter<UbicacionesBean>(ControlActivos.this,android.R.layout.simple_list_item_1,ubicaciones);
        ArrayAdapter<TiposBean> adapterTipo= new ArrayAdapter<TiposBean>(ControlActivos.this,android.R.layout.simple_list_item_1,tipos);
        ArrayAdapter<GruposBean>adapterGrupo = new ArrayAdapter<GruposBean>(ControlActivos.this,android.R.layout.simple_list_item_1,grupos);
        ArrayAdapter<ResponsablesBean>adapterResponsable = new ArrayAdapter<ResponsablesBean>(ControlActivos.this,android.R.layout.simple_list_item_1,responsables);
        /*************Asignaccion de los Adapters para cada ArrayList******/
        spCentro.setAdapter(adapterCentro);
        spUbicacion.setAdapter(adapterUbicacion);
        spTipo.setAdapter(adapterTipo);
        spGrupo.setAdapter(adapterGrupo);
        spResponsable.setAdapter(adapterResponsable);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      /*
        * IntentResult : me pide 4 Parametros
        * */
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        //Verifico si el IntentResult es diferente de null
        if(intentResult != null){
            String codigo = intentResult.getContents();
            etCodigoActivo.setText(codigo);
        }
    }

    /*Metodos para obtener la posicion de los Spinner*/
    private int getPosicionCentro(int id){
        int pos = -1;
        for (int i = 0; i<responsables.size();i++){
            ResponsablesBean bean = responsables.get(i);
            //valido si el codigo del responsable es igual al id del combo
            if(bean.getCodigoResponsable() == id){
                //obtengo la posicion del combo y le reasigno a mi variable pos
                pos = i;
                //interrumpo el for
                break;
            }
        }
        return  pos;
    }

    private int getPosicionUbicacion(int id){
        int pos = -1;
        for (int i = 0; i<ubicaciones.size();i++){
            UbicacionesBean bean = ubicaciones.get(i);
            if(bean.getCodigoUbicacion() == id){
                pos = i;
                break;
            }
        }
        return pos;
    }

    private int getPosicionTipo(int id){
        int pos = -1;
        for (int i=0; i<tipos.size();i++){
            TiposBean bean = tipos.get(i);
            if(bean.getCodigoTipo() == id){
                pos = i;
                break;
            }
        }
        return pos;
    }

    private int getPosicionGrupo(int id){
        int pos = -1;
        for (int i=0; i<grupos.size();i++){
            GruposBean bean = grupos.get(i);
            if(bean.getCodigoGrupo() == id){
                pos = i;
                break;
            }
        }
        return pos;
    }
    //
    private int getPosicionResponsable(int id){
        int pos = -1;
        for (int i=0; i<responsables.size();i++){
            ResponsablesBean bean = responsables.get(i);
            if(bean.getCodigoResponsable() == id){
                pos = i;
                break;
            }
        }
        return pos;
    }
}
