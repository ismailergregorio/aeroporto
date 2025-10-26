package com.aeroporto.Passagens;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.aeroporto.Heder;
import com.aeroporto.PainelPrincipal;
import com.aeroporto.Dados.Colors;
import com.aeroporto.Dados.Dados;
import com.aeroporto.Voos.Voo;

public class CheckIn extends JFrame {
    Colors cor = new Colors();

    public CheckIn(Dados voos, Dados checkin) {
        String titulo = "Check In";
        setTitle(titulo);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(cor.getAzulFundo());

        new Heder(titulo, this);

        JPanel PaineSelecaoVoo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PaineSelecaoVoo.setPreferredSize(new Dimension(350, 28));
        PaineSelecaoVoo.setMaximumSize(new Dimension(350, 28));
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

        JPanel JPanelCheckIn = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanelCheckIn.setPreferredSize(new Dimension(350, 250));
        JPanelCheckIn.setMaximumSize(new Dimension(350, 250));
        JPanelCheckIn.setBackground(cor.getCinza());
        JPanelCheckIn.setOpaque(true);
        JPanelCheckIn.setAlignmentX(Component.CENTER_ALIGNMENT);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vooSelecionado = (String) comboBox.getSelectedItem();
                System.out.println(vooSelecionado);

                // Limpa os botões antigos antes de adicionar novos
                JPanelCheckIn.removeAll();
                Color corPadrao = UIManager.getColor("Panel.background");
                int contador = 0;
                for (Voo v : voos.getListaVoos()) {
                    if (vooSelecionado.equals(v.getNumero())) {
                        for (Passageiro p : v.getCheckIn()) {
                            System.out.println(p);

                            JPanel Passagem = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
                            Passagem.setPreferredSize(new Dimension(340, 65));
                            Passagem.setMaximumSize(new Dimension(340, 65));
                            Passagem.setBackground(cor.getBranco());
                            Passagem.setOpaque(true);

                            JLabel descricao = new JLabel("<html>"
                                    + "<div style='font-family:Arial; font-size:11px; line-height:1.4em;'>"
                                    + "<b>Nome:</b> " + p.getNome() + "<br>"
                                    + "<b>CPF:</b> " + p.getCPF() + "<br>"
                                    + "<b>Voo:</b> " + p.getVoo().getNumero() + " &nbsp;&nbsp; "
                                    + "<b>Assento:</b> " + p.getAcento()
                                    + "</div>"
                                    + "</html>");

                            descricao.setOpaque(true);
                            descricao.setBackground(Color.WHITE);
                            descricao.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
                            descricao.setPreferredSize(new Dimension(220, 55));

                            JScrollPane scroll = new JScrollPane(descricao);
                            descricao.setBackground(cor.getBranco());
                            descricao.setOpaque(true);
                            Passagem.add(scroll);

                            JPanel PanelBtnAprovacao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                            PanelBtnAprovacao.setPreferredSize(new Dimension(100, 50));
                            PanelBtnAprovacao.setMaximumSize(new Dimension(100, 50));
                            PanelBtnAprovacao.setBackground(cor.getBranco());
                            PanelBtnAprovacao.setOpaque(true);

                            JButton aprovar = new JButton("Aprovar");
                            aprovar.setActionCommand(Integer.toString(contador));
                            aprovar.setFont(new Font("Arial", Font.BOLD, 11));
                            aprovar.setPreferredSize(new Dimension(90, 18));
                            PanelBtnAprovacao.add(aprovar);

                            JButton reprovar = new JButton("Recusar");
                            reprovar.setActionCommand(Integer.toString(contador));
                            reprovar.setFont(new Font("Arial", Font.BOLD, 11));
                            reprovar.setPreferredSize(new Dimension(90, 18));
                            PanelBtnAprovacao.add(reprovar);

                            Passagem.add(PanelBtnAprovacao);
                            JPanelCheckIn.add(Passagem);
                        }
                    }
                }

                // Atualiza o layout e redesenha
                JPanelCheckIn.revalidate();
                JPanelCheckIn.repaint();
            }
        });

        add(Box.createVerticalStrut(2));
        add(PaineSelecaoVoo);
        add(Box.createVerticalStrut(2));
        add(JPanelCheckIn);
        add(Box.createVerticalStrut(2));

        JPanel btnSalvarCancelar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSalvarCancelar.setPreferredSize(new Dimension(350, 45));
        btnSalvarCancelar.setMaximumSize(new Dimension(350, 45));

        JButton cancelar = new JButton("Cancelar");
        btnSalvarCancelar.add(cancelar);
        add(btnSalvarCancelar);

        cancelar.addActionListener(e -> {
            abrirTela(new PainelPrincipal(voos, checkin));
        });

        // setVisible(true);
    }

    private void abrirTela(JFrame tela) {
        dispose();
        tela.setVisible(true);
    }
}
