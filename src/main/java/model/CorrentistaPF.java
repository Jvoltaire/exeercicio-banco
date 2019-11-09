package model;

public class CorrentistaPF extends Correntista {

    private String tipoDocumento;
    private String documento;
    private static final String TIPO_CONTA = "PF";

    public CorrentistaPF(String nome, Conta conta,String tipoDocumento, String documento){
        super(nome, conta);

        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    public String getDescricao(){
        return new StringBuffer()
                .append ("\ntipo de conta\n")
                .append(TIPO_CONTA)
                .append("\nnome\n")
                .append(super.getNome())
                .append("\nconta\n")
                .append(this.getConta())
                .append("\ntipo documento\n")
                .append(this.tipoDocumento)
                .append("\ndocumento\n")
                .append(this.documento)
                .toString();
    }

}
