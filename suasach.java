package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class suasach extends AppCompatActivity {
    EditText masach,tensach,tacgia,namxb,nhaxb,theloai,gia;
    Sach sach;
    Sach sachsua;
    dbhelper dbhelper;
    String umasach,utensach,utacgia,unamxb,unhaxb,utheloai,ugia;
    Button bnt;
String w;
ArrayList<Sach> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suasach);
        masach = findViewById(R.id.txtssmasach);
        bnt = findViewById(R.id.bntsssua);
        tensach = findViewById(R.id.txtsstensach);
        tacgia = findViewById(R.id.txtsstacgia);
        namxb= findViewById(R.id.txtssnamxb);
        nhaxb = findViewById(R.id.txtssnhaxb);
        theloai = findViewById(R.id.txtsstheloai);
        gia = findViewById(R.id.txtssgia);
        sach= new Sach();
        dbhelper = new dbhelper(suasach.this);
        list = new ArrayList<>();
        Intent intent = getIntent();
        Integer stt;
        stt = intent.getIntExtra("vitrisach",1);
        list.addAll(dbhelper.getSachs());
        sach = list.get(stt);
        int q = sach.getIdSach();
         w = String.valueOf(q);
        masach.setText(sach.getMasach());
        tensach.setText(sach.getTenSach());
        tacgia.setText(sach.getTacGia());
        String namxbb = String.valueOf(sach.getNamxuatban());
        namxb.setText(namxbb);
        String giasach = String.valueOf(sach.getGia());
        gia.setText(giasach);
        nhaxb.setText(sach.getNhaxuatban());
        theloai.setText(sach.getTheloai());

        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                umasach = String.valueOf(masach.getText());
                utensach = String.valueOf(tensach.getText());
                ugia = String.valueOf(gia.getText());
                unhaxb = String.valueOf(nhaxb.getText());
                utacgia = String.valueOf(tacgia.getText());
                utheloai = String.valueOf(theloai.getText());
                unamxb = String.valueOf(namxb.getText());
                Integer igia = Integer.valueOf(ugia);
                Integer inamxb = Integer.valueOf(igia);
                Integer istt = sach.getIdSach();
                sachsua = new Sach(istt,umasach,utensach,utacgia,igia,utheloai,inamxb,unhaxb);
                dbhelper.updateSach(sachsua);
                Toast.makeText(suasach.this, " Đã Cập Nhật Sách", Toast.LENGTH_SHORT).show();
                finish();
            }
        });





    }
}