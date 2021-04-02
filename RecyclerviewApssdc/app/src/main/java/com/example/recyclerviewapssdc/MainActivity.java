package com.example.recyclerviewapssdc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rc;
    String[] name={"Pushpa","Jathiratnalu","Legend","Dookudu","Fida","Gabbarsingh","Hello","RRR","IsmartShankar"};
    String[] director={"Sukkumar","cash_Anudeep","Boyapati","Srinuvaitla","Shekarkamala","HarrishSankar","Vikramkekumar","SSRajamouli","PuriJaganath"};
    int poster[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc=findViewById(R.id.rv);
        poster= new int[]{R.drawable.puspha,
                R.drawable.jathi,
                R.drawable.legend,
                R.drawable.dookudu,
                R.drawable.fida,
                R.drawable.gabaar,
                R.drawable.hello,
                R.drawable.rrr,
                R.drawable.sanker
        };
        Myadapter myadapter=new Myadapter(this,name,director,poster);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(myadapter);

    }
}