package com.aeroporto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdicionarPassagem extends JFrame {
    Colors cor = new Colors();

    public AdicionarPassagem(Dados voos) {
        String titulo = "Adcionar Passagem";
        setTitle(titulo);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // BoxLayout vertical
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(cor.getAzulFundo());

        new Heder(titulo, this);

        JPanel PaineSelecaoVoo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PaineSelecaoVoo.setPreferredSize(new Dimension(350, 210));
        PaineSelecaoVoo.setMaximumSize(new Dimension(350, 210));
        PaineSelecaoVoo.setBackground(cor.getCinza());
        PaineSelecaoVoo.setOpaque(true);
        PaineSelecaoVoo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textVoo = new JLabel("Vool:");
        textVoo.setPreferredSize(new Dimension(100, 15));
        // ArrayList<String> opcoes = new ArrayList<>();
        // ArrayList<Voo> n = voos.getListaVoos();
        String[] n = new String[voos.getListaVoos().size()];
        ArrayList<Voo> v = new ArrayList<>();
        for(int x = 0;x < voos.getListaVoos().size();x++){
           n[x] = "0";
        }

        JComboBox<String> comboBox = new JComboBox<>(n);
        comboBox.setPreferredSize(new Dimension(220, 20));
        PaineSelecaoVoo.add(textVoo);
        PaineSelecaoVoo.add(comboBox);

        JLabel textData = new JLabel("Data:");
        textData.setPreferredSize(new Dimension(100, 15));
        SpinnerDateModel modelo = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(modelo);

        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);

        PaineSelecaoVoo.add(textData);
        PaineSelecaoVoo.add(spinner);

        JPanel PainelAcentos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PainelAcentos.setPreferredSize(new Dimension(340, 150));
        PainelAcentos.setMaximumSize(new Dimension(340, 150));
        PainelAcentos.setBackground(cor.getCinzaEscuro());
        PainelAcentos.setOpaque(true);
        PainelAcentos.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel testAcento = new JLabel("Acento:");
        testAcento.setPreferredSize(new Dimension(300, 15));
        PainelAcentos.add(testAcento);

        for (int i = 0; i < 25; i++) {
            JButton botao = new JButton(String.valueOf(i));
            botao.setPreferredSize(new Dimension(50, 20));
            botao.setFont(new Font("Arial", Font.PLAIN, 11));
            PainelAcentos.add(botao);
        }
        PaineSelecaoVoo.add(PainelAcentos);
        add(PaineSelecaoVoo);
        add(Box.createVerticalStrut(2));

        JPanel PainelPassageiro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PainelPassageiro.setPreferredSize(new Dimension(350, 110));
        PainelPassageiro.setMaximumSize(new Dimension(350, 110));
        // PainelPassageiro.setBackground(cor.getCinzaEscuro());
        PainelPassageiro.setOpaque(true);
        PainelPassageiro.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labNome = new JLabel("Nome:");
        labNome.setPreferredSize(new Dimension(100, 15));
        JTextField textNome = new JTextField(20);
        PainelPassageiro.add(labNome);
        PainelPassageiro.add(textNome);

        JLabel labIdade = new JLabel("Idade:");
        labIdade.setPreferredSize(new Dimension(100, 15));
        JSpinner numIdade = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
        numIdade.setPreferredSize(new Dimension(200, 23));
        PainelPassageiro.add(labIdade);
        PainelPassageiro.add(numIdade);

        JLabel labCpf = new JLabel("CPF:");
        labCpf.setPreferredSize(new Dimension(100, 15));
        JTextField textCpf = new JTextField(20);
        PainelPassageiro.add(labCpf);
        PainelPassageiro.add(textCpf);

        JLabel labEmail = new JLabel("E-mail:");
        labEmail.setPreferredSize(new Dimension(100, 15));
        JTextField textEmail = new JTextField(20);
        PainelPassageiro.add(labEmail);
        PainelPassageiro.add(textEmail);

        add(PainelPassageiro);
        add(Box.createVerticalStrut(2));

        JPanel btnSalvarCancelar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSalvarCancelar.setPreferredSize(new Dimension(350, 45));
        btnSalvarCancelar.setMaximumSize(new Dimension(350, 45));
        JButton salvar = new JButton("Salvar");
        btnSalvarCancelar.add(salvar);

        JButton cancelar = new JButton("Cancelar");
        btnSalvarCancelar.add(cancelar);
        add(btnSalvarCancelar);

        // setVisible(true);
    }
}
