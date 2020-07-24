package vn.edu.ntu.quangloc.controller;

import java.util.List;

public interface INgoaiTe {
    public List<NgoaiTe> getAll();
    public void addItem(NgoaiTe ngoaiTe);
}
