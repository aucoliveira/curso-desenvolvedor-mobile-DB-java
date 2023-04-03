package model;

public class Produto {
    private int id;
    private String nome;
    private double preco;

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto(int id, String nome, double preco) {
        setId(id);
        setNome(nome);
        setPreco(preco);
    }

    public Produto(){}

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + getId() +"\n"+
                ", nome='" + getNome() + "\n"+
                ", preco=" + getPreco() +"\n"+
                '}';
    }
}
