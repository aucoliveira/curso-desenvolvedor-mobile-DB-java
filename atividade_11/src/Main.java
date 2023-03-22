import model.Pedido;
import model.Produto;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date data = new Date();


        Produto carne = new Produto(1,"Fraldinha",20.57);
        System.out.println(carne);

        System.out.println("");

        Pedido pedido1 = new Pedido(1,carne,3,data,(carne.getPreco() * 3));
        System.out.println(pedido1);

    }
}