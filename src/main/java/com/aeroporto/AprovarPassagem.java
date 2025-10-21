package com.aeroporto;

import javax.swing.*;
import java.awt.*;

public class AprovarPassagem extends JFrame {
 Colors cor = new Colors();

 public AprovarPassagem() {
  String titulo = "Adcionar Passagem";
  setTitle(titulo);
  setSize(400, 500);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(EXIT_ON_CLOSE);

  // BoxLayout vertical
  setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
  getContentPane().setBackground(cor.getAzulFundo());

  new Heder(titulo,this);

  JPanel PainelAprovacoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
  PainelAprovacoes.setPreferredSize(new Dimension(350, 380));
  PainelAprovacoes.setMaximumSize(new Dimension(350, 380));
  PainelAprovacoes.setBackground(cor.getCinza());

  JPanel Passagem = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
  Passagem.setPreferredSize(new Dimension(340, 60));
  Passagem.setMaximumSize(new Dimension(340, 60));
  Passagem.setBackground(cor.getBranco());
  Passagem.setOpaque(true);

  JLabel descricao = new JLabel("<html>Este  automaticamente "
    + "quando atingir  dentro do JLabel.</html>");
  descricao.setPreferredSize(new Dimension(225, 50));
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
  aprovar.setFont(new Font("Arial", Font.BOLD, 11));
  aprovar.setPreferredSize(new Dimension(90, 18));
  PanelBtnAprovacao.add(aprovar);

  JButton reprovar = new JButton("Reprovar");
  reprovar.setFont(new Font("Arial", Font.BOLD, 11));
  reprovar.setPreferredSize(new Dimension(90, 18));
  PanelBtnAprovacao.add(reprovar);

  Passagem.add(PanelBtnAprovacao);

  PainelAprovacoes.add(Passagem);
  add(PainelAprovacoes);

  // setVisible(true);
 }

}
