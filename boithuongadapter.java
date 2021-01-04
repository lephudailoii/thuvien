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

public class boithuongadapter extends ArrayAdapter<listsachmuon> {

    Context context;
    ArrayList<listsachmuon> arrayList;
    int layout;

    public boithuongadapter(@NonNull Context context, int resource, @NonNull ArrayList<listsachmuon> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layout = resource;

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(layout,null,false);
        listsachmuon listsachmuon = arrayList.get(position);
        TextView texttensach = convertView.findViewById(R.id.txttensach);
        TextView texttacgia = convertView.findViewById(R.id.texttacgiaadd);
        TextView texttheloai = convertView.findViewById(R.id.txttheloai);


        texttensach.setText("TÊN SÁCH : "+listsachmuon.getTensach());
        texttacgia.setText("TÁC GIẢ : "+listsachmuon.getTacgia());
        texttheloai.setText("THỂ LOẠI : "+listsachmuon.getTheloai());
        return convertView;
    }
}
