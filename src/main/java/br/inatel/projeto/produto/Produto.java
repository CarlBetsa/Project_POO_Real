package br.inatel.projeto.produto;

public class Produto {

    protected int id;
    protected static int idAux;
    protected String nome;
    protected float preco;

    public Produto() {
    }

    public Produto(String nome, float preco) {
        idAux++;
        this.id = this.getIdAux();
        this.nome = nome;
        this.preco = preco;
    }

    public static int getIdAux() {
        return idAux;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
