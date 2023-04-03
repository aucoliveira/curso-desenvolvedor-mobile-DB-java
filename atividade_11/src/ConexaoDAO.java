
import model.Pedido;
import model.Produto;

import java.sql.*;
import java.time.LocalDateTime;

public class ConexaoDAO {

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coma_bem_db", "root", "0705");
            //System.out.println("Conectou!");
        } catch (SQLException e) {
            System.out.println("Iii, num deu. Error: " + e);
        }
        return conn;
    }

    // CRUD

    // Create
    public void inserindoProduto(String nome, Double preco) {
        Connection conn = null;
        Statement stm = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            stm.execute("insert into Produto (nome, preco) values ('"+nome+"', '"+preco+"');");
            System.out.println("Produto inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto. Erro: " + e);
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
    }

    public void inserindoPedido(int idProduto, float quantidade, LocalDateTime dataDoPedido, double valor) {
        Connection conn = null;
        Statement stm = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            stm.execute("insert into Pedidos (id_produto, quantidade, data, valor) values ('"+idProduto+"','" +
                    quantidade+"', '"+dataDoPedido+"', '"+valor+"');");
            System.out.println("Pedido inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o pedido. Erro: " + e);
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
    }

    // inserindo um produto passando como argumento um objeto
    public void inserindoProduto(Produto produto) {
        Connection conn = null;
        Statement stm = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            stm.execute("insert into Produto ( nome, preco) values ('" +
                    produto.getNome()+"', '"+produto.getPreco()+"');");
            System.out.println("Produto inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o produto. Erro: " + e);
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
    }

    // inserido um pedido passando como argumento um objeto
    public void inserindoPedido(Pedido pedido) {
        Connection conn = null;
        Statement stm = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            stm.execute("insert into Pedidos (id_produto, quantidade, data, valor) values ('"+pedido.getProduto().getId()+"','" +
                    pedido.getQuantidade()+"', '"+pedido.getDataDaVenda()+"', '"+pedido.getValor()+"');");
            System.out.println("Pedido inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o pedido. Erro: " + e);
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
    }



    // Read
    public void selecionarTabela(String tabela) {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from "+tabela);

            while( rs.next() ) {
                System.out.println(rs.getInt(1)+
                        " " + rs.getString(2)+
                        " " + rs.getBigDecimal(3));
            }

        } catch (SQLException e) {
            System.out.println("Seleção falhou. Erro: " + e);
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
    }

    public boolean selecionarTabelaPorId(String tabela, int id) {
        Connection conn = null;
        Statement stm = null;

        try {
            conn = getConnection();
            stm = conn.createStatement();
            ResultSet rs = null;
            if (tabela.equals("Produto")) {

                rs = stm.executeQuery("select * from Produto where id_produto = "+id);

                if(rs.next()) {
                    System.out.println(rs.getInt(1) +
                            " " + rs.getString(2) +
                            " " + rs.getBigDecimal(3));
                    return true;
                }


            } else if (tabela.equals("Pedidos")) {
                rs = stm.executeQuery("select * from Pedidos where id_pedido = "+id);
                if(rs.next()) {
                    System.out.println(rs.getInt(1) +
                            " " + rs.getString(2) +
                            " " + rs.getBigDecimal(3));
                    return true;
                }



            } else {
                System.out.println("Id não encontrado!");

            }

        } catch (SQLException e) {
            System.out.println("Seleção falhou. Erro: " + e);
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
        return false;
    }

    // Update
    public void alteraDadosProduto(int id, String dado) {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Produto where id_produto = " + id);
            if (rs.next()) {
                System.out.println("Dados atuais: " + rs.getInt(1) +
                        " " + rs.getString(2) +
                        " " + rs.getBigDecimal(3));
                System.out.println("");
                System.out.println("Realizando as alterações");
                stm.executeUpdate("update Produto set nome ='" + dado + "'  where id_produto = " + id);

                rs = stm.executeQuery("select * from Produto where id_produto = " + id);
                rs.next();
                System.out.println("Dados alterados: " + rs.getInt(1) +
                        " " + rs.getString(2) +
                        " " + rs.getBigDecimal(3));
                System.out.println("");
            } else {
                System.out.println("O ID informado não foi encontrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
    }

    public void alteraDadosProduto(int id, double preco) {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Produto where id_produto = "+ id);
            if(rs.next()) {
                System.out.println("Dados atuais: " + rs.getInt(1) +
                        " " + rs.getString(2) +
                        " " + rs.getBigDecimal(3));
                System.out.println("");
                System.out.println("Realizando as alterações");
                stm.executeUpdate("update Produto set preco ='"+preco +"'  where id_produto = "+id);

                rs = stm.executeQuery("select * from Produto where id_produto = "+ id);
                rs.next();
                System.out.println("Dados alterados: " + rs.getInt(1) +
                        " " + rs.getString(2) +
                        " " + rs.getBigDecimal(3));
                System.out.println("");

            } else {
                System.out.println("O ID informado não foi encontrado!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }


    }

    public void alterandoDadosPedidos( Pedido pedido) {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stm = conn.createStatement();
            System.out.println(selecionarTabelaPorId("Pedidos", pedido.getId()));
            if (selecionarTabelaPorId("Pedidos", pedido.getId())) {
                System.out.println("Pedido encontrado!");
                stm.executeUpdate("update Pedidos set id_produto ="+pedido.getProduto().getId()
                        +", quantidade ="+pedido.getQuantidade()+", valor ="+pedido.getValor()+" where id_pedido ="+ pedido.getId());
            } else {
                System.out.println("Pedido não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
    }

    // Delete

    public void deletarProduto(int id) {
        Connection conn = null;
        Statement stm = null;

        try {
            conn = getConnection();
            stm = conn.createStatement();

            if(selecionarTabelaPorId("Produto", id)) {
                System.out.println("O intem da Tabela Produto foi encontrado.");
                stm.execute("delete from Produto where id_produto = "+id);
                System.out.println("Item da tabela Produto foi deletado com sucesso.");
            } else {
                System.out.println("Item não encontrado.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
    }

    public void deletarPedido(int id) {
        Connection conn = null;
        Statement stm = null;

        try {
            conn = getConnection();
            stm = conn.createStatement();
            System.out.println(selecionarTabelaPorId("Pedidos", id));
            if(selecionarTabelaPorId("Pedidos", id)) {
                System.out.println("O intem da Tabela Pedidos foi encontrado.");
                stm.execute("delete from Pedidos where id_pedido = "+id);
                System.out.println("Item da tabela pedido foi deletado com sucesso.");
            } else {
                System.out.println("Item não encontrado.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro quanto tento fechar. Error: " + e);
            }
        }
    }
}
