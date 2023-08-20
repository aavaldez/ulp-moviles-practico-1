package com.a2valdez.tradulate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.a2valdez.tradulate.databinding.ActivityTraductorBinding;

public class TraductorActivity extends AppCompatActivity {
    private TraductorActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTraductorBinding binding = ActivityTraductorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String p = (String)intent.getStringExtra("palabra");
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraductorActivityViewModel.class);
        mv.getPalabraT().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                binding.etTraduccion.setText(palabra.getIngles());
                binding.imageView.setImageResource(palabra.getFoto());
            }
        });
        mv.traducirPalabra(p);
    }
}