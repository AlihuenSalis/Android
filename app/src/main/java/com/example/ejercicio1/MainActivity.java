package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


// MEJORAS PARA ESTA ACTIVIDAD.

// 1- PARA ACTUALIZAR EL RECYCLER CON UNA NUEVA CANTIDAD DE NUMEROS, LO QUE SE USA ES EL METODO
//      QUE SE LLAMA notifyDatasetChange COMO SE MUESTRA EN LA CORRECCION (pantalla 2)

// 2- EN LOS EDIT TEXT, CON EL ALTO Y EL ANCHO SE USA WRAP_CONTENT(para que quede lo mas responsive posible)
//      Y SE JUEGA DESPUES CON LOS MARGENES PARA ACOMODARLO. (xml pantalla 2)

// 3- PARA LOS STRING, PODES CREAR NUEVOS STRING CON DIFERENTES PARAMETROS(ver correccion en xml de strings), ENTONCES A ESTO SE LO
//      PODES PASAR A UN METODO Y CON ESTO TE AHORRAS LINEAS DE CODIGO. (metodo getAllNames en pantalla 2)
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