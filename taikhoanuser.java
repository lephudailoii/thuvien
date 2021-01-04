package com.example.thuvien;

public class taikhoanuser {

    Integer idtkuser;
    String tendangnhap;
    String pass;
    String hoten;
    String diachi;
    String email;

    public taikhoanuser(Integer idtkuser, String tendangnhap, String pass, String hoten, String diachi, String email) {
        this.idtkuser = idtkuser;
        this.tendangnhap = tendangnhap;
        this.pass = pass;
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
    }
    public taikhoanuser( String tendangnhap, String pass, String hoten, String diachi, String email) {

        this.tendangnhap = tendangnhap;
        this.pass = pass;
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
    }



    public Integer getIdtkuser() {
        return idtkuser;
    }

    public void setIdtkuser(Integer idtkuser) {
        this.idtkuser = idtkuser;
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

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
