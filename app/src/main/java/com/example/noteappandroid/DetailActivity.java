package com.example.noteappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /*TextView textView = findViewById(R.id.textview);

        String txt = getIntent().getStringExtra("text");
        textView.setText(txt);
        */

        EditText textView = findViewById(R.id.textview);
        Intent intent = getIntent();
        txt = intent.getStringExtra("text");
        textView.setText(txt);

        Button submit = findViewById(R.id.SubmitButton);
        TextView result = findViewById(R.id.result);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt = textView.getText().toString();
                result.setText(txt);
                finish();
            }
        });
    }

}