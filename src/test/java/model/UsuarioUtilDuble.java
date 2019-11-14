package model;

import util.UsuarioUtil;

public class UsuarioUtilDuble extends UsuarioUtil {
    private int numeroChamadas = 0;

    public void exibeMensagem (String mensagem){

        this.numeroChamadas++;
        System.out.println(mensagem);
    }

    public int getNumeroChamadas(){
        return this.numeroChamadas;
    }
}
