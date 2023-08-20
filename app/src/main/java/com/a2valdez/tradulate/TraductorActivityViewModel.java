package com.a2valdez.tradulate;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TraductorActivityViewModel extends AndroidViewModel {
    private Context context;

    private MutableLiveData<Palabra> palabraT;
    private List<Palabra> palabras = new ArrayList<>();

    private int error = 1;

    public TraductorActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        palabras.add(new Palabra("casa", "house", R.drawable.casa));
        palabras.add(new Palabra("perro", "dog", R.drawable.perro));
        palabras.add(new Palabra("gato", "cat", R.drawable.gato));
        palabras.add(new Palabra("bicicleta", "bycicle", R.drawable.bicicleta));
        palabras.add(new Palabra("auto", "car", R.drawable.auto));
    }

    public void traducirPalabra(String p){
        for (Palabra pb:palabras) {
            if(pb.getCastellano().equals(p)) {
                palabraT.setValue(pb);
                error = 0;
            }
        }
        if (error == 1){
            palabraT.setValue(new Palabra("error", "Error, no se encuentra la palabra.", R.drawable.error));
        }
    }

    public LiveData<Palabra> getPalabraT(){
        if(palabraT == null){
            palabraT = new MutableLiveData<Palabra>();
        }
        return palabraT;
    }
}
