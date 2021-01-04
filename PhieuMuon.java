package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhieuMuon extends AppCompatActivity {
    dbhelper dbHelper;
    TextView    txtmasach,txttensach,txttheloai,txttacgia;
    EditText txthoten,txtngay;
    Button bntaddsach,bnthuy,bntlapphieu;
    String hoten,ngay,masach,tensach,theloai,tacgia;
    ArrayList<clphieumuon> listpm = new ArrayList<clphieumuon>();
    ArrayList<listsachmuon> listsm = new ArrayList<listsachmuon>();
    ArrayList<Sach> listsach = new ArrayList<Sach>();
    Integer idtam,idsm,idsach;
    listsachmuon lsm,lsm2,lsm3,lsm4;
    Spinner spinner;
    ArrayList<String> listtensach = new ArrayList<String>();
    ArrayList<String> listtheloai = new ArrayList<String>();
    ArrayList<String> listtacgia = new ArrayList<String>();
    ArrayList<String> listmasach = new ArrayList<String>();
    ArrayList<Integer> listidsach = new ArrayList<Integer>();
    Sach sach;
    String theloaisach,tensachh;



    clphieumuon pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phieu_muon);
        dbHelper = new dbhelper(PhieuMuon.this);
        bntaddsach = findViewById(R.id.bntpmthemsach);
        bnthuy = findViewById(R.id.bntpmthoat);
        bntlapphieu = findViewById(R.id.bntpmlapphieu);
        spinner = findViewById(R.id.spinner);
        txthoten= findViewById(R.id.edpmhoten);
        txtmasach=findViewById(R.id.edpmmasach);
        txtngay = findViewById(R.id.edpmngaymuon);
        txttacgia=findViewById(R.id.edpmtacgia);
        txttheloai=findViewById(R.id.edpmtheloai);
        listsach.addAll(dbHelper.getSachs());

        for(int i=0;i<listsach.size();i++)
        {
            sach = new Sach();
            sach = listsach.get(i);
            tensach = sach.getTenSach();
            listtensach.add(tensach);
        }
        for(int i=0;i<listsach.size();i++)
        {
            sach = new Sach();
            sach = listsach.get(i);
            String cc;
            cc = sach.getMasach();
            listmasach.add(cc);
        }
        for(int i=0;i<listsach.size();i++)
        {
            sach = new Sach();
            sach = listsach.get(i);
            String pp = sach.getTacGia();
            listtacgia.add(pp);
        }
        for(int i=0;i<listsach.size();i++)
        {
            sach = new Sach();
            sach = listsach.get(i);
            idsach = sach.getIdSach();
            listidsach.add(idsach);
        }
        for(int i=0;i<listsach.size();i++)
        {
            sach = new Sach();
            sach = listsach.get(i);
            theloaisach = sach.getTheloai();
            listtheloai.add(theloaisach);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listtensach);
        spinner.setAdapter(arrayAdapter);
        listpm.addAll(dbHelper.getphieumuon());
        idtam = listpm.size();
        idtam++;
        bntaddsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listsm.size()>=4)
                {Toast.makeText(PhieuMuon.this, "Đã quá 4 quyển sách", Toast.LENGTH_SHORT).show();}
                else{
                idsm=idtam;
                masach = txtmasach.getText().toString();
                tacgia =txttacgia.getText().toString();
                theloai =txttheloai.getText().toString();
                lsm = new listsachmuon(idtam,tensachh,masach,theloai,tacgia);
                listsm.add(lsm);
                String a = String.valueOf(idtam);
                Toast.makeText(PhieuMuon.this, a, Toast.LENGTH_SHORT).show();}}



        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    tensachh = listtensach.get(position);
                   String ll,masach1,tacgia1;
                     ll=listtheloai.get(position);
                        txttheloai.setText(ll);
                     masach1=listmasach.get(position);
                        txtmasach.setText(masach1);
                        tacgia1=listtacgia.get(position);
                        txttacgia.setText(tacgia1);
                    }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bnthuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();

            }
        });
        bntlapphieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoten=txthoten.getText().toString();
                ngay=txtngay.getText().toString();
                int i=listsm.size();
                String idtamm = String.valueOf(idtam);
                if(i==1)
                { lsm = new listsachmuon();
                    lsm=listsm.get(0);
                    dbHelper.insertlistsachmuon(lsm);}
                else if(i==2)
                { lsm = new listsachmuon();
                    lsm=listsm.get(0);
                    dbHelper.insertlistsachmuon(lsm);
                    lsm2 = new listsachmuon();
                    lsm2=listsm.get(1);
                    dbHelper.insertlistsachmuon(lsm2);}
                else if(i==3)
                { lsm = new listsachmuon();
                    lsm=listsm.get(0);
                    dbHelper.insertlistsachmuon(lsm);
                    lsm2 = new listsachmuon();
                    lsm2=listsm.get(1);
                    dbHelper.insertlistsachmuon(lsm2);
                    lsm3 = new listsachmuon();
                    lsm3=listsm.get(2);
                    dbHelper.insertlistsachmuon(lsm3);}
                else if(i==4)
                { lsm = new listsachmuon();
                    lsm=listsm.get(0);
                    dbHelper.insertlistsachmuon(lsm);
                    lsm2 = new listsachmuon();
                    lsm2=listsm.get(1);
                    dbHelper.insertlistsachmuon(lsm2);
                    lsm3 = new listsachmuon();
                    lsm3=listsm.get(2);
                    dbHelper.insertlistsachmuon(lsm3);
                    lsm4 = new listsachmuon();
                    lsm4=listsm.get(3);
                    dbHelper.insertlistsachmuon(lsm4);}
                pm = new clphieumuon(idtam,hoten,ngay);
                dbHelper.insertphieumuon(pm);
                Toast.makeText(PhieuMuon.this, idtamm, Toast.LENGTH_SHORT).show();
               finish();


            }
        });
    }
}