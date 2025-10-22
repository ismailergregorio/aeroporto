package com.aeroporto;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Dados voos = new Dados();
        Voo teste1 =  new Voo("null", "NULL", "NULL", "NULL", "NULL", 5);
        Voo teste2 =  new Voo("null2", "NULL2", "NULL2", "NULL2", "NULL2", 5);
        voos.adicionarVoos(teste1);
        voos.adicionarVoos(teste2);

        SwingUtilities.invokeLater(() -> new PainelPrincipal(voos));
    }
}