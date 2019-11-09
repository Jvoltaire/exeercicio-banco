package util;

import javax.swing.*;

public class MasterUsuarioUtil extends UsuarioUtil implements ScannerIntrface {

    @Override
    public void exibeMensagem(String mensagem) {
        super.exibeMensagem(mensagem);
        JOptionPane.showMessageDialog( null, mensagem);

    }

    @Override
    public String nextLine() {
        return JOptionPane.showInputDialog("\nInforme um valor\n");

    }
}
