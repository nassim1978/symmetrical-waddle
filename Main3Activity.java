package com.example.pruebafinalunidad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private AutoCompleteTextView miBuscador;
    private EditText minombre,miApellido,miusuario;
    private Button buttonEnviar,buttonVolver;
    private TextView micasillamostrar ;
    private RadioGroup miGrupoGenero;
    private CheckBox alerta;
    private RadioButton seleccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        miGrupoGenero = findViewById(R.id.contenedor);
        miBuscador = findViewById(R.id.buscador);
        minombre = findViewById(R.id.nombre);
        miApellido = findViewById(R.id.apellido);
        buttonEnviar = findViewById(R.id.btn_enviar);
        buttonVolver = findViewById(R.id.btn_volver);
        micasillamostrar = findViewById(R.id.mostrar);
        miusuario =findViewById(R.id.usuario);
        alerta=findViewById(R.id.checkBox3);
        String[] listaOpciones = this.getResources().getStringArray(R.array.opciones);
        ArrayAdapter<String> mipuenteDatos = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,listaOpciones);
        miBuscador.setAdapter(mipuenteDatos);



    }
    String textBuscador ="";
    String textNombre = "";
    String textApellido = "";
    String textusuario="";
    String textalerta="";


    public void  MetodobtenerDatos (View boton){
        if(alerta.isChecked()){
            textalerta=this.alerta.getText().toString();
        }else{
            textalerta="";
        }
        textBuscador = this.miBuscador.getText().toString();
        textNombre = this.minombre.getText().toString();
        textApellido = this.miApellido.getText().toString();
        textusuario = this.miusuario.getText().toString();

        int idRadioselecc = miGrupoGenero.getCheckedRadioButtonId();
        seleccion = findViewById(idRadioselecc);
        String textoselecc = ""+ seleccion.getText();




        this.micasillamostrar.setText("Gracias  "+textNombre +"\n"+ "Datos Enviados"+"\n"+"Excitosamente!!");
        Toast.makeText(this,"Datos Enviados: "+"\n"+"Nombre: "+minombre.getText()+"\n"+"Apellido: "
                +miApellido.getText()+"\n"+"Perfil: "+miusuario.getText()+"\n"+"Comuna: "+textBuscador+"\n"
                +"Aleta:"+textalerta+"\n" +
                "Sexo: "+textoselecc, Toast.LENGTH_LONG).show();
    }
    public void MetodoVolver(View button){
        micasillamostrar.setText("");
        miApellido.setText("");
        miBuscador.setText("");
        minombre.setText("");
        Intent btnEditar = new Intent(Main3Activity.this, Main2Activity.class);
        startActivity(btnEditar);
        finish();
    }
}
