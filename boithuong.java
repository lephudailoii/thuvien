package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class boithuong extends AppCompatActivity {
    dbhelper dbhelper;
    ListView lv;boithuongadapter adapter;
    ArrayList<clphieumuon> listpm;
    ArrayList<listsachmuon> listsm;
    Integer id;
    Button bnt;
    clphieumuon pm;
    TextView txtten;
    listsachmuon lsm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boithuong);
        Intent intent = getIntent();
        txtten = findViewById(R.id.txtbthoten);
        lv = findViewById(R.id.listboithuong);
        bnt = findViewById(R.id.bnttrasachbt);
        id = intent.getIntExtra("id",200);
        listpm = new ArrayList<>();
        listsm = new ArrayList<>();
        dbhelper= new dbhelper(boithuong.this);
        listpm.addAll(dbhelper.getphieumuon());
         pm = new clphieumuon();
        pm= listpm.get(id);
        listsm.addAll(dbhelper.getlistsachmuons(id));
        adapter = new boithuongadapter(boithuong.this,R.layout.sach,listsm);
        lv.setAdapter(adapter);
        String ten= pm.getTen();
        txtten.setText(ten);
        lsm = listsm.get(id);
        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper.deletephieumuon(pm);
                dbhelper.deletelistsm(lsm);
                Toast.makeText(boithuong.this, "Đã Xóa", Toast.LENGTH_SHORT).show();finish();
            }
        });

    }
}