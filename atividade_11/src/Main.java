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

        ConexaoDAO conexaoDB = new ConexaoDAO();
        Produto carne = new Produto(1,"Fraldinha",20.57);
        //System.out.println(carne);

        conexaoDB.inserindoProduto(carne);
        System.out.println("");

        Pedido pedido1 = new Pedido(3,carne,3.0f, data,(carne.getPreco() * 3.0f));
        //System.out.println(pedido1);

        System.out.println("");
        //conexaoDB.selecionarTabelaPorId("Pedidos", 5);
        //conexaoDB.inserindoProduto("Pão",2.87);
        conexaoDB.inserindoPedido(pedido1);
        //conexaoDB.selecionarTabela("Produto");
        //conexaoDB.inserindoPedido(2,2.0f, data,100.03);
        //conexaoDB.selecionarTabela("Pedidos");

        //conexaoDAO.alteraDadosProduto(1,"Fraldinha");
        //conexaoDAO.alteraDadosProduto(1,50.47);

        //Produto carne = new Produto(1,"Fraldinha",20.57);
        //Pedido pedido = new Pedido(10,carne,10.0f, data,(carne.getPreco() * 10.0));
        //conexaoDAO.alterandoDadosPedidos(pedido);

        conexaoDB.selecionarTabelaPorId("Pedidos",0);

        conexaoDB.deletarPedido(5);
        //conexaoDAO.deletarProduto(10);

    }
}