package com.example.pruebafinalunidad1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    //private ImageView fotoboton;
    private TextView accion,mostrar;
    private ConstraintLayout mi_vista_principal;
    private ImageButton fotoboton,newboton,newboton2,botonCalendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mostrar=findViewById(R.id.textView6);
        String dato1 = getIntent().getStringExtra("dato1");
        String dato2 = getIntent().getStringExtra("dato2");
        String dato3 = getIntent().getStringExtra("dato3");
        mostrar.setText("Bienvenido, "+dato3+" "+ dato1+"." );
        View tarjeta_accion = getLayoutInflater().inflate(R.layout.tarjeta_generica,null);
        mi_vista_principal=findViewById(R.id.vista_principal);
        fotoboton=tarjeta_accion.findViewById(R.id.imageButton2);
        accion=tarjeta_accion.findViewById(R.id.textView3);
        fotoboton.setImageResource(R.drawable.edit);
        accion.setText("Editar Datos");
        LinearLayout a = new LinearLayout(this);
        a.setOrientation(LinearLayout.VERTICAL);
        a.addView(tarjeta_accion);
        mi_vista_principal.addView(a);
        // connectar button con el implement listener
        fotoboton.setOnClickListener(this);

        /*-----------------------------------------------------------------------------*/
        View tarjeta_accion2 = getLayoutInflater().inflate(R.layout.tarjeta_generica,null);
        mi_vista_principal=findViewById(R.id.vista_principal);
        newboton2=tarjeta_accion2.findViewById(R.id.imageButton2);
        accion=tarjeta_accion2.findViewById(R.id.textView3);
        newboton2.setImageResource(R.drawable.gnome_audio_volume_low);
        newboton2.setId(R.id.imageButton2);
        accion.setText("Reproducir Musica");
        LinearLayout b = new LinearLayout(this);
        a.setOrientation(LinearLayout.VERTICAL);
        a.addView(tarjeta_accion2);
        mi_vista_principal.addView(b);
        newboton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnmusica = new Intent(Main2Activity.this, MusicaPlayer.class);
                startActivity(btnmusica);
            }
        });
        /*-----------------------------------------------------------------------------*/
        View tarjeta_accion3 = getLayoutInflater().inflate(R.layout.tarjeta_generica,null);
        mi_vista_principal=findViewById(R.id.vista_principal);
        botonCalendario=tarjeta_accion3.findViewById(R.id.imageButton2);
        accion=tarjeta_accion3.findViewById(R.id.textView3);
        botonCalendario.setImageResource(R.drawable.agenda);
        botonCalendario.setId(R.id.imageButton2);
        accion.setText("Agendar Evento");
        LinearLayout d = new LinearLayout(this);
        a.setOrientation(LinearLayout.VERTICAL);
        a.addView(tarjeta_accion3);
        mi_vista_principal.addView(d);
        botonCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnagenda = new Intent(Main2Activity.this, MainAgenda.class);
                startActivity(btnagenda);
            }
        });
        /*-----------------------------------------------------------------------------*/
        View tarjeta_accion1 = getLayoutInflater().inflate(R.layout.tarjeta_generica,null);
        mi_vista_principal=findViewById(R.id.vista_principal);
        newboton=tarjeta_accion1.findViewById(R.id.imageButton2);
        accion=tarjeta_accion1.findViewById(R.id.textView3);
        newboton.setImageResource(R.drawable.off);
        newboton.setId(R.id.imageButton2);
        accion.setText("Salir");
        LinearLayout c = new LinearLayout(this);
        a.setOrientation(LinearLayout.VERTICAL);
        a.addView(tarjeta_accion1);
        mi_vista_principal.addView(c);
        // connectar el button con el onClickListener
        newboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnEditar = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(btnEditar);
            }
        });

    }//fin oncreate.

    @Override
    public void onClick(View v) {
                Intent btnsalir = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(btnsalir);
    }//finOnclick
}
