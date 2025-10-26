package com.aeroporto.Passagens;

import java.util.ArrayList;

import com.aeroporto.Voos.Voo;

public class Passageiro {
    private Voo voo;
    private String nome;
    private String cpf;
    private int idade;
    private String email;
    private String acento;
    private String statusDeCompra = "aguardando";
    private String checkInRelisado = "aguardando";

    public Passageiro(Voo voo, String nome, String cpf, int idade, String email, String acento) {
        this.voo = voo;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.acento = acento;
        System.out.println(voo.getAssentos());
        int indice = Integer.parseInt(acento) - 1;
        ArrayList<String> assentos = voo.getAssentos();

        if ("disponivel".equals(assentos.get(indice))) { // compara valor corretamente
            assentos.set(indice, nome);
            voo.setAssentos(assentos);
            System.out.println(voo.getAssentos());
        }
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public String getAcento() {
        return acento;
    }

    public void setAcento(String acento) {
        this.acento = acento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatusDeCompra() {
        return statusDeCompra;
    }

    public void setStatusDeCompra(String statusDeCompra) {
        this.statusDeCompra = statusDeCompra;
    }

    public String getCheckInRelisado() {
        return checkInRelisado;
    }

    public void setCheckInRelisado(String checkInRelisado) {
        this.checkInRelisado = checkInRelisado;
    }

    // Sobrescrevendo toString para facilitar impressão
    @Override
    public String toString() {
        return "Passageiro {" +
                "Voo='" + voo.getNumero() + ": " + voo.getDestino() + '\'' +
                "Nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Idade=" + idade +
                ", Email='" + email + '\'' +
                ", Assento='" + acento + '\'' +
                '}';
    }

}
