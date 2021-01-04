package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    dbhelper dbHelper;
    Button bntdangnhap,bntdangky,bntthuthu;
    EditText txttendangnhap,txtpass;
    ArrayList<taikhoan> listtaikhoan ;
    ArrayList<taikhoanuser> listtaikhoanuser;
    String ten,pass;
    dbhelper dbhelper;
    taikhoan tk,kt;
    Sach s;
    Integer dem = 0;
    Boolean a = false;
    Boolean b = false;
    taikhoanuser tku;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new dbhelper(MainActivity.this);
        dbHelper.createtaikhoanTable();
        dbHelper.createSachTable();
        dbHelper.createtkuser();
        dbHelper.createlistsachmuon();
        dbHelper.createPhieumuon();
        bntdangnhap = findViewById(R.id.btndndangnhap);
        bntthuthu = findViewById(R.id. bntdangnhaptt);
        bntdangky = findViewById(R.id.btndkdangky);
        txttendangnhap = findViewById(R.id.textdntendangnhap);
        txtpass=findViewById(R.id.textdnpass);
        listtaikhoan = new ArrayList<>();
        dbhelper= new dbhelper(MainActivity.this);
        listtaikhoan.addAll(dbhelper.gettaikhoan());
        bntdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, dangky.class);
                startActivity(intent);

            }
        });
        bntdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ten= txttendangnhap.getText().toString();
                pass= txtpass.getText().toString();
                listtaikhoan=dbhelper.gettaikhoan();
                int q = listtaikhoan.size();
                if(q==1){
                    tk=listtaikhoan.get(0);
                    String aa= tk.getTendangnhap();
                    String bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;}
                if(q==2){
                    tk=listtaikhoan.get(0);
                    String aa= tk.getTendangnhap();
                    String bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                    tk=listtaikhoan.get(1);
                    aa= tk.getTendangnhap();
                    bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                }
                if(q==3){
                    tk=listtaikhoan.get(0);
                    String aa= tk.getTendangnhap();
                    String bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                    tk=listtaikhoan.get(1);
                    aa= tk.getTendangnhap();
                    bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                    tk=listtaikhoan.get(2);
                    aa= tk.getTendangnhap();
                    bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                }
                if(a==true) {
                    {Intent intent = new Intent(MainActivity.this, AcThuThu.class);
                        startActivity(intent);}

                }
                else
                    Toast.makeText(MainActivity.this, "Sai tên tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();

           }
        });

        bntthuthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ten= txttendangnhap.getText().toString();
                pass= txtpass.getText().toString();
                listtaikhoan=dbhelper.gettaikhoan();
                int q = listtaikhoan.size();
                if(q==1){
                    tk=listtaikhoan.get(0);
                    String aa= tk.getTendangnhap();
                    String bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;}
                if(q==2){
                    tk=listtaikhoan.get(0);
                    String aa= tk.getTendangnhap();
                    String bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                    tk=listtaikhoan.get(1);
                    aa= tk.getTendangnhap();
                    bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                }
                if(q==3){
                    tk=listtaikhoan.get(0);
                    String aa= tk.getTendangnhap();
                    String bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                    tk=listtaikhoan.get(1);
                    aa= tk.getTendangnhap();
                    bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                    tk=listtaikhoan.get(2);
                    aa= tk.getTendangnhap();
                    bb = tk.getPass();
                    if(ten.equals(aa) && pass.equals(bb))
                        a=true;
                    else a=false;
                }
                if(a==true) {
                    {Intent intent = new Intent(MainActivity.this, AcThuThu.class);
                        startActivity(intent);}

                }
                else
                    Toast.makeText(MainActivity.this, "Sai tên tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public  void KTuserKH() {
        for(int j=0;j>listtaikhoanuser.size();j++)
        {  tku=listtaikhoanuser.get(j);
            String aa= tku.getTendangnhap();
            String bb = tku.getPass();
            if(ten == aa & pass == bb)
            {b=true;}}
    }
    public void KTuserTT(){
        for(int i=0;i>listtaikhoan.size();i++)
        {tk=listtaikhoan.get(i);
            String aaa= tk.getTendangnhap();
            String bbb = tk.getPass();
            if(ten == aaa & pass == bbb)
            {a=true;}
        }
    }
}