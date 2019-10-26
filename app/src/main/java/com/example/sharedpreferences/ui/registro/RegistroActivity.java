package com.example.sharedpreferences.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sharedpreferences.R;
import com.example.sharedpreferences.model.Usuario;

public class RegistroActivity extends AppCompatActivity {

    private ViewModelRegistro viewModel;
    private SharedPreferences sp;
    private EditText apellido;
    private EditText nombre;
    private EditText dni;
    private EditText mail;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inicilizarControles();

        viewModel = ViewModelProviders.of(this).get(ViewModelRegistro.class);

        Intent x = getIntent();
        Boolean registrar = x.getBooleanExtra("registrar", false);

        if (!registrar)//si no se esta registrando debe mostrar los datos
            mostrarDatosUsuario();

        Button btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.saveUsuario(
                        Long.parseLong(dni.getText().toString()),
                        apellido.getText().toString(),
                        nombre.getText().toString(),
                        mail.getText().toString(),
                        password.getText().toString());

                Toast.makeText(getApplicationContext(), "datos actualizados", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void mostrarDatosUsuario() {
        Usuario user = viewModel.getPreferences();
        apellido.setText(user.getApellido());
        nombre.setText(user.getNombre());
        dni.setText(user.getDni() + "");
        mail.setText(user.getMail());
        password.setText(user.getPassword());
    }

    private void inicilizarControles() {
        apellido = findViewById(R.id.textApellido);
        nombre = findViewById(R.id.textNombre);
        dni = findViewById(R.id.textDni);
        mail = findViewById(R.id.textMail);
        password = findViewById(R.id.textPassword);
    }
}
