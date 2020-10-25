package com.example.noteappandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    private String[] title;
    private String[] text;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, String[] title, String[] text) {
        this.title = title;
        this.text = text;
        layoutInflater = LayoutInflater.from(context); // står med stort fordi det er en statisk metode

    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int i) { // bliver ikke kaldt
        return null;
    }

    @Override
    public long getItemId(int i) { // bliver kaldt 2 gange i starten
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if(view == null) {
            view = layoutInflater.inflate(R.layout.myrow, null);

        }

        TextView textView = view.findViewById(R.id.MytextView);
        textView.setText(title[i]);
        //TextView text2 = view.findViewById(R.id.textview);
        //text2.setText(text[i]);

        return view;
    }
}
