package br.ufmt;
public class Pessoa {
    private int id;
    private String nome;
    private String cidade;

    public Pessoa(String nome, String cidade){
        this.nome = nome;
        this.cidade = cidade;
    }
    public Pessoa(int id, String nome, String cidade){
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }
    public String getNome() {
        return nome;
    }

    public int getID() {
        return id;
    }
}
