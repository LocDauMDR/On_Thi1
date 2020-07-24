package vn.edu.ntu.quangloc.model;

public class NT {
    private String date;
    private String type1;
    private String type2;
    private int mua;
    private int ban;

    public NT(String date, String type1, String type2, int mua, int ban) {
        this.date = date;
        this.type1 = type1;
        this.type2 = type2;
        this.mua = mua;
        this.ban = ban;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getMua() {
        return mua;
    }

    public void setMua(int mua) {
        this.mua = mua;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }
}
