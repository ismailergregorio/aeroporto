package com.aeroporto.Passagens;

import javax.swing.*;

import com.aeroporto.Heder;
import com.aeroporto.PainelPrincipal;
import com.aeroporto.Dados.Colors;
import com.aeroporto.Dados.Dados;
import com.aeroporto.Voos.Voo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdicionarPassagem extends JFrame {
    Colors cor = new Colors();
    private String poutrona;

    public AdicionarPassagem(Dados voos, Dados checkIn) {
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

        String[] numeroDosVoos = new String[voos.getListaVoos().size()];
        int controle = 0;
        for (Voo v : voos.getListaVoos()) {
            numeroDosVoos[controle] = v.getNumero();
            controle++;
        }
        controle = 0;

        JComboBox<String> comboBox = new JComboBox<>(numeroDosVoos);
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

        ButtonGroup grupoAssentos = new ButtonGroup();

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vooSelecionado = (String) comboBox.getSelectedItem();

                // Limpa os botões antigos antes de adicionar novos
                PainelAcentos.removeAll();
                Color corPadrao = UIManager.getColor("Panel.background");

                for (Voo v : voos.getListaVoos()) {
                    if (vooSelecionado.equals(v.getNumero())) {
                        for (int x = 1; x <= v.getQuantidade(); x++) {
                            JRadioButton assento = new JRadioButton(String.valueOf(x)); // final
                            assento.setPreferredSize(new Dimension(60, 30));
                            if (v.getAssentos().get(x - 1) != "disponivel") {
                                assento.setEnabled(false);
                            }

                            assento.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("Assento selecionado: " + assento.getText());
                                    poutrona = (String) assento.getText();
                                }
                            });

                            grupoAssentos.add(assento); // adiciona ao grupo
                            PainelAcentos.add(assento);
                        }
                    }
                }

                // Atualiza o layout e redesenha
                PainelAcentos.revalidate();
                PainelAcentos.repaint();
            }
        });

        PaineSelecaoVoo.add(PainelAcentos);
        add(PaineSelecaoVoo);
        add(Box.createVerticalStrut(2));

        JPanel PainelPassageiro = new JPanel(new FlowLayout(
                FlowLayout.LEFT));
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
        JSpinner numIdade = new JSpinner(new SpinnerNumberModel(0, 0, 1000,
                1));
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

        salvar.addActionListener(e -> {
            String nome = textNome.getText();
            String cpf = textCpf.getText();
            int idade = (int) numIdade.getValue();
            String email = textEmail.getText();
            Voo voo = new Voo();

            if (nome.isBlank() || cpf.isBlank() || idade <= 0 || email.isBlank()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha todos os campos corretamente.",
                        "Campos obrigatórios",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            PainelAcentos.removeAll();
            // encontra o voo selecionado
            Voo vooSelecionado = null;
            for (Voo v : voos.getListaVoos()) {
                if (v.getNumero().equals(comboBox.getSelectedItem())) {
                    vooSelecionado = v;
                    break;
                }
            }

            if (vooSelecionado != null) {
                ArrayList<String> atualizacaoDeAssentos = vooSelecionado.getAssentos();
                int numeroAssento = Integer.parseInt(poutrona);

                // atualiza o nome no assento correspondente
                if (numeroAssento > 0 && numeroAssento <= atualizacaoDeAssentos.size()) {
                    atualizacaoDeAssentos.set(numeroAssento - 1, nome);
                    vooSelecionado.setAssentos(atualizacaoDeAssentos);
                    System.out.println("Assento " + numeroAssento + " atualizado para " + nome);
                    System.out.println(vooSelecionado);
                }
            }

            Passageiro p = new Passageiro(voo, textNome.getText(), textCpf.getText(), (int) numIdade.getValue(),
                    textEmail.getText(), poutrona);
            
            vooSelecionado.addPassagensPendentes(p);
            PainelAcentos.revalidate();
            PainelAcentos.repaint();

        });

        JButton cancelar = new JButton("Cancelar");
        btnSalvarCancelar.add(cancelar);
        add(btnSalvarCancelar);

        cancelar.addActionListener(e -> {
            abrirTela(new PainelPrincipal(voos, checkIn));
        });

        // setVisible(true);
    }

    private void abrirTela(JFrame tela) {
        dispose();
        tela.setVisible(true);
    }
}
