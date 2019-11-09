package programa;

import dao.BancoDao;
import tela.Tela;
import tela.TelaConta;
import tela.TelaCorrentista;
import util.MasterUsuarioUtil;
import util.ScannerIntrface;
import util.UsuarioUtil;

public class Programa {

    public static BancoDao bancoDao;
    public static UsuarioUtil usuarioUtil;
    private static Tela telaCorrentista;
    private static Tela telaconta;
    private static ScannerIntrface scanner;

    public static void main(String[] args) {
        bancoDao = new BancoDao();
        scanner = new MasterUsuarioUtil();
        usuarioUtil = new MasterUsuarioUtil();


        telaCorrentista = new TelaCorrentista(bancoDao, scanner, usuarioUtil);
        telaconta = new TelaConta(bancoDao, scanner, usuarioUtil);


        while (true) {

            exibeMenulPrincipal();
        }
    }

    public static void exibeMenulPrincipal() {
        String msg =new StringBuffer()
                .append( "\n>>Menu principal\n")
                .append("\nEscolha uma opção\n")
                .append("\n1 -Correntista\n")
                .append("\n2- Conta\n")
                .append("\n3-Movimetno\n")
                .toString();
        usuarioUtil.exibeMensagem(msg);

        int opcao = Integer.parseInt(scanner.nextLine());
        if (opcao == 1) {

//            TelaCorrentista tela = new TelaCorrentista();
            telaCorrentista.exibeMenu();
        }
        if (opcao == 2) {
            telaconta.exibeMenu();
        }
    }

    public static void setTelaCorrentista(TelaCorrentista telaCorrentista) {
        Programa.telaCorrentista = telaCorrentista;
    }
}
