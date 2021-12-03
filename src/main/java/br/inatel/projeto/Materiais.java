package br.inatel.projeto;

public class Materiais {

    private static int id;
    private String tipo;
    private String nome;
    private float preco;
    private int quantidade;

    public Materiais(String tipo, String nome, float preco, int quantidade) {
        this.tipo = tipo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public static int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
