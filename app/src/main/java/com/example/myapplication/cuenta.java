package com.example.myapplication;

import java.io.Serializable;

public class cuenta<nCuenta> implements Serializable {

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

