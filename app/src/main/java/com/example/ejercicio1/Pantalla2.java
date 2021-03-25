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
    private RecyclerView.Adapter mAdapter;
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
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(numbers, R.layout.recycler_view_item) {};


        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void onClick(View v){


    }

    private void getAllNames(int end){
        numbers = new String[end];
        for (int i = 0; i < end; i++){
            numbers[i] = "Número " + i;
        }
    }
}