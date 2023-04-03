package model;

import java.time.LocalDateTime;
import java.util.Date;
// criação da entidade Pedido
public class Pedido {

    private int id;
    private Produto produto;
    private float quantidade;

     private LocalDateTime dataDaVenda;
    private double valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(LocalDateTime dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Pedido(int id, Produto produto, float quantidade, LocalDateTime dataDaVenda, double valor) {
        setId(id);
        setProduto(produto);
        setQuantidade(quantidade);
        setDataDaVenda(dataDaVenda);
        setValor(valor);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +"\n"+
                ", produto=" + produto +"\n"+
                ", quantidade=" + quantidade +"\n"+
                ", valor=" + valor +"\n"+
                ", Data de compra="+dataDaVenda+"\n"+
                '}';
    }
}
