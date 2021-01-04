package com.example.thuvien;

public class taikhoan {
    int idtaikhoan;



    String tendangnhap;
    String pass;

    public taikhoan() {
    }
    public taikhoan(int idtaikhoan, String tendangnhap, String pass) {
        this.idtaikhoan = idtaikhoan;
        this.tendangnhap = tendangnhap;
        this.pass = pass;
    }

    public taikhoan( String tendangnhap, String pass) {

        this.tendangnhap = tendangnhap;
        this.pass = pass;
    }



    public int getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(int idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
