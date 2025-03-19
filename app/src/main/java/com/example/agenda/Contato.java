package com.example.agenda;

public class Contato {

    private int codigo;
    private String nome;
    private String email;
    private  String fone;

    public Contato() {
    }

    public Contato(int codigo, String nome, String email, String fone) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }



}
