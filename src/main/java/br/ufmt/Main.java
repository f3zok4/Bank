package br.ufmt;

public class Main {
    public static void main(String[] args) {

        PessoaDAO.inserir(new Pessoa("João", "Cuiabá"));
        PessoaDAO.inserir(new Pessoa("Maria", "Cuiabá"));
        PessoaDAO.inserir(new Pessoa("José", "Cuiabá"));
        PessoaDAO.inserir(new Pessoa("Joana", "Primavera"));
        PessoaDAO.printList();
        PessoaDAO.findNameLike("Jo");
        PessoaDAO.atualizar(new Pessoa(1, "João da Silva", "Cuiabá"));

    }
}