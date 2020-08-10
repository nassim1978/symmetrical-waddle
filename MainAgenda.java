package com.example.pruebafinalunidad1;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class MainAgenda extends AppCompatActivity {
private EditText titulo,direccion,hora;
private Button guardar;
private CalendarView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_agenda);
        titulo = findViewById(R.id.editTextTitulo);
        direccion = findViewById(R.id.editTextDireccion);
        hora = findViewById(R.id.editTextHora);
        guardar = findViewById(R.id.btnguardar);
        fecha = findViewById(R.id.calendarView);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, titulo.getText().toString());
                intent.putExtra(CalendarContract.Events.DESCRIPTION,"La Reunion A Las: "+ hora.getText());
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, direccion.getText().toString());
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,fecha.getDate());
                intent.putExtra(CalendarContract.Events.ALL_DAY,true);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }//fin onclick button guardar

    public void cancelando(View v) {
        Intent btnsalir = new Intent(MainAgenda.this, Main2Activity.class);
        startActivity(btnsalir);
    }//finOnclick button cancelar
}
