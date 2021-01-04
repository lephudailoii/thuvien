package com.example.thuvien;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class dbhelper {
    Context context;
    String dbsach = "BangSach.db";

    public dbhelper(Context context) {
        this.context = context;
    }
    private static final int DB_VERSION = 2;
    private SQLiteDatabase openDB() {
        return context.openOrCreateDatabase(dbsach, Context.MODE_PRIVATE, null);
    }
    private void closeDB(SQLiteDatabase db) {
        db.close();
    }

    public void createSachTable() {
        SQLiteDatabase db = openDB();
        String sql = "create table if not exists tblSach(" +
                "idsach integer PRIMARY KEY autoincrement, " +
                "masach text," +
                "tensach text," +
                "tacgia text, " +
                "giatien integer," +
                "theloai text," +
                "namxuatban integer," +
                "nhaxuatban text" +
                ");";
        db.execSQL(sql);
        closeDB(db);
    }
    public ArrayList<Sach> getSachs() {
        SQLiteDatabase db = openDB();
        ArrayList<Sach> arr = new ArrayList<>();
        String sql = "select * from tblSach";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int idSach = csr.getInt(0);
                    String masach = csr.getString(1);
                    String tenSach = csr.getString(2);
                    String tacGia = csr.getString(3);
                    int gia = csr.getInt(4);
                    String theloai = csr.getString(5);
                    int namxb = csr.getInt(6);
                    String nhaxb = csr.getString(7);
                    arr.add(new Sach(idSach,masach,tenSach,tacGia,gia,theloai,namxb,nhaxb));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }
    public void insertSach(Sach sach) {
        SQLiteDatabase db = openDB();
        ContentValues cv = new ContentValues();
        cv.put("idsach", sach.idSach);
        cv.put("masach",sach.masach);
        cv.put("tensach", sach.tenSach);
        cv.put("tacgia", sach.tacGia);
        cv.put("giatien", sach.gia);
        cv.put("theloai", sach.theloai);
        cv.put("namxuatban", sach.namxuatban);
        cv.put("nhaxuatban", sach.nhaxuatban);
        db.insert("tblSach", null, cv);
        closeDB(db);
    }
    public void createtaikhoanTable() {
        SQLiteDatabase db = openDB();
        String sql = "create table if not exists tblTaiKhoan(" +
                "idtaikhoan integer PRIMARY KEY autoincrement, " +
                "tendangnhap text," +
                "password text" +
                ");";
        db.execSQL(sql);
        closeDB(db);
    }

    public ArrayList<taikhoan> gettaikhoan() {
        SQLiteDatabase db = openDB();
        ArrayList<taikhoan> arr = new ArrayList<>();
        String sql = "select * from tblTaiKhoan";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int idtaikhoan = csr.getInt(0);
                    String tendangnhap = csr.getString(1);
                    String pass = csr.getString(2);
                    arr.add(new taikhoan(idtaikhoan,tendangnhap,pass));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }
    public void inserttaikhoan(taikhoan tk) {
        SQLiteDatabase db = openDB();
        ContentValues cv = new ContentValues();
        cv.put("idtaikhoan", tk.idtaikhoan);
        cv.put("tendangnhap", tk.tendangnhap);
        cv.put("password", tk.pass);
        db.insert("tblTaiKhoan", null, cv);
        closeDB(db);
    }
    public void deleteSach(Sach user) {
        String[] id = {String.valueOf(user.idSach)};
        SQLiteDatabase db = openDB();
        db.delete("tblSach", "idsach = ?", id);
        closeDB(db);
    }
    public void updateSach(Sach sach) {
        SQLiteDatabase db = openDB();
        ContentValues cv = new ContentValues();
        cv.put("idsach", sach.idSach);
        cv.put("masach",sach.masach);
        cv.put("tensach", sach.tenSach);
        cv.put("tacgia", sach.tacGia);
        cv.put("giatien", sach.gia);
        cv.put("theloai", sach.theloai);
        cv.put("namxuatban", sach.namxuatban);
        cv.put("nhaxuatban", sach.nhaxuatban);
        String[] id = {String.valueOf(sach.idSach)};
        int row = db.update("tblSach", cv, "idsach = ?", id);
        closeDB(db);
    }


    public void createtkuser() {
        SQLiteDatabase db = openDB();
        String sql = "create table if not exists tbltaikhoanuser(" +
                "idtaikhoanuser integer PRIMARY KEY autoincrement, " +
                "tendangnhap text," +
                "password text," +
                "hoten text," +
                "diachi text," +
                "email text" +
                ");";
        db.execSQL(sql);
        closeDB(db);
    }
    public void inserttaikhoanuser(taikhoanuser tk) {
        SQLiteDatabase db = openDB();
        ContentValues cv = new ContentValues();
        cv.put("idtaikhoanuser", tk.idtkuser);
        cv.put("tendangnhap", tk.tendangnhap);
        cv.put("password", tk.pass);
        cv.put("hoten", tk.hoten);
        cv.put("diachi", tk.diachi);
        cv.put("email", tk.email);
        db.insert("tbltaikhoanuser", null, cv);
        closeDB(db);
    }
    public ArrayList<taikhoanuser> gettaikhoanuser() {
        SQLiteDatabase db = openDB();
        ArrayList<taikhoanuser> arr = new ArrayList<>();
        String sql = "select * from tbltaikhoanuser";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int idtaikhoan = csr.getInt(0);
                    String tendangnhap = csr.getString(1);
                    String pass = csr.getString(2);
                    String hoten = csr.getString(3);
                    String diachi = csr.getString(4);
                    String email = csr.getString(5);
                    arr.add(new taikhoanuser(idtaikhoan,tendangnhap,pass,hoten,diachi,email));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }
    public void createPhieumuon() {
        SQLiteDatabase db = openDB();
        String sql = "create table if not exists tblphieumuon(" +
                "idpm integer PRIMARY KEY autoincrement, " +
                "hoten text," +
                "ngaymuon text" +

                ");";
        db.execSQL(sql);
        closeDB(db);
    }
    public void insertphieumuon(clphieumuon tk) {
        SQLiteDatabase db = openDB();
        ContentValues cv = new ContentValues();
        cv.put("idpm", tk.idpm);
        cv.put("hoten", tk.ten);
        cv.put("ngaymuon", tk.ngaymuon);

        db.insert("tblphieumuon", null, cv);
        closeDB(db);
    }
    public void deletephieumuon(clphieumuon user) {
        String[] id = {String.valueOf(user.idpm)};
        SQLiteDatabase db = openDB();
        db.delete("tblphieumuon", "idpm = ?", id);
        closeDB(db);
    }
    public ArrayList<clphieumuon> getphieumuon() {
        SQLiteDatabase db = openDB();
        ArrayList<clphieumuon> arr = new ArrayList<>();
        String sql = "select * from tblphieumuon";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int idpm = csr.getInt(0);
                    String ten = csr.getString(1);
                    String ngaymuon = csr.getString(2);

                    arr.add(new clphieumuon(idpm,  ten, ngaymuon));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }
    public void createlistsachmuon() {
        SQLiteDatabase db = openDB();
        String sql = "create table if not exists tbllistsachmuon(" +
                "idsm integer PRIMARY KEY autoincrement, " +
                "idpm integer , " +
                "masach text," +
                "tensach text," +
                "tacgia text, " +
                "theloai text"+
                ");";
        db.execSQL(sql);
        closeDB(db);
    }
    public void insertlistsachmuon(listsachmuon tk) {
        SQLiteDatabase db = openDB();
        ContentValues cv = new ContentValues();
        cv.put("idsm", tk.idsm);
        cv.put("idpm", tk.idpm);
        cv.put("masach", tk.masach);
        cv.put("tensach", tk.tensach);
        cv.put("tacgia", tk.tacgia);
        cv.put("theloai", tk.theloai);
        db.insert("tbllistsachmuon", null, cv);
        closeDB(db);
    }
    public ArrayList<listsachmuon> getlistsachmuons(int uId) {
        SQLiteDatabase db = openDB();
        ArrayList<listsachmuon> arr = new ArrayList<>();
        String sql = "select * from tbllistsachmuon where idpm = "+ uId;
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int idsm = csr.getInt(0);
                    int idpm = csr.getInt(1);
                    String masach = csr.getString(2);
                    String tensach = csr.getString(3);
                    String theloai = csr.getString(4);
                    String tacgia = csr.getString(5);
                    arr.add(new listsachmuon(idsm,idpm,  masach,  tensach, theloai,  tacgia));
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public void deletelistsm(listsachmuon user) {
        String[] id = {String.valueOf(user.idsm)};
        SQLiteDatabase db = openDB();
        db.delete("tbllistsachmuon", "idsm = ?", id);
        closeDB(db);
    }
    private ArrayList<listsachmuon> getlistsachmuon(int uId) {
        ArrayList<listsachmuon> arr = new ArrayList<>();
        String sql="Select * from tbllistsachmuon where idpm = "+ uId;
        SQLiteDatabase db = openDB();
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null)
            csr.moveToFirst();
        int idsm = csr.getInt(0);
        int idpm = csr.getInt(1);
        String masach = csr.getString(2);
        String tensach = csr.getString(3);
        String theloai = csr.getString(4);
        String tacgia = csr.getString(5);
        arr.add(new listsachmuon(idsm,idpm,  masach,  tensach, theloai,  tacgia));
        closeDB(db);
        return arr;
}
    public ArrayList<String> getSachten() {
        SQLiteDatabase db = openDB();
        ArrayList<String> arr = new ArrayList<>();
        String sql = "select * from tblSach";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
//                    int idSach = csr.getInt(0);
//                    String masach = csr.getString(1);
                    String tenSach = csr.getString(2);
//                    String tacGia = csr.getString(3);
//                    int gia = csr.getInt(4);
//                    String theloai = csr.getString(5);
//                    int namxb = csr.getInt(6);
//                    String nhaxb = csr.getString(7);
                    arr.add(tenSach);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }
}
