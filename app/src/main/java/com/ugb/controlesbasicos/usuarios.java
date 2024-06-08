package com.ugb.controlesbasicos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.messaging.FirebaseMessaging;


public class usuarios extends AppCompatActivity {
    Button btn;
    TextView tempVal;
    DatabaseReference mDatabase;
    String miToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        btn = findViewById(R.id.btnGuardarUsuario);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(usuarios.this, MainActivity.class);
                startActivity(intent);
            }
        });
        obtenerToken();
    }
    private void obtenerToken(){
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if( !task.isSuccessful() ){
                    return;
                }
                miToken = task.getResult();
                Toast.makeText(getApplicationContext(), miToken, Toast.LENGTH_LONG).show();
            }
        });
    }
}