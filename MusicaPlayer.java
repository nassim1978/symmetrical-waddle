package com.example.pruebafinalunidad1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MusicaPlayer extends AppCompatActivity {
private TextView texto;
private Spinner combobox;
private ImageButton play,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica_player);
        play=findViewById(R.id.imageButtonOn);
        stop=findViewById(R.id.imageButton3);
        combobox=findViewById(R.id.spn);
        String[] miArrayNombreMusica = new String[R.raw.class.getDeclaredFields().length];
        for(int i=0;i < R.raw.class.getFields().length; i++){
            miArrayNombreMusica[i]= R.raw.class.getFields()[i].getName();
        }

        ArrayAdapter<String> adaptadorjava= new ArrayAdapter<String>
                (this,R.layout.support_simple_spinner_dropdown_item,miArrayNombreMusica);
        combobox.setAdapter(adaptadorjava);
        combobox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                int posicion_item_seleccionado = adapterView.getSelectedItemPosition();
                Object itemSeleccionadoObjeto = adapterView.getItemAtPosition(posicion_item_seleccionado);
                String itemSeleccionadoObjetoString = itemSeleccionadoObjeto.toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }//fin oncreate---------------------------*

    public void startstopmusica(View v){

        int resId2 = getResources().getIdentifier("raw/"+combobox.getSelectedItem().toString(),null,this.getPackageName());
        Intent ejecutarservicio = new Intent(this,MyService.class);
        switch(v.getId()){
            case R.id.imageButtonOn:
                ejecutarservicio.putExtra("idcancion",""+resId2);
                startService(ejecutarservicio);
                break;
            case R.id.imageButton3:
                stopService(ejecutarservicio);
                break;
        }
    }
}
