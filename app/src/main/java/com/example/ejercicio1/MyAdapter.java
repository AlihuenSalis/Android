package com.example.ejercicio1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private String[] names;
    private int layout;


    public MyAdapter(String[] names, int layout){
        this.names = names;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.getTextView().setText(names.get(position));
        holder.getTextView().setText(names[position]);

        if(position%2 == 0){
            holder.textView.setBackgroundColor(Color.parseColor("#CDDC39"));
        } else {
            holder.textView.setBackgroundColor(Color.parseColor("#E8EAF6"));

        }
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    // VIEW HOLDER
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;

        //CONSTRUCTOR
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewNumber);
        }

        // ACA EL DE YOUTUBE PUSO EL BIND
        public TextView getTextView(){
            return textView;
        }
    }
}
