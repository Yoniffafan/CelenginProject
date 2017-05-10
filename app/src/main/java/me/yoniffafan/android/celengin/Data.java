package me.yoniffafan.android.celengin;

import android.widget.ListView;

import java.util.List;

/**
 * Created by AndikaWahyu on 10/05/2017.
 */

public class Data {
    public List<String> mimpi;
    public List<String> gambar;
    public List<Integer> total;

    public Data() {
    }

    public Data(List<String> mimpi, List<String> gambar, List<Integer> total) {
        this.mimpi = mimpi;
        this.gambar = gambar;
        this.total = total;
    }

    public List<String> getMimpi() {
        return mimpi;
    }

    public void setMimpi(List<String> mimpi) {
        this.mimpi = mimpi;
    }

    public List<String> getGambar() {
        return gambar;
    }

    public void setGambar(List<String> gambar) {
        this.gambar = gambar;
    }

    public List<Integer> getTotal() {
        return total;
    }

    public void setTotal(List<Integer> total) {
        this.total = total;
    }

    //    public String mimpi;
//    public String gambar;
//    public int total;
//
//    public Data() {
//    }
//
//    public Data(String nama, String gambar, int harga) {
//        this.mimpi = nama;
//        this.gambar = gambar;
//        this.total = harga;
//    }
//
//    public String getMimpi() {
//        return mimpi;
//    }
//
//    public void setMimpi(String nama) {
//        this.mimpi = nama;
//    }
//
//    public String getGambar() {
//        return gambar;
//    }
//
//    public void setGambar(String gambar) {
//        this.gambar = gambar;
//    }
//
//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(int harga) {
//        this.total = harga;
//    }
}
