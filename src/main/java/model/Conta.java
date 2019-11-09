package model;

import java.math.BigDecimal;
import java.util.List;

public class Conta {

    private Integer agencia;
    private Integer numero;
    private BigDecimal saldo;
    private List <Movimento> movimento;

    public Conta (Integer agencia, Integer numero){

        this.agencia = agencia;
        this.numero = numero;
    }
    public String getDescricao(){
        return new StringBuffer()

                .append("- agencia:")
                .append(this.getAgencia())
                .append("-Conta")
                .append(this.getNumero())
                .toString();


    }


    public Integer getAgencia(){
        return this.agencia;

    }
        public Integer getNumero(){
            return this.numero;

    }

}

