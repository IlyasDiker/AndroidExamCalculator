package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button calc1, calc2, annuler;
    EditText ar,fr,ang,moyenne,pratique,theorie;
    EditText result1, result2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result1 = (EditText) findViewById(R.id.result1);
        result2= (EditText) findViewById(R.id.result2);
        result1.setVisibility(View.GONE);
        result2.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    public void openbrowser(MenuItem item) {
        Intent intent = new Intent( Intent.ACTION_MAIN );
        intent.addCategory( Intent.CATEGORY_APP_BROWSER);
        startActivity(intent);
    }

    public void openhome(MenuItem item) {
        Intent intent = new Intent( Intent.ACTION_MAIN );
        intent.addCategory( Intent.CATEGORY_HOME);
        startActivity(intent);
    }



    public void calculerexam(View view) {
        ar = (EditText) findViewById(R.id.arfiled);
        fr = (EditText) findViewById(R.id.frfield);
        ang = (EditText) findViewById(R.id.engfield);
        //--//
        moyenne = (EditText) findViewById(R.id.moyennefield);
        pratique = (EditText) findViewById(R.id.pratiquefield);
        theorie = (EditText) findViewById(R.id.theoriefield);
        //--//
        result1 = (EditText) findViewById(R.id.result1);
        result2= (EditText) findViewById(R.id.result2);
        //--//
        calc1 = (Button) findViewById(R.id.calculer1);
        calc2 = (Button) findViewById(R.id.calculer2);
        annuler = (Button) findViewById(R.id.annuler2);

        String varAr = ar.getText().toString();
        String varFr = fr.getText().toString();
        String varAng = ang.getText().toString();

        if( varAng.length()==0 || varFr.length()== 0 || varAr.length()== 0) {
            Toast.makeText(MainActivity.this, "EmptyField",
                    Toast.LENGTH_LONG).show();
        } else {
            int compt = ((Integer.valueOf(varFr) / 2) + Integer.valueOf(varAr) + Integer.valueOf(varAng))/3;

            calc1.setVisibility(View.GONE);
            result1.setVisibility(View.VISIBLE);
            result1.setText(String.valueOf(compt));
        }
    }

    public void calculergeneral(View view) {
        moyenne = (EditText) findViewById(R.id.moyennefield);
        pratique = (EditText) findViewById(R.id.pratiquefield);
        theorie = (EditText) findViewById(R.id.theoriefield);
        //--//
        result2 = (EditText) findViewById(R.id.result2);

        calc2.setVisibility(View.GONE);
        result2.setVisibility(View.VISIBLE);

        String varMoyenne = moyenne.getText().toString();
        String varPratique = pratique.getText().toString();
        String vartheorie = theorie.getText().toString();

        if( varMoyenne == null || varPratique == null || vartheorie  == null) {
            Toast.makeText(MainActivity.this, "EmptyField",
                    Toast.LENGTH_LONG).show();
        } else {
            int compt2 = ((Integer.parseInt(varPratique) / 2) + Integer.parseInt(varMoyenne) + Integer.parseInt(vartheorie))/3;

            result2.setText(String.valueOf(compt2));
        }
    }


    public void backtonormal(View view) {
        calc1.setVisibility(View.VISIBLE);
        calc2.setVisibility(View.VISIBLE);
        result1.setText("");
        result2.setText("");
        result1.setVisibility(View.GONE);
        result2.setVisibility(View.GONE);
        ar.setText("");
        fr.setText("");
        ang.setText("");
        moyenne.setText("");
        pratique.setText("");
        theorie.setText("");
    }
}

