package com.example.sharedpreferences.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedpreferences.R;
import com.example.sharedpreferences.ui.registro.RegistroActivity;
import com.example.sharedpreferences.ui.registro.ViewModelRegistro;

public class MainActivity extends AppCompatActivity {

    private ViewModelMain viewModel;
    private EditText userMail;
    private EditText userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(ViewModelMain.class);

        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                i.putExtra("registrar", true);
                startActivity(i);
            }
        });

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userMail = findViewById(R.id.userMail);
                userPassword = findViewById(R.id.userPassword);

                Boolean res = viewModel.existeUsuario(userMail.getText().toString(), userPassword.getText().toString());
                if (res) {
                    Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                    i.putExtra("registrar", false);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(), "usuario y/o password incorrectos", Toast.LENGTH_LONG).show();
            }
        });

    }
}
