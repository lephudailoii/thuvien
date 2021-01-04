package com.example.thuvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Sachadapter extends ArrayAdapter<Sach> {

    Context context;
    ArrayList<Sach> arrayList;
    int layout;

    public Sachadapter(@NonNull Context context, int resource, @NonNull ArrayList<Sach> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layout = resource;

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(layout,null,false);
        Sach sach = arrayList.get(position);
        TextView texttensach = convertView.findViewById(R.id.txttensach);
        TextView texttacgia = convertView.findViewById(R.id.texttacgiaadd);
        TextView texttheloai = convertView.findViewById(R.id.txttheloai);


        texttensach.setText("TÊN SÁCH : "+sach.getTenSach());
        texttacgia.setText("TÁC GIẢ : "+sach.getTacGia());
        texttheloai.setText("THỂ LOẠI : "+sach.getTheloai());
        return convertView;
    }
}
