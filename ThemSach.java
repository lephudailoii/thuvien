package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemSach extends AppCompatActivity {
    EditText txtten,txtgia,txttacgia,txttheloai,txtmasach,txtnamxb,txtnhaxb;
    Button add;
    String ten,tacgia,theloai,masach,nhaxb;
    int gia,namxb;
    dbhelper dbHelper;
    Sach a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
        txtgia = findViewById(R.id.textgiatienadd);
        txttacgia = findViewById(R.id.texttacgiaadd);
        txtten = findViewById(R.id.texttensaschadd);
        txttheloai = findViewById(R.id.texttheloaiadd);
        txtmasach = findViewById(R.id.textmasachadd);
        txtnamxb = findViewById(R.id.textnamxbadd);
        txtnhaxb = findViewById(R.id.textnhaxbadd);
        add = findViewById(R.id.addsach);
        dbHelper= new dbhelper(ThemSach.this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ten = txtten.getText().toString();
                tacgia = txttacgia.getText().toString();
                theloai = txttheloai.getText().toString();
                gia = Integer.parseInt(txtgia.getText().toString());
                masach= txtmasach.getText().toString();
                nhaxb=txtnhaxb.getText().toString();
                namxb=Integer.parseInt(txtnamxb.getText().toString());
                a= new Sach(masach,ten,tacgia,gia,theloai,namxb,nhaxb);
                dbHelper.insertSach(a);
                Toast.makeText(ThemSach.this, "Đã Thêm", Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(ThemSach.this, AcThuThu.class);
//                startActivity(intent);
            }
        });
    }
}