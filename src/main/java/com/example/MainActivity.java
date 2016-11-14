package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CommonAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.lv);
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            stringList.add(String.valueOf(i));
        }

        adapter = new CommonAdapter<String>(MainActivity.this, stringList, R.layout.item_custom_adapter) {
            @Override
            protected void convert(ViewHolder viewHoler, String item) {
                viewHoler.setText(R.id.tv,item);
            }
        };

        lv.setAdapter(adapter);
    }
}
