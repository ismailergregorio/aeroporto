package com.aeroporto;

import javax.swing.*;
import java.awt.*;

public class AdicionarVoo extends JFrame {
    Colors cor = new Colors();

    public AdicionarVoo(Dados voos) {

        String titulo = "Adicionar Voo";
        setTitle(titulo);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // BoxLayout vertical
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(cor.getAzulFundo());

        JLabel Titulo = new JLabel(titulo, SwingConstants.CENTER);
        Titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Titulo.setBackground(cor.getAzulTopo());
        Titulo.setForeground(Color.WHITE);
        Titulo.setOpaque(true);
        Titulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60)); // largura expansível, altura fixa
        Titulo.setAlignmentX(Component.CENTER_ALIGNMENT); // centraliza horizontalmente

        add(Box.createVerticalStrut(2));
        add(Titulo);
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
        Dados a = new Dados();

        JLabel Disponivel = new JLabel(Integer.toString(voos.listarVoosDisponivel()));
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
            String numero = textNumeroVoo.getText();
            String origem = textOrigem.getText();
            String destino = textDestino.getText();
            String partida = textHorarioPartida.getText();
            String chegada = textHorarioChegada.getText();
            int quantidade = (int) numQuantidadePassageiros.getValue();

            // Verificação
            if (numero.isBlank() || origem.isBlank() || destino.isBlank() ||
                    partida.isBlank() || chegada.isBlank() || quantidade <= 0) {

                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha todos os campos corretamente.",
                        "Campos obrigatórios",
                        JOptionPane.WARNING_MESSAGE);
                return; // interrompe o método, não cria o voo
            }

            Voo voo = new Voo(textNumeroVoo.getText(), textOrigem.getText(), textDestino.getText(),
                    textHorarioPartida.getText(), textHorarioChegada.getText(), quantidade);

            voos.adicionarVoos(voo);
            voos.listarVoos();
            Disponivel.setText(Integer.toString(voos.listarVoosDisponivel()));

        });

        JButton cancelar = new JButton("Cancelar");
        btnSalvarCancelar.add(cancelar);

        cancelar.addActionListener(e -> {
            abrirTela(voos);
        });

        add(formularioCadastroVoo);
        add(Box.createVerticalStrut(5));
        add(btnSalvarCancelar);

    }

    private void abrirTela(Dados voos) {
        dispose();
        new PainelPrincipal(voos);
    }
}
