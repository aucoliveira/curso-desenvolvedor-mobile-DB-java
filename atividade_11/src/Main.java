import model.Pedido;
import model.Produto;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {

    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/coma_bem_db";
    public static void main(String[] args)  {
        LocalDateTime data = LocalDateTime.now();

        // Criando um objeto para a conexao com o banco de dados.
        ConexaoDAO conexaoDB = new ConexaoDAO();

        //Criando o primeiro produto
        Produto carne = new Produto(1,"Fraldinha",20.57);

        Pedido pedido1 = new Pedido(3,carne,3.0f, data,(carne.getPreco() * 3.0f));

        // Inserindo no banco de dados passando como parametro um objeto
        conexaoDB.inserindoProduto(carne);

        // Inserindo no banco de dados informando os campos.
        conexaoDB.inserindoProduto("Pão",2.87);

        conexaoDB.inserindoPedido(pedido1);
        System.out.println("");

        // Criando o pedido

        //System.out.println(pedido1);

        System.out.println("");

        // Realizando a busca por ID
        conexaoDB.selecionarTabelaPorId("Pedidos", 5);

        // Selecionando todos os campos de uma tabela, passando como parametro o nome da tabela
        conexaoDB.selecionarTabela("Produto");

        //conexaoDB.inserindoPedido(2,2.0f, data,100.03);
        //conexaoDB.selecionarTabela("Pedidos");

        // Alterando os dados
        conexaoDB.alteraDadosProduto(1,"Fraldinha");
        conexaoDB.alteraDadosProduto(1,50.47);

        Pedido pedido = new Pedido(10,carne,10.0f, data,(carne.getPreco() * 10.0));
        conexaoDB.alterandoDadosPedidos(pedido);

        conexaoDB.selecionarTabelaPorId("Pedidos",0);

        // Deletando os dados
        conexaoDB.deletarPedido(5);
        conexaoDB.deletarProduto(10);

    }
}