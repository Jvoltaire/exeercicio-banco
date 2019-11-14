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
                .append ("\nTipo de Conta\n")
                .append(TIPO_CONTA)
                .append("\nNome\n")
                .append(super.getNome())
                .append("\nConta\n")
                .append(this.getConta().getDescricao())
                .append("\nTipo Documento\n")
                .append(this.tipoDocumento)
                .append("\nDocumento\n")
                .append(this.documento)
                .toString();
    }

}
