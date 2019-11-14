package tela;

import dao.BancoDao;
import model.Conta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import util.ScannerIntrface;
import util.UsuarioUtil;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TelaContaTest {

    @Mock
    private UsuarioUtil usuarioUtil;

    @Mock
    private ScannerIntrface scanner;

    @Mock
    private BancoDao bancoDao;


    @Test

    public void deveriaRetornar() {

        //Arrange
        Mockito.doReturn("55").when(scanner).nextLine();

        //act
        new TelaConta(bancoDao, scanner, usuarioUtil).exibeMenuCriarConta();

        //Assert
        Mockito.verify(usuarioUtil).exibeMensagem("\nInforme o numero da Agencia\n");
        Mockito.verify(usuarioUtil).exibeMensagem("\nInforme o numero\n");
        Mockito.verify(usuarioUtil).exibeMensagem("\nAdicionado com sucesso\n");
        Mockito.verify(scanner, Mockito.times(2)).nextLine();
        Mockito.verify(bancoDao).adicionarConta(new Conta(55, 55));
    }


    @Test
    public void ListaContaTest() {
        //arrend
        List<Conta> lista = new ArrayList<>();
        Conta novaConta = new Conta(23, 48);
        lista.add(novaConta);
        Mockito.doReturn(lista).when(bancoDao).listarContas();

        //act
        new TelaConta(bancoDao, scanner, usuarioUtil).exibeMenuListarConta();

        //assert
        Mockito.verify(usuarioUtil).exibeMensagem("\nLista de contas:\n");
        Mockito.verify(usuarioUtil).exibeMensagem(novaConta.getDescricao());
    }

    @Test
    public void ListaMenuTest1(){


        //arrend
       Mockito.doReturn("1").when(scanner).nextLine();

        //act

        new TelaConta(bancoDao,scanner,usuarioUtil).exibeMenu();


        //assert

        Mockito.verify(usuarioUtil).exibeMensagem("\nMenu Conta\n\nEscolha uma opção\n\n1-Criar Conta\n\n2-Lista Contas\n");
        Mockito.verify(usuarioUtil).exibeMensagem("\nInforme o numero da Agencia\n");


    }

}
