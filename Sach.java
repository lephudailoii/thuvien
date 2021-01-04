package com.example.thuvien;

import java.io.Serializable;

public class Sach implements Serializable {
    Integer idSach;
    String masach;
    String tenSach;
    String tacGia;
    Integer gia;
    String theloai;
    Integer namxuatban;
    String nhaxuatban;

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public Integer getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(Integer namxuatban) {
        this.namxuatban = namxuatban;
    }

    public String getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(String nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }





    public Sach(Integer idSach,String masach, String tenSach, String tacGia, Integer gia, String theloai, Integer namxuatban, String nhaxuatban ) {
        this.idSach = idSach;
        this.masach = masach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.gia = gia;
        this.theloai = theloai;
        this.namxuatban = namxuatban;
        this.nhaxuatban = nhaxuatban;

    }



    public Sach() {
    }
    public Sach(Integer gia) {
        this.gia = gia;
    }



    public Sach(Integer idSach, String tenSach, String tacGia, Integer gia, String theloai
            ) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.gia = gia;
        this.theloai = theloai;

    }
    public Sach( String masach,String tenSach, String tacGia, Integer gia, String theloai,Integer namxuatban, String nhaxuatban) {
        this.masach = masach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.gia = gia;
        this.theloai = theloai;
        this.namxuatban = namxuatban;
        this.nhaxuatban = nhaxuatban;
    }



    public Integer getIdSach() {
        return idSach;
    }

    public void setIdSach(Integer idSach) {
        this.idSach = idSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }










}