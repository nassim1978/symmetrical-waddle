package com.example.pruebafinalunidad1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    private MediaPlayer player;
   Bundle b;
    public MyService() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        b = intent.getExtras();
        String id_cancion_a_tocar = b.getString("idcancion");
        int id_numerica = Integer.parseInt(id_cancion_a_tocar);
        player= MediaPlayer.create(this,id_numerica);
        Toast.makeText(this, "estoy  on start", Toast.LENGTH_SHORT).show();
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy(){
        Toast.makeText(this, "estoy on destroy", Toast.LENGTH_SHORT).show();
        player.stop();
        super.onDestroy();

    }

    @Override
    public  void onCreate(){

        Toast.makeText(this, "estoy oncreate", Toast.LENGTH_SHORT).show();
        //player= MediaPlayer.create(this,R.raw.killer_mr_brightside);
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
