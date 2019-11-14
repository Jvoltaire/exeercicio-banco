package tela;

import dao.BancoDao;
import model.Conta;
import util.ScannerIntrface;
import util.UsuarioUtil;

import java.util.List;

public class TelaConta  implements Tela{
    private UsuarioUtil usuarioUtil;
    private BancoDao bancoDao;
    private ScannerIntrface scanner;

    public TelaConta(BancoDao bancoDao,ScannerIntrface scanner, UsuarioUtil usuarioUtil) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;


//    this.bancoDao= new BancoDao();
    }
@Override
    public void exibeMenu() {

    String msg = new StringBuffer()

            .append("\nMenu Conta\n")
            .append("\nEscolha uma opção\n")
            .append("\n1-Criar Conta\n")
            .append("\n2-Lista Contas\n").toString();


    usuarioUtil.exibeMensagem(msg);


        int opcao = Integer.parseInt(this.scanner.nextLine());

        if (opcao == 1) {
            exibeMenuCriarConta();

        } else if (opcao == 2) {
            exibeMenuListarConta();
        }

    }

    public void exibeMenuCriarConta() {
        usuarioUtil.exibeMensagem("\nInforme o numero da Agencia\n");
        int agencia = Integer.parseInt(this.scanner.nextLine());

//        usuarioUtil.exibeMensagem("\nsegue lista de contas disponiveis:\n");
//        List<Conta> listaConta = this.bancoDao.listarContas();
//        int posicao = 0;

        usuarioUtil.exibeMensagem("\nInforme o numero\n");
        int conta = Integer.parseInt(this.scanner.nextLine());


        this.bancoDao.adicionarConta(new Conta(agencia, conta));
        usuarioUtil.exibeMensagem("\nAdicionado com sucesso\n");

    }

    public void exibeMenuListarConta() {

        List<Conta> lista = this.bancoDao.listarContas();


        usuarioUtil.exibeMensagem("\nLista de contas:\n");

        for (Conta conta : lista) {
//            String descricao = new StringBuffer()
//                    .append(Conta.getDescricao())
//                    .toString();
//
            usuarioUtil.exibeMensagem(conta.getDescricao());
        }
    }


}


