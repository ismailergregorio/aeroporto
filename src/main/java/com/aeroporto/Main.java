package com.aeroporto;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Dados voos = new Dados();
        Voo teste1 =  new Voo("0142", "NULL", "NULL", "NULL", "NULL", 5);
        Voo teste2 =  new Voo("5693", "NULL2", "NULL2", "NULL2", "NULL2", 5);
        
        voos.adicionarVoos(teste1);
        voos.adicionarVoos(teste2);

        SwingUtilities.invokeLater(() -> new PainelPrincipal(voos));
    }
}