package com.example.noteappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.noteappandroid.global.Global;
import com.example.noteappandroid.model.Note;
import com.example.noteappandroid.repo.Repo;

public class MainActivity extends AppCompatActivity implements Updatable {
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] title = {"ryd op", "skrald ud", "støv sug"};
        String[] text = {"1", "2", "3"};
        ListView listView = findViewById(R.id.TodoView);
        MyAdapter myAdapter = new MyAdapter(this, Repo.r().notes());
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener((_listview, linearLayout, adapterPos, arrPos) -> {
            System.out.println("klik på rækken" + arrPos);
            Intent intent = new Intent(this, DetailActivity.class);
            Global.map.put(Global.NOTE_KEY, Repo.r().notes().get((int)arrPos));
            //intent.putExtra("text", text[(int) arrPos]);
            startActivity(intent);
        });
        Repo.r().setActivity(this);
    }

   @Override
    public void update() {
        System.out.println("update() er kaldet");
        runOnUiThread(()->{
            myAdapter.notifyDataSetChanged();
        });


    }

    public void addNote(View view){
        Note note = new Note("Skriv");
        Repo.r().addNote(note); // opretter ny Note + gemmer i Firebase
    }
}