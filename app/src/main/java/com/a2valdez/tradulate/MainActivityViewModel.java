package com.a2valdez.tradulate;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void enviarPalabra(String palabra){
        //Logica de texto vacio
        if(palabra.length() > 0){
            Intent intent = new Intent(context, TraductorActivity.class);
            intent.putExtra("palabra", palabra);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "La palabra a traducir no puede ser vacia.", Toast.LENGTH_LONG).show();
        }
    }
}
