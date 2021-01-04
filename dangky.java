package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class dangky extends AppCompatActivity {

    EditText txttendangnhap,txtpass,txthoten,txtdiachi,txtemail;
    Button btndk,btnthoat;
    dbhelper dbHelper;
    String tendn,pass,hoten,diachi,email;
    taikhoanuser tk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        btndk = findViewById(R.id.btndkdangky);
        btnthoat = findViewById(R.id.bntdkthoat);
        txttendangnhap = findViewById(R.id.textdktendn);
        txtpass = findViewById(R.id.textdkpass);
        txthoten = findViewById(R.id.txtdkhoten);
        txtdiachi= findViewById(R.id.txtdkdiachi);
        txtemail=findViewById(R.id.txtdkemail);
        dbHelper = new dbhelper(dangky.this);


        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dangky.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tendn = txttendangnhap.getText().toString();
                pass = txtpass.getText().toString();
                hoten = txthoten.getText().toString();
                diachi =txtdiachi.getText().toString();
                email=txtemail.getText().toString();
                tk = new taikhoanuser(tendn,pass,hoten,diachi,email);
                dbHelper.inserttaikhoanuser(tk);
                Toast.makeText(dangky.this, "Đã Đăng Ký", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(dangky.this,MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}