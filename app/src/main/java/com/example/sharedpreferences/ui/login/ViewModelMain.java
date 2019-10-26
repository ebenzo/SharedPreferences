package com.example.sharedpreferences.ui.login;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


public class ViewModelMain extends AndroidViewModel {

    private SharedPreferences sp;

    public ViewModelMain(@NonNull Application application) {
        super(application);
    }

    public Boolean existeUsuario(String userMail, String userPass) {
        sp = getApplication().getSharedPreferences("datos", 0);
        String mail = sp.getString("mail", "");
        String pass = sp.getString("password", "");

        if (!mail.equals("") && mail.equals(userMail) && pass.equals(userPass)) {
            return true;
        }

        return false;

    }

}
