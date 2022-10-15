package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Pedido;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository implements Repositorio<Integer, Pedido> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT POKE_STORE.SEQ_PEDIDO.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()){
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Pedido adicionar(Pedido pedido) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            pedido.setIdPedido(proximoId);

            String sql = "INSERT INTO PEDIDO\n" +
                    "(ID_PEDIDO,ID_CUPOM,ID_USUARIO,VALOR_FINAL)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, pedido.getIdPedido());
            stmt.setString(2, pedido.getIdCupom());
            stmt.setString(3, pedido.getIdUsuario());
            stmt.setString(3, pedido.getValorFinal());

            int res = stmt.executeUpdate();
            System.out.println("adicionarPedido.res=" + res);
            return pedido;
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
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM PEDIDO WHERE id_pedido = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerPedidoPorId.res=" + res);

            return res > 0;
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
    public boolean editar(Integer id, Pedido pedido) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PEDIDO SET ");
            sql.append(" ID_CUPOM = ?,");
            sql.append(" ID_USUARIO = ?,");
            sql.append(" VALOR_FINAL = ?,");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, pedido.getIdCupom());
            stmt.setString(2, pedido.getIdUsuario());
            stmt.setString(3, pedido.getValorFinal());

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarPedido.res=" + res);

            return res > 0;
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
    public List<Pedido> listar() throws BancoDeDadosException {
        List<Pedido> pedidos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM PEDIDO";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Pedido pedido = new Cupom();
                pedido.setIdPedido(res.getInt("ID_PEDIDO"));
                pedido.setIdCupom(res.getInt("ID_CUPOM"));
                pedido.setIdUsuario(res.getInt("ID_USUARIO"));
                pedido.setValorFinal(res.getDouble("VALOR_FINAL"));
                pedidos.add(pedido);
            }
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
        return pedidos;
    }

}