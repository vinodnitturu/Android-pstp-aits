package com.example.recyclerviewapssdc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    String[] moviename;
    String[] Mdirector;
    int[] Mposter;
    Context ctx;

    public Myadapter(MainActivity mainActivity, String[] name, String[] director, int[] poster) {
        ctx=mainActivity;
        moviename=name;
        Mdirector=director;
        Mposter=poster;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tmovie.setText(moviename[position]);
        holder.tdirector.setText(Mdirector[position]);
        holder.pos.setImageResource(Mposter[position]);

    }

    @Override
    public int getItemCount() {
        return moviename.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tmovie,tdirector;
        ImageView pos;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tmovie=itemView.findViewById(R.id.movie_name);
            tdirector=itemView.findViewById(R.id.director);
            pos=itemView.findViewById(R.id.img);

        }
    }
}
