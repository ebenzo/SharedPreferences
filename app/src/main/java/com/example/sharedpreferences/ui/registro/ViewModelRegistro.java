package com.example.sharedpreferences.ui.registro;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


import com.example.sharedpreferences.model.Usuario;

public class ViewModelRegistro extends AndroidViewModel {
    private Usuario usuario;
    private SharedPreferences sp;

    public ViewModelRegistro(@NonNull Application application) {
        super(application);
    }

    private void savePreferences(long dni, String apellido, String nombre, String mail, String password) {
        sp = getApplication().getSharedPreferences("datos", 0);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("apellido", apellido);
        editor.putString("nombre", nombre);
        editor.putLong("dni", dni);
        editor.putString("mail", mail);
        editor.putString("password", password);

        editor.commit();
    }

    public Usuario getPreferences() {
        sp = getApplication().getSharedPreferences("datos", 0);
        Long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido", "");
        String nombre = sp.getString("nombre", "");
        String mail = sp.getString("mail", "");
        String password = sp.getString("password", "");
        return new Usuario(dni, apellido, nombre, mail, password);
    }

    public void saveUsuario(long dni, String apellido, String nombre, String mail, String password) {
        usuario = new Usuario(dni, apellido, nombre, mail, password);
        savePreferences(dni, apellido, nombre, mail, password);
    }
}
