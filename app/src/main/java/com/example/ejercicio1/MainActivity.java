package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View btn;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.myButton);
        et = (EditText) findViewById(R.id.editTextNumber);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // acceder al segundo activity y mandarle los datos
                String stg;
                stg = et.getText().toString();
                int end = Integer.parseInt(stg);

                Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                intent.putExtra("end", end);
                startActivity(intent);

            }
        });
    }
}