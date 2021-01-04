package com.example.thuvien;

import java.util.ArrayList;

public class clphieumuon {
    Integer idpm;
    String ten;
    String ngaymuon;


    public clphieumuon(Integer idpm, String ten, String ngaymuon) {
        this.idpm = idpm;
        this.ten = ten;
        this.ngaymuon = ngaymuon;

    }


    public Integer getIdpm() {
        return idpm;
    }

    public void setIdpm(Integer idpm) {
        this.idpm = idpm;
    }



    public clphieumuon(String ten, String ngaymuon) {
        this.ten = ten;
        this.ngaymuon = ngaymuon;

    }



    public clphieumuon() {
    }



    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }




}
