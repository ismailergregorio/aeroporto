package com.aeroporto;

import javax.swing.*;
import java.awt.*;

public class PainelPrincipal extends JFrame {
    Colors cor = new Colors();

    public PainelPrincipal() {
        setTitle("Painel de Voo");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // BoxLayout vertical
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(cor.getAzulFundo());

        // Título
        JLabel titulo = new JLabel("PAINEL DE VOO", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setBackground(cor.getAzulTopo());
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60)); // largura expansível, altura fixa
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT); // centraliza horizontalmente

        add(Box.createVerticalStrut(2));
        add(titulo);
        add(Box.createVerticalStrut(2));

        JPanel PainelStatus = new JPanel(new BorderLayout());
        PainelStatus.setPreferredSize(new Dimension(350, 45));
        PainelStatus.setMaximumSize(new Dimension(350, 45));
        // PainelStatus.setBackground(verde);
        PainelStatus.setOpaque(true);
        PainelStatus.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Espaçamento interno
        PainelStatus.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        // Imagem à esquerda
        ImageIcon icone = new ImageIcon("src\\main\\java\\com\\aeroporto\\image.png");
        Image img = icone.getImage().getScaledInstance(90, 50, Image.SCALE_SMOOTH);
        JLabel labelImagem = new JLabel(new ImageIcon(img));
        PainelStatus.add(labelImagem, BorderLayout.WEST);

        // Painel de status (com grid)
        JPanel statusPanel = new JPanel(new GridLayout(2, 2, 15, 5));
        // statusPanel.setBackground(azulFundo);

        JLabel textDisponivel = new JLabel("Disponível:");
        JLabel Disponivel = new JLabel("0");
        JLabel textIndisponivel = new JLabel("Indisponível:");
        JLabel Indisponivel = new JLabel("0");

        statusPanel.add(textDisponivel);
        statusPanel.add(Disponivel);
        statusPanel.add(textIndisponivel);
        statusPanel.add(Indisponivel);

        // Painel auxiliar para alinhar à direita
        JPanel containerDireita = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        // containerDireita.setBackground(cinza);
        containerDireita.add(statusPanel);
        PainelStatus.add(Box.createHorizontalGlue());
        labelImagem.setAlignmentY(Component.CENTER_ALIGNMENT);
        statusPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        // Adiciona à direita do painel principal
        PainelStatus.add(containerDireita, BorderLayout.CENTER);

        add(PainelStatus);

        add(Box.createVerticalStrut(2));

        // Painel Administrativo
        JPanel btnControleAdimistrativo = new JPanel();
        btnControleAdimistrativo.setLayout(new BoxLayout(btnControleAdimistrativo, BoxLayout.Y_AXIS));
        btnControleAdimistrativo.setPreferredSize(new Dimension(350, 60));
        btnControleAdimistrativo.setMaximumSize(new Dimension(350, 60));
        btnControleAdimistrativo.setBackground(cor.getCinza());
        btnControleAdimistrativo.setOpaque(true);
        btnControleAdimistrativo.setAlignmentX(Component.CENTER_ALIGNMENT); // centraliza

        JLabel textAdministrativo = new JLabel("ADMINISTRAÇÃO");
        textAdministrativo.setAlignmentX(Component.CENTER_ALIGNMENT); // centraliza dentro do painel
        textAdministrativo.setBackground(cor.getCinzaEscuro());
        textAdministrativo.setOpaque(true);
        textAdministrativo.setPreferredSize(new Dimension(350, 10));
        textAdministrativo.setMaximumSize(new Dimension(350, 10));

        // btnControleAdimistrativo.add(Box.createVerticalStrut(2));
        btnControleAdimistrativo.add(textAdministrativo);

        JPanel jPanelbtnAdminstrativo = new JPanel();
        jPanelbtnAdminstrativo.setOpaque(true);
        jPanelbtnAdminstrativo.setBackground(cor.getCinza());
        jPanelbtnAdminstrativo.setPreferredSize(new Dimension(350, 100));
        jPanelbtnAdminstrativo.setMaximumSize(new Dimension(350, 100));
        jPanelbtnAdminstrativo.setAlignmentX(Component.CENTER_ALIGNMENT); // centraliza

        // Botões dentro do painel cinza
        JButton btnAddVoo = new JButton("Add Voo");

        btnAddVoo.addActionListener(e ->{
            abrirTela(new AdicionarVoo());
        });

        JButton btnAddPassagem = new JButton("Com Psg");
        JButton btnAprova = new JButton("Aprovar");

        jPanelbtnAdminstrativo.add(btnAddVoo);
        jPanelbtnAdminstrativo.add(btnAddPassagem);
        jPanelbtnAdminstrativo.add(btnAprova);

        btnControleAdimistrativo.add(Box.createVerticalStrut(5));
        btnControleAdimistrativo.add(jPanelbtnAdminstrativo);

        add(btnControleAdimistrativo);
        add(Box.createVerticalStrut(5));

        // Painel de Voo
        JPanel jPanelVoo = new JPanel();
        jPanelVoo.setLayout(new BoxLayout(jPanelVoo, BoxLayout.Y_AXIS));
        jPanelVoo.setPreferredSize(new Dimension(350, 300));
        jPanelVoo.setMaximumSize(new Dimension(350, 300));
        jPanelVoo.setBackground(cor.getCinza());
        jPanelVoo.setOpaque(true);
        jPanelVoo.setAlignmentX(Component.CENTER_ALIGNMENT); // centraliza

        add(jPanelVoo);
        add(Box.createVerticalGlue()); // empurra o conteúdo para cima

        setVisible(true);
    }

    private void abrirTela(JFrame tela) {
        dispose();
        tela.setVisible(true);
    }
}
