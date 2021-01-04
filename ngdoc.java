package com.example.thuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class ngdoc extends AppCompatActivity {
    ArrayList<Sach> listsach ;
    dbhelper dbhelper;
    ListView lv;
    Sachadapter sachadapter;
    ArrayAdapter arr;
    SearchView sv;
    Sach sach;
    Integer vitri;
    Button bnt;
    ArrayList<String> listten;
    Adapter adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngdoc);
        lv = findViewById(R.id.listsachngdoc);
        listten = new ArrayList<>();
        sv = findViewById(R.id.sv);
        bnt = findViewById(R.id.ngdocchitiet);
        listsach = new ArrayList<>();
        dbhelper= new dbhelper(ngdoc.this);
       listten.addAll(dbhelper.getSachten());
       listsach.addAll(dbhelper.getSachs());

        arr = new ArrayAdapter(ngdoc.this,R.layout.support_simple_spinner_dropdown_item, listten);
        lv.setAdapter(arr);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arr.getFilter().filter(newText);
                return false;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
               String ten ;
                ten = listten.get(position);

                Toast.makeText(ngdoc.this, "Đã Chọn : " + ten, Toast.LENGTH_SHORT).show();
            }
        });
        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sach = new Sach();
                sach = listsach.get(vitri);
                Intent intent = new Intent(ngdoc.this,chitietsach.class);
                intent.putExtra("sach",sach);
                startActivity(intent);
            }
        });
    }
}