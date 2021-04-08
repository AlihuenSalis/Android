package com.example.ejercicio1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class Pantalla2 extends AppCompatActivity {

    private String[] numbers;

    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//      CORRECCION. Al definir la variable como RecyclerView.Adaprter, si creo un metodo
//      particular en mi adaptador, al definirlo asi del recycler, no voy a poder usarlo pq no es la misma clase, no lo va a encontrar.
//      entonces, esto se debe definir de la sigiente manera:
    private MyAdapter mAdapter; // ahora mAdapter hace referencia a mi clase adaptador.(activity MyAdapter)
    private RecyclerView.LayoutManager mLayoutManager;

    private View btnP2;
    private EditText etP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        // Recupero el valor que viene del MainActivity
        Bundle bundle = getIntent().getExtras();
        int end = bundle.getInt("end");

        getAllNames(end);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(numbers, R.layout.recycler_view_item) {};


        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        btnP2 = (Button) findViewById(R.id.btnPantalla2);
        etP2 = (EditText) findViewById(R.id.editTextP2);

        btnP2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                String stg;
                stg = etP2.getText().toString();
                int end = Integer.parseInt(stg);


                getAllNames(end);

                refreshAllNumbers(numbers);
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

                inputMethodManager.hideSoftInputFromWindow(etP2.getWindowToken(), 0);
            }
        });
    }

    public void refreshAllNumbers(String[] numbers){
//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        mLayoutManager = new LinearLayoutManager(this);
//        mAdapter = new MyAdapter(numbers, R.layout.recycler_view_item) {};
//
//
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);
//      CORRECCION: al hacer todo lo de arriba, en cuanto a performance, no es bueno, ya que cada vez que quiero setear el array
//      de numeros, crea un nuevo recycler, y le setea el adaptador, entonces, como mejora va lo siguiente:

        mAdapter.setNumbers(numbers);  // seteo el array de numeros definido el metodo en MyAdapter
        mAdapter.notifyDataSetChanged(); // Con este metodo me refresca todo el adaptador y el recycler sin tener que volver a crear todo como estaba antes.
    }

    private void getAllNames(int end){
        numbers = new String[end];
        for (int i = 0; i < end; i++){
            // CORRECCION:
            numbers[i] = getString(R.string.numero, String.valueOf(i));
//            numbers[i] = "Número " + i;
        }
    }
}