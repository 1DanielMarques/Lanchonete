package br.com.lanchonete.model;

public class Lanche {
    private int id;
    private String nome;
    private double valor_custo;
    private double valor_venda;
    private String descricao;

    public Lanche() {

    }

    public Lanche(String nome, double valor_custo, double valor_venda, String descricao) {
        this.nome = nome;
        this.valor_custo = valor_custo;
        this.valor_venda = valor_venda;
        this.descricao = descricao;
    }

    public void dados(Lanche lanche) {
        System.out.println("[ID]          | " + lanche.getId());
        System.out.println("[NOME]        | " + lanche.getNome());
        System.out.println("[VALOR CUSTO] | " + lanche.getValor_custo());
        System.out.println("[VALOR VENDA] | " + lanche.getValor_venda());
        System.out.println("[DESCRICAO]   | " + lanche.getDescricao());

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
