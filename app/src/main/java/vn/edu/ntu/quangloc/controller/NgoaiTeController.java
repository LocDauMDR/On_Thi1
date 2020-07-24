package vn.edu.ntu.quangloc.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangloc.model.NgoaiTe;

public class NgoaiTeController extends Application implements INgoaiTeController {
    List<NgoaiTe> list = new ArrayList<>();

    public NgoaiTeController() {
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
