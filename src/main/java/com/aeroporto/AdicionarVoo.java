package com.aeroporto;

import javax.swing.*;
import java.awt.*;

public class AdicionarVoo extends JFrame {
 Colors cor = new Colors();

 public AdicionarVoo() {
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

  JButton cancelar = new JButton("Cancelar");
  btnSalvarCancelar.add(cancelar);

  add(formularioCadastroVoo);
  add(Box.createVerticalStrut(5));
  add(btnSalvarCancelar);

  // setVisible(true);
 }
}
