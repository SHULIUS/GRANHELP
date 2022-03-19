package com.granhelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText Email;
    private EditText contrasena;
    private EditText Confirmarcontrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.TxtEmailregistro);
        contrasena = findViewById(R.id.TxtContrasenaregistro);
        Confirmarcontrasena = findViewById(R.id.TxtContrasenaRegistroConfirmar);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }


    public  void registrarUsuario (View view) {

        if(contrasena.getText().toString().equals(Confirmarcontrasena.getText().toString())){

            mAuth.createUserWithEmailAndPassword(Email.getText().toString(),contrasena.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                Toast.makeText(getApplicationContext(), "Usuario Creado", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i =new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);

                            }else {
                                Toast.makeText(getApplicationContext(), "Autenticacion fallida",
                                        Toast.LENGTH_SHORT).show();

                                //updateUI(null);
                            }
                            // ...

                        }
                    });

        }else {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }


    }


























}