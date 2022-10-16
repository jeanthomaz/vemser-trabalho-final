package com.dbc.repository;


import com.dbc.model.ProdutoPedido;
import com.dbc.exceptions.*;

import java.sql.*;
import java.util.List;

public class ProdutoPedidoRepository implements Repositorio<Integer, ProdutoPedido> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_PRODUTO_PEDIDO.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()){
            return res.getInt("mysequence");
        }
        return null;
    }

    @Override
    public ProdutoPedido adicionar(ProdutoPedido produtoPedido) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            produtoPedido.setIdProdutoPedido(proximoId);

            String sql = "INSERT INTO PRODUTO_PEDIDO\n" +
                    "(ID_PRODUTO_CARRINHO,ID_PRODUTO,ID_PEDIDO,QUANTIDADE, VALOR)\n" +
                    "VALUES(?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, proximoId);
            stmt.setInt(2, produtoPedido.getProduto().getIdProduto());
            stmt.setInt(3, produtoPedido.getPedido().getIdPedido());
            stmt.setInt(4, produtoPedido.getProduto().getQuantidade());
            stmt.setDouble(5, produtoPedido.getValor());
            int res = stmt.executeUpdate();
            System.out.println("adicionarPedido.res=" + res);
            return produtoPedido;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, ProdutoPedido produtoPedido) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<ProdutoPedido> listar() throws BancoDeDadosException {
        return null;
    }
}
