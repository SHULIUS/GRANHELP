package com.granhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.firebase.auth.FirebaseAuth;

public class InicioActivity extends AppCompatActivity {

    TextView Name, mail;


    private Button mLogoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        mLogoutBtn = (Button) findViewById(R.id.BtnSalir);
        Name = findViewById(R.id.Name);
        mail = findViewById(R.id.Mail);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount !=null){
            Name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());
        }



        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(InicioActivity.this,MainActivity.class));
            }
        });
    }
}