package br.com.lanchonete.model;

public class Lanche {
    private String nome;
    private double valor_custo;
    private double valor_venda;
    private int quantidade;
    private String descricao;

    public Lanche() {

    }

    public Lanche(String nome, double valor_custo, double valor_venda, int quantidade, String descricao) {
        this.nome = nome;
        this.valor_custo = valor_custo;
        this.valor_venda = valor_venda;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor_custo() {
        return valor_custo;
    }

    public void setValor_custo(double valor_custo) {
        this.valor_custo = valor_custo;
    }

    public double getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
