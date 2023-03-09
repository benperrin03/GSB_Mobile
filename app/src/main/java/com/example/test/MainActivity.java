package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private EditText edit_text_identifiant;


    private EditText edit_text_mdp;
    private Button button_valider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_text_identifiant = findViewById(R.id.edit_text_identifiant);
        edit_text_mdp = findViewById(R.id.edit_text_mdp);
        button_valider = findViewById(R.id.button_valider);


        button_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( edit_text_identifiant.getText().toString().equals("test") && edit_text_mdp.getText().toString().equals("test")) {
                    Intent intent = new Intent(MainActivity.this , GameActivity.class);
                    startActivity(intent);
                    finish();
                  //  validerFormulaire();
                  //  Toast.makeText(MainActivity.this,"OK", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"identifiant ou mot de passe incorect", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void validerFormulaire() {
        String identifiant = edit_text_identifiant.getText().toString().trim();
        String mdp =  edit_text_mdp.getText().toString().trim();


        if (identifiant.isEmpty()) {
            edit_text_identifiant.setError("Veuillez entrer votre identifiant.");
            edit_text_identifiant.requestFocus();
            return;
        }

        if (mdp.isEmpty()) {
            edit_text_mdp.setError("Veuillez entrer votre mot de passe.");
            edit_text_mdp.requestFocus();
            return;
        }

    }

}