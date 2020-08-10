package com.example.pruebafinalunidad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileUtils;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner combobox ;
    private ProgressBar progrescircular;
    private Button entrar;
    private TextView nombre,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        combobox=findViewById(R.id.combo);
        progrescircular=findViewById(R.id.procircular);
        entrar=findViewById(R.id.btnIngresar);
        nombre=findViewById(R.id.usernom);
        password=findViewById(R.id.passwd);
        ArrayAdapter<CharSequence> adaptercombobox =
                ArrayAdapter.createFromResource(this,R.array.misopciones ,
                        R.layout.support_simple_spinner_dropdown_item);
        combobox.setAdapter(adaptercombobox);

        progrescircular.setVisibility(View.INVISIBLE);
    }//fin oncreate

    public void entrar(View v){
        int posicion = combobox.getSelectedItemPosition();
        Object itemSeleccionadaObjeto = combobox.getItemAtPosition(posicion);
        final String itemSeleccionadoString = itemSeleccionadaObjeto.toString();
        final ProgressBar pbar = (ProgressBar) findViewById(R.id.procircular);
        pbar.setVisibility(View.VISIBLE);
        Toast.makeText(this,"Valores Ingresados: "+"[Usuario: "+nombre.getText()+"]"+"[contaseña: "
                +password.getText()+"]"+"[Perfil: "+itemSeleccionadoString+"]", Toast.LENGTH_LONG).show();

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            public void run() {
                try{
                    Thread.sleep(3000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    public void run() {
                        pbar.setVisibility(View.INVISIBLE);
                    }
                });
                handler.post(new Runnable() {
                    public void run() {
                        Intent btnEntrar = new Intent(MainActivity.this, Main2Activity.class);
                        btnEntrar.putExtra("dato1",nombre.getText().toString());
                        btnEntrar.putExtra("dato2",password.getText().toString());
                        btnEntrar.putExtra("dato3",itemSeleccionadoString);
                        startActivity(btnEntrar);
                    }
                });
            }
        }).start();
    }//fin metodo INTRAR
}
