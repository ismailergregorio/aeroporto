package com.aeroporto;

public class Passageiro {
    private String nome;
    private String cpf;
    private String idade;
    private String email;

    public Passageiro(String nome, String cpf, String idade, String email) {
        this.nome = nome;
        this.cpf= cpf;
        this.idade = idade;
        this.email = email;
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
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
