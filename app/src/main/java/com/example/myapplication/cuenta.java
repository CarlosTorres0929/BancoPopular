package com.example.myapplication;

public class cuenta {

    private int nCuenta,usaldo;
    private String tpCuenta;

    public cuenta() {

    }

    public cuenta(int nCuenta, int usaldo, String tpCuenta) {
        this.nCuenta = nCuenta;
        this.usaldo = usaldo;
        this.tpCuenta = tpCuenta;
    }

    public int getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(int nCuenta) {
        this.nCuenta = nCuenta;
    }

    public int getUsaldo() {
        return usaldo;
    }

    public void setUsaldo(int usaldo) {
        this.usaldo = usaldo;
    }

    public String getTpCuenta() {
        return tpCuenta;
    }

    public void setTpCuenta(String tpCuenta) {
        this.tpCuenta = tpCuenta;
    }


}

