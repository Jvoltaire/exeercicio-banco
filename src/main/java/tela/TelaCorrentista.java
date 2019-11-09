package tela;

import dao.BancoDao;
import model.Conta;
import model.Correntista;
import model.CorrentistaPF;
import model.CorrentistaPJ;
import util.ScannerIntrface;
import util.UsuarioUtil;

import java.util.List;
import java.util.Scanner;

public class TelaCorrentista implements Tela {

    private BancoDao bancoDao;
    private ScannerIntrface scanner;
    private UsuarioUtil usuarioUtil;


    public TelaCorrentista(BancoDao bancoDao, ScannerIntrface scanner, UsuarioUtil usuarioUtil) {
//        bancoDao = new BancoDao();
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }


    public void imprime() {
        usuarioUtil.exibeMensagem("imprime");
    }

    @Override
    public void exibeMenu() {
////        trocar isso
//       usuarioUtil.exibeMensagem("Menu corretista");
//       usuarioUtil.exibeMensagem("Escolha uma opção");
//       usuarioUtil.exibeMensagem("1- Criar Correntista");
//       usuarioUtil.exibeMensagem("Lista corretista");

//        por isso:

        String mensagem = new StringBuffer()

                .append("Menu corretista")
                .append("Escolha uma opção")
                .append("1- Criar Correntista")
                .append(" 2- Lista corretista")
                .toString();
        usuarioUtil.exibeMensagem(mensagem);


        int opcao = new Scanner(System.in).nextInt();
        if (opcao == 1) {

            exibeMenuCriarCorretista();
        } else if (opcao == 2) {
            exibeMemuListaCorrentista();
        }
    }


    private void exibeMenuCriarCorretista() {

        usuarioUtil.exibeMensagem("Informe o nome do Correntista");
        String nome = this.scanner.nextLine();

        usuarioUtil.exibeMensagem("segue lista de contas disponiveis: ");
//        lista

        List<Conta> lista = this.bancoDao.listarContas();


        usuarioUtil.exibeMensagem("segue lista de contas disponiveis:");
        List<Conta> listaConta = this.bancoDao.listarContas();
        int posicao = 0;

        for (Conta C : listaConta) {
            posicao++;

            String descricao = new StringBuffer()
                    .append(posicao)
                    .append("- ")
                    .append(C.getAgencia())
                    .append(C.getDescricao())
                    .toString();

            usuarioUtil.exibeMensagem(descricao);
        }

        usuarioUtil.exibeMensagem("\nEscolha um numero da lista:\n ");
//        pedir para o usuario

        int posicaoEscolhida = Integer.parseInt(this.scanner.nextLine());

        Conta contaEscolhida = listaConta.get(posicaoEscolhida - 1);

//pedir tupo de conta

        usuarioUtil.exibeMensagem(("\nescolha um tipo de conta: pf pj\n"));
        String tipoConta = this.scanner.nextLine();

        if ("pf".equals(tipoConta)) {
            usuarioUtil.exibeMensagem("\ninforme o tipo de documento\n");
            String tipo = this.scanner.nextLine();

            usuarioUtil.exibeMensagem("\ninforme o tipo de documento\n");
            String doc = this.scanner.nextLine();


            bancoDao.adicionarCorrentista(
                    new CorrentistaPF(nome, contaEscolhida, tipo, doc)
            );


        } else if ("pJ".equalsIgnoreCase(tipoConta))
            bancoDao.adicionarCorrentista(new CorrentistaPJ(nome, contaEscolhida));


        else {
            throw new IllegalArgumentException("\ncorrentista cadastrado valido\n");
        }

        usuarioUtil.exibeMensagem("\ncorretista cadastrado com Sucesso\n");


    }

    private void exibeMemuListaCorrentista() {
        List<Correntista> lista = bancoDao.listarCorrentistas();
        usuarioUtil.exibeMensagem("\nLista de correntistas:\n");
        for (Correntista correntista : lista) {
            usuarioUtil.exibeMensagem(" - ".concat(correntista.getDescricao()));


        }
    }
}


