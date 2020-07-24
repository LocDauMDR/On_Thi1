package vn.edu.ntu.quangloc.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class NgoaiTe extends Application implements INgoaiTe {
    List<NgoaiTe> list = new ArrayList<>();

    public NgoaiTe() {
    }

    @Override
    public List<NgoaiTe> getAll() {
        return list;
    }

    @Override
    public void addItem(NgoaiTe ngoaiTe) {
        list.add(ngoaiTe);
    }
}
