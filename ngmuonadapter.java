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

public class ngmuonadapter extends ArrayAdapter<clphieumuon> {

    Context context;
    ArrayList<clphieumuon> arrayList;
    int layout;

    public ngmuonadapter(@NonNull Context context, int resource, @NonNull ArrayList<clphieumuon> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layout = resource;

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(layout,null,false);
        clphieumuon ngmuon = arrayList.get(position);
        TextView textid = convertView.findViewById(R.id.txtidpmad);
        TextView textten = convertView.findViewById(R.id.txttenngmuonad);



        textid.setText("IDPM : "+ngmuon.getIdpm());
        textten.setText("TÊN NGƯỜI MƯỢN : "+ngmuon.getTen());
        return convertView;
    }
}
