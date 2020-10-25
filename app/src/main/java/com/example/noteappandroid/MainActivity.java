package com.example.noteappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] title = {"ryd op", "skrald ud", "støv sug"};
        String[] text = {"1", "2", "3"};
        ListView listView = findViewById(R.id.TodoView);
        MyAdapter myAdapter = new MyAdapter(this, title, text);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener((_listview, linearLayout, adapterPos, arrPos) -> {
            System.out.println("klik på rækken" + arrPos);
            Intent intent = new Intent(this, DetailActivity.class);

            intent.putExtra("text", text[(int) arrPos]);
            startActivity(intent);

        });
    }
}