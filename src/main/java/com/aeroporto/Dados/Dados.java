package com.aeroporto.Dados;

import java.util.ArrayList;
import java.util.Stack;

import com.aeroporto.Passagens.Passageiro;
import com.aeroporto.Voos.Voo;

public class Dados {
 private ArrayList<Voo> listaVoos = new ArrayList<>();
 


 public ArrayList<Voo> getListaVoos() {
  return listaVoos;
 }

 public void adicionarVoos(Voo voo) {
  listaVoos.add(voo);
 }

 public ArrayList<Voo> listarVoos() {
  if (listaVoos.isEmpty()) {
   System.out.println("Nenhum voo cadastrado ainda.");
  } else {
   for (Voo v : listaVoos) {
    System.out.println("------------------------------");
    System.out.println("Número do voo: " + v.getNumero());
    System.out.println("Origem: " + v.getOrigem());
    System.out.println("Destino: " + v.getDestino());
    System.out.println("Partida: " + v.getHorarioPartida());
    System.out.println("Chegada: " + v.getHorarioChegada());
    System.out.println("Assentos: " + v.getQuantidade());
    System.out.println("Assentos diponivel: " + v.getAssentos());
   }
  }
  return listaVoos;
 }
 public int listarVoosDisponivel(){
  System.out.println(getListaVoos().size());
  return getListaVoos().size();
 }

}
