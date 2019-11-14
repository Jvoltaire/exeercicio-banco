package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ContaTest {


    @Test
    public void deveriaRetornar (){
        Conta conta = new Conta (01, 787878);
        String expected = "Agencia: 1. Conta: 787878";
        String obtido = conta.getDescricao();

        Assertions.assertEquals(expected, obtido);

    }




}





