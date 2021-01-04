package com.example.thuvien;

import java.net.Inet4Address;

public class listsachmuon  {
    Integer idsm;
    Integer idpm;
    String masach;
    String tensach;
    String theloai;
    String tacgia;

    public listsachmuon() {
    }



    public Integer getIdpm() {
        return idpm;
    }

    public void setIdpm(Integer idpm) {
        this.idpm = idpm;
    }


    public listsachmuon(Integer idsm,  Integer idpm,String masach, String tensach, String theloai, String tacgia) {
        this.idsm = idsm;;
        this.idpm=idpm;
        this.masach = masach;
        this.tensach = tensach;
        this.theloai = theloai;
        this.tacgia = tacgia;
    }
    public listsachmuon(Integer idsm,String masach,  String theloai, String tacgia) {
        this.idsm = idsm;;

        this.masach = masach;
        this.theloai = theloai;
        this.tacgia = tacgia;
    }
    public listsachmuon( Integer idpm, String masach, String tensach, String theloai, String tacgia) {
        this.idpm=idpm;
        this.masach = masach;
        this.tensach = tensach;
        this.theloai = theloai;
        this.tacgia = tacgia;
    }




    public Integer getIdsm() {
        return idsm;
    }

    public void setIdsm(Integer idsm) {
        this.idsm = idsm;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }




}
