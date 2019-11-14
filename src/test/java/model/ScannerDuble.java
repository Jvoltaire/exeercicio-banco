package model;

import util.ScannerIntrface;

public class ScannerDuble implements ScannerIntrface {
    private int numeroChamadas = 0;

    @Override

    public String nextLine(){
    System.out.println("chamou o duble:" + numeroChamadas);
        return "10";
    }

    public int getNumeroChamadas(){

        return numeroChamadas;
    }

}
