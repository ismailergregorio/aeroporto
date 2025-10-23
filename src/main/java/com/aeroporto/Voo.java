package com.aeroporto;

import java.util.ArrayList;

public class Voo {
  private String numero;
  private String origem;
  private String destino;
  private String horarioPartida;
  private String horarioChegada;
  private int quantidade;
  private ArrayList<String> assentos = new ArrayList<>();

  public Voo() {

  }

  public Voo(String numero, String origem, String destino, String horarioPartida, String horarioChegada,
      int quantidade) {
    this.numero = numero;
    this.origem = origem;
    this.destino = destino;
    this.horarioPartida = horarioPartida;
    this.horarioChegada = horarioChegada;
    this.quantidade = quantidade;

    ArrayList<String> assentos = new ArrayList<>();
    for (int x = 0; x < quantidade; x++) {
      assentos.add("disponivel");
    }
    this.assentos = assentos;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public String getHorarioPartida() {
    return horarioPartida;
  }

  public void setHorarioPartida(String horarioPartida) {
    this.horarioPartida = horarioPartida;
  }

  public String getHorarioChegada() {
    return horarioChegada;
  }

  public void setHorarioChegada(String horarioChegada) {
    this.horarioChegada = horarioChegada;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public ArrayList<String> getAssentos() {
    return assentos;
  }

  public void setAssentos(ArrayList<String> assentos) {
    this.assentos = assentos;
  }

  @Override
  public String toString() {
    return "Voo{" +
        "numero='" + numero + '\'' +
        ", origem='" + origem + '\'' +
        ", destino='" + destino + '\'' +
        ", horarioPartida='" + horarioPartida + '\'' +
        ", horarioChegada='" + horarioChegada + '\'' +
        ", quantidade=" + quantidade +
        ", assentos=" + assentos +
        '}';
  }
}
