package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class chitietsach extends AppCompatActivity {
    TextView tensach,tacgia,theloai,gia,namxb,nhaxb;
    String sten,stg,stl,sgia,snam,snha;
    Sach sach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsach);
        sach = new Sach();
        tensach = findViewById(R.id.chitiettensach);
        tacgia = findViewById(R.id.chitiettacgia);
        theloai = findViewById(R.id.chitiettheloai);
        gia= findViewById(R.id.chitietgia);
        namxb = findViewById(R.id.chitietnamxb);
        nhaxb = findViewById(R.id.chitietnhaxb);
        Intent intent = getIntent();
        sach = (Sach) intent.getSerializableExtra("sach");
        sten = sach.getTenSach();
        stg = sach.getTacGia();
        stl = sach.getTheloai();
        sgia = String.valueOf(sach.getGia());
        snam = String.valueOf(sach.getNamxuatban());
        snha = sach.getNhaxuatban();
        tensach.setText(sten);
        tacgia.setText(stg);
        theloai.setText(stl);
        gia.setText(sgia);
        namxb.setText(snam);
        nhaxb.setText(snha);
    }
}