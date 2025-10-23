package com.aeroporto;

public class Passageiro {
    private Voo voo;

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Passageiro(Voo voo, String nome, String cpf, int idade, String email, String acento) {
        this.voo = voo;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.acento = acento;
    }

    private String nome;
    private String cpf;
    private int idade;
    private String email;
    private String acento;

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

    // Sobrescrevendo toString para facilitar impressão
    @Override
    public String toString() {
        return "Passageiro {" +
                "Voo='" + voo.getNumero()+ ": "+voo.getDestino() + '\'' +
                "Nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Idade=" + idade +
                ", Email='" + email + '\'' +
                ", Assento='" + acento + '\'' +
                '}';
    }

}
