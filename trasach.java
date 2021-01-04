package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class trasach extends AppCompatActivity {
    dbhelper dbhelper;
    ListView lv;
    Button bnt;
    ArrayList<clphieumuon> list;
    ngmuonadapter ngmuonadapter;
    int vitri,id;
    clphieumuon cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasach);
        lv = findViewById(R.id.listviewtrasach);
        list = new ArrayList<>();
        dbhelper= new dbhelper(trasach.this);
        list.addAll(dbhelper.getphieumuon());
        cl = new clphieumuon();
        ngmuonadapter = new ngmuonadapter(trasach.this,R.layout.ngmuon, list);
        lv.setAdapter(ngmuonadapter);
        bnt = findViewById(R.id.bnttrasachh);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              vitri= position;
             cl= list.get(position);
             id = cl.getIdpm();
            }
        });
        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(trasach.this, boithuong.class);
                intent.putExtra("id",vitri);
                startActivity(intent);

            }
        });
    }
}