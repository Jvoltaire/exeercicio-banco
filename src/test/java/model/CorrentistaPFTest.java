package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrentistaPFTest {

@Test
    public void deveriaRetornar (){

        Conta conta = new Conta (01, 787878);

        CorrentistaPF correntistaPF = new CorrentistaPF("Nome do Correntista", conta, "Rg Correntista", "Documento Correntista");

        String expected = "\nTipo de Conta\n" +
                "PF\n" +
                "Nome\n" +
                "Nome do Correntista\n" +
                "Conta\n" +
                "Agencia: 1. Conta: 787878\n" +
                "Tipo Documento\n" +
                "Rg Correntista\n" +
                "Documento\n" +
                "Documento Correntista";
        String obtido = correntistaPF.getDescricao();

        Assertions.assertEquals(expected, obtido);

    }


}