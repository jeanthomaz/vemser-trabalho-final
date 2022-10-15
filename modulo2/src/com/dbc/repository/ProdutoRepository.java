package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Usuario;
import com.dbc.model.Produto;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements Repositorio<Integer, Produto> {

    @Override
    public Integer getProximoId(Connection connection) throws BancoDeDadosException {
        try {
            String sql = "SELECT POKE_STORE.SEQ_PRODUTO.nextval mysequence from DUAL";
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            if (res.next()) {
                return res.getInt("mysequence");
            }

            return null;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        }
    }

    @Override
    public Produto adicionar(Produto produto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            produto.setIdProduto(proximoId);

            String sql = "INSERT INTO PRODUTO\n" +
                    "(ID_PRODUTO,NOME,DESCRICAO,QUANTIDADE,TIPO,VALOR,ID_USUARIO)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, produto.getIdProduto());
            stmt.setString(2,produto.getNome());
            stmt.setString(3,produto.getDescricao());
            stmt.setInt(4,produto.getQuantidade());
            stmt.setInt(5,produto.getTipo().getTipos());
            stmt.setDouble(6,produto.getValor());
            stmt.setInt(7,produto.getIdUsuario());

            int res = stmt.executeUpdate();
            System.out.println("adicionarProduto.res=" + res);
            return produto;
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

            String sql = "DELETE FROM PRODUTO WHERE ID_PRODUTO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerProdutoPorId.res=" + res);

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
    public boolean editar(Integer id, Produto produto) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PRODUTO SET ");
            sql.append(" NOME = ?,");
            sql.append(" DESCRICAO = ?,");
            sql.append(" QUANTIDADE = ? ");
            sql.append(" TIPO = ? ");
            sql.append(" VALOR = ? ");
            sql.append(" ID_USUARIO = ? ");
            sql.append(" WHERE ID_PRODUTO = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, produto.getIdProduto());
            stmt.setString(2,produto.getNome());
            stmt.setString(3,produto.getDescricao());
            stmt.setInt(4,produto.getQuantidade());
            stmt.setInt(5,produto.getTipo().getTipos());
            stmt.setDouble(6,produto.getValor());
            stmt.setInt(7,produto.getIdUsuario());

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("editarCupom.res=" + res);

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
    public List<Produto> listar() throws BancoDeDadosException {
        List<Produto> produtos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM PRODUTO";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(res.getInt("ID_PRODUTO"));
                produto.setNome(res.getString("NOME"));
                produto.setDescricao(res.getString("DESCRICAO"));
                produto.setQuantidade(res.getInt("QUANTIDADE"));
                produto.setValor(res.getDouble("VALOR"));
                produto.setIdUsuario(res.getInt("ID_USUARIO"));
                produtos.add(produto);
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
        return produtos;
    }
}
