package br.com.lanchonete.model;

public class Bebida {

    private int id;
    private String marca;
    private String litro;
    private double preco_custo;
    private double preco_venda;

    public Bebida() {

    }

    public Bebida(int id, String marca, String litro, double preco_custo, double preco_venda) {
        this.id = id;
        this.marca = marca;
        this.litro = litro;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
    }

    public void dados(Bebida bebida) {
        System.out.println("[ID]          | " + bebida.getId());
        System.out.println("[MARCA]       | " + bebida.getMarca());
        System.out.println("[LITRAGEM]    | " + bebida.getLitro());
        System.out.println("[VALOR CUSTO] | R$" + String.format("%.2f", bebida.getPreco_custo()));
        System.out.println("[VALOR VENDA] | R$" + String.format("%.2f", bebida.getPreco_venda()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLitro() {
        return litro;
    }

    public void setLitro(String litro) {
        this.litro = litro;
    }

    public double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }
}
