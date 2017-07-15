package com.example.giusseppe.controldeactivos.Principal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.giusseppe.controldeactivos.Dao.ResponsablesDAO;
import com.example.giusseppe.controldeactivos.R;

public class MainActivity extends AppCompatActivity {

    EditText etUsuario,etPassword;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CargarComponentes();
    }
    private void CargarComponentes(){
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validacion()){
                    ResponsablesDAO dao = new ResponsablesDAO(MainActivity.this);
                    String usuario  = etUsuario.getText().toString().toLowerCase().trim();
                    String password = etPassword.getText().toString().toLowerCase().trim();
                    if(dao.LoginUsuario(usuario,password)!=null){
                        Intent intent = new Intent(MainActivity.this,ControlActivos.class);
                        startActivity(intent);
                    }else{
                        etUsuario.setText("");
                        etPassword.setText("");
                        Toast.makeText(MainActivity.this,"No existe el Usuario",Toast.LENGTH_LONG).show();
                        etUsuario.requestFocus();
                    }
                }

            }
        });


    }
    /**1.Creo el metodo para mostrar las alertas de las validaciones*/
    private void MensajeAlerta(AlertDialog.Builder builder, String mensaje ){
        builder.setMessage(mensaje);
        builder.show();
    }

    /**2.creo el metodo para la validacion para los editex Usuario y Password*/
    public boolean Validacion(){
        boolean validando = true;
        AlertDialog.Builder  builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Warning");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        /**3.Empezamos a validar campo por campo*/
        if(etUsuario.getText().toString().trim().equals("")||etUsuario.getText().toString().trim() == null){
            MensajeAlerta(builder,"Ingresar Usuario");
            validando = false;

            etUsuario.requestFocus();

        }else if (etPassword.getText().toString().trim().equals("")||etPassword.getText().toString().trim()==null){
            MensajeAlerta(builder,"Ingresar Contraseña");
            validando = false;
            etPassword.requestFocus();             }
        return  validando;
    }
}
