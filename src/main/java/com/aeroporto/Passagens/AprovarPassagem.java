package com.aeroporto.Passagens;

import javax.swing.*;

import com.aeroporto.Heder;
import com.aeroporto.PainelPrincipal;
import com.aeroporto.Dados.Colors;
import com.aeroporto.Dados.Dados;
import com.aeroporto.Voos.Voo;

import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class AprovarPassagem extends JFrame {
  Colors cor = new Colors();

  public AprovarPassagem(Dados voos, Dados checkIn) {
    String titulo = "Adcionar Passagem";
    setTitle(titulo);
    setSize(400, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // BoxLayout vertical
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    getContentPane().setBackground(cor.getAzulFundo());

    new Heder(titulo, this);

    JPanel selecaoDeVoo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    selecaoDeVoo.setPreferredSize(new Dimension(350, 28));
    selecaoDeVoo.setMaximumSize(new Dimension(350, 28));
    selecaoDeVoo.setBackground(cor.getCinza());

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
    selecaoDeVoo.add(textVoo);
    selecaoDeVoo.add(comboBox);

    JPanel PainelAprovacoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    PainelAprovacoes.setPreferredSize(new Dimension(350, 380));
    PainelAprovacoes.setMaximumSize(new Dimension(350, 380));
    PainelAprovacoes.setBackground(cor.getCinza());

    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String vooSelecionado = (String) comboBox.getSelectedItem();

        // Limpa os botões antigos antes de adicionar novos
        PainelAprovacoes.removeAll();
        Color corPadrao = UIManager.getColor("Panel.background");

        for (Voo v : voos.getListaVoos()) {
          if (vooSelecionado.equals(v.getNumero())) {
            int contado = 0;
            for (Passageiro p : v.getReservasPendentes()) {

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

              JButton btnaprovar = new JButton("Aprovar");
              btnaprovar.setActionCommand(Integer.toString(contado));
              btnaprovar.setFont(new Font("Arial", Font.BOLD, 11));
              btnaprovar.setPreferredSize(new Dimension(90, 18));
              // PanelBtnAprovacao.add(btnaprovar);

              JButton reprovar = new JButton("Reprovar");
              reprovar.setActionCommand(Integer.toString(contado));
              reprovar.setFont(new Font("Arial", Font.BOLD, 11));
              reprovar.setPreferredSize(new Dimension(90, 18));
              // PanelBtnAprovacao.add(reprovar);

              if ("cancelada".equals(p.getStatusDeCompra())) {
                JLabel cancelado = new JLabel("<html><b>Compra</b> Cancelada</html>");
                Passagem.setBackground(cor.getVermelho());
                descricao.setBackground(cor.getVermelho());
                PanelBtnAprovacao.setBackground(cor.getVermelho());
                PanelBtnAprovacao.add(cancelado);
              } 
              else if ("confirmada".equals(p.getStatusDeCompra())) {
                JLabel confirmado = new JLabel("<html><b>Compra</b> Aprovada</html>");
                Passagem.setBackground(cor.getVerde());
                descricao.setBackground(cor.getVerde());
                PanelBtnAprovacao.setBackground(cor.getVerde());
                PanelBtnAprovacao.add(confirmado);
              } else {
                PanelBtnAprovacao.add(btnaprovar);
                PanelBtnAprovacao.add(reprovar);
              }

              Passagem.add(PanelBtnAprovacao);
              PainelAprovacoes.add(Passagem);
              contado++;

              btnaprovar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  PainelAprovacoes.removeAll();

                  String a = e.getActionCommand();
                  System.out.println("Clicou no botão com ID: " + a);

                  Stack<Passageiro> checIn = v.getCheckIn();
                  // System.out.println(v.getReservasPendentes().get(Integer.parseInt(e.getActionCommand())));
                  checIn.push(v.getReservasPendentes().get(Integer.parseInt(e.getActionCommand())));
                  p.setStatusDeCompra("confirmada");
                  v.setCheckIn(checIn);
                  System.out.println(checIn);
                  PainelAprovacoes.revalidate();
                  PainelAprovacoes.repaint();
                }

              });

              reprovar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  PainelAprovacoes.removeAll();
                  String a = e.getActionCommand();
                  System.out.println("Clicou no botão com IDr: " + a);

                  Stack<Passageiro> checIn = v.getCheckIn();
                  p.setStatusDeCompra("cancelada");
                  System.out.println(checIn);

                  PainelAprovacoes.revalidate();
                  PainelAprovacoes.repaint();
                }

              });
            }
          }
        }
        // Atualiza o layout e redesenha
        PainelAprovacoes.revalidate();
        PainelAprovacoes.repaint();
      }
    });

    add(selecaoDeVoo);
    add(Box.createVerticalStrut(2));
    add(PainelAprovacoes);

    add(Box.createVerticalStrut(2));

    JPanel btnSalvarCancelar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    btnSalvarCancelar.setPreferredSize(new Dimension(350, 45));
    btnSalvarCancelar.setMaximumSize(new Dimension(350, 45));

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
