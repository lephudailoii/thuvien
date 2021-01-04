package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AcThuThu extends AppCompatActivity {
    Sach aa,bb;
    Button bntadd,bntdelete,bntupdate,bntphieumuon,bnttrasach,bntthuthu;
    ListView lv;Sachadapter sachadapter;ArrayList<Sach> listsach ;
    dbhelper dbhelper;
    SwipeRefreshLayout sr ;
    int vitri ;
    int RQC = 123;
    String q,nam,uptens,uptentg,upgia,uptl,upnamxb,upnhaxb,upmasach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_thu_thu);
        lv = findViewById(R.id.listsachthuthu);
//        sr = findViewById(R.id.sr);
        listsach = new ArrayList<>();
        dbhelper= new dbhelper(AcThuThu.this);
        listsach.addAll(dbhelper.getSachs());
        sachadapter = new Sachadapter(AcThuThu.this,R.layout.sach, listsach);
        lv.setAdapter(sachadapter);
        bntadd = findViewById(R.id.bntaddsach);
        bntdelete = findViewById(R.id.bntxoasach);
        bntupdate = findViewById(R.id.bntsuasach);
        bntphieumuon = findViewById(R.id.bntttlapphieu);
        bnttrasach = findViewById(R.id.bnntttrasach);

        bntadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcThuThu.this, ThemSach.class);
                startActivity(intent);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               vitri = position;
                 bb = new Sach();
                bb=listsach.get(position);
                 q = bb.getTenSach();
                Toast.makeText(AcThuThu.this, "Đã Chọn : " + q, Toast.LENGTH_SHORT).show();

            }
        });
        bntdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aa = new Sach();
                aa=listsach.get(vitri);
                dbhelper.deleteSach(aa);
                Toast.makeText(AcThuThu.this, "Đã xóa", Toast.LENGTH_SHORT).show();
            }
        });
        bntupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AcThuThu.this,suasach.class);
               intent.putExtra("vitrisach",vitri);
               startActivity(intent);




            }
        });
        bntphieumuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcThuThu.this, PhieuMuon.class);
                startActivity(intent);

            }
        });
        bnttrasach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcThuThu.this, trasach.class);
                startActivity(intent);
            }
        });
//        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                sachadapter.notifyDataSetChanged();
//            }
//        });

    }
}