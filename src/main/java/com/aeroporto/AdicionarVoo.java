package com.aeroporto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdicionarVoo extends JFrame {
    Colors cor = new Colors();
    ArrayList<ArrayList<String>> listaVoo = new ArrayList<>();

    public AdicionarVoo() {
        ArrayList<String> novoVoo = new ArrayList<>();

        String titulo = "Adicionar Voo";
        setTitle(titulo);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // BoxLayout vertical
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(cor.getAzulFundo());

        new Heder(titulo, this);

        JPanel formularioCadastroVoo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        formularioCadastroVoo.setPreferredSize(new Dimension(350, 150));
        formularioCadastroVoo.setMaximumSize(new Dimension(350, 150));

        JLabel labNumeroVoo = new JLabel("N° Voo:");
        labNumeroVoo.setPreferredSize(new Dimension(100, 15));
        JTextField textNumeroVoo = new JTextField(20);
        formularioCadastroVoo.add(labNumeroVoo);
        formularioCadastroVoo.add(textNumeroVoo);

        JLabel labOrigem = new JLabel("Origem:");
        labOrigem.setPreferredSize(new Dimension(100, 15));
        JTextField textOrigem = new JTextField(20);

        formularioCadastroVoo.add(labOrigem);
        formularioCadastroVoo.add(textOrigem);

        JLabel labDestino = new JLabel("Destino:");
        labDestino.setPreferredSize(new Dimension(100, 15));
        JTextField textDestino = new JTextField(20);

        formularioCadastroVoo.add(labDestino);
        formularioCadastroVoo.add(textDestino);

        JLabel labHorarioPartida = new JLabel("Horario de Partida:");
        labHorarioPartida.setPreferredSize(new Dimension(100, 15));
        JTextField textHorarioPartida = new JTextField(20);

        formularioCadastroVoo.add(labHorarioPartida);
        formularioCadastroVoo.add(textHorarioPartida);

        JLabel labHorarioChegada = new JLabel("Horario de Chegada:");
        labHorarioChegada.setPreferredSize(new Dimension(100, 15));
        JTextField textHorarioChegada = new JTextField(20);

        formularioCadastroVoo.add(labHorarioChegada);
        formularioCadastroVoo.add(textHorarioChegada);

        JLabel labQuantidadePassageiros = new JLabel("Quantidade Passageiros:");
        labQuantidadePassageiros.setPreferredSize(new Dimension(100, 15));
        JSpinner numQuantidadePassageiros = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));

        formularioCadastroVoo.add(labQuantidadePassageiros);
        formularioCadastroVoo.add(numQuantidadePassageiros);

        JPanel btnSalvarCancelar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSalvarCancelar.setPreferredSize(new Dimension(350, 45));
        btnSalvarCancelar.setMaximumSize(new Dimension(350, 45));

        JButton salvar = new JButton("Salvar");
        btnSalvarCancelar.add(salvar);

        salvar.addActionListener(e -> {
            // String valor = Integer.toString(numQuantidadePassageiros.getValue());
            
            CriarVoo(FormarLista(textNumeroVoo.getText(), textOrigem.getText(), textDestino.getText(), 
                        textHorarioChegada.getText(), textHorarioPartida.getText(),numQuantidadePassageiros.getToolTipText()));

        });

        JButton cancelar = new JButton("Cancelar");
        btnSalvarCancelar.add(cancelar);

        add(formularioCadastroVoo);
        add(Box.createVerticalStrut(5));
        add(btnSalvarCancelar);

        // setVisible(true);
    }

    public void CriarVoo(ArrayList<String> lista) {
        if (lista != null ) {
            listaVoo.add(lista);
        }
        for(int x = 0; x < listaVoo.size();x++){
            System.out.println(listaVoo.get(x));
        }
        // System.out.println("Voo Adicionado:\n"+listaVoo);
    }

    public ArrayList<String> FormarLista(String numVoo, String origem, String destino,
            String HorarioPatida, String HorarioSaida, String quantidadePassageiro) {

        ArrayList<String> lista = new ArrayList<>();
        lista.add(numVoo);
        lista.add(origem);
        lista.add(destino);
        lista.add(HorarioPatida);
        lista.add(HorarioSaida);
        lista.add(quantidadePassageiro);

        return lista;
    }
}
