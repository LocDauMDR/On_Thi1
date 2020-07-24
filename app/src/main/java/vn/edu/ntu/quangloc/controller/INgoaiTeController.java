package vn.edu.ntu.quangloc.controller;

import java.util.List;

import vn.edu.ntu.quangloc.model.NgoaiTe;

public interface INgoaiTeController {
    public List<NgoaiTe> getAll();
    public void addItem(NgoaiTe ngoaiTe);
}
