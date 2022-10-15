package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Cupom;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CupomRepository implements Repositorio<Integer, Cupom> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT POKE_STORE.SEQ_CUPOM.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()){
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public Cupom adicionar(Cupom cupom) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            cupom.setIdCupom(proximoId);

            String sql = "INSERT INTO CUPOM\n" +
                    "(ID_CUPOM,DESCONTO,VALIDADE)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, cupom.getIdCupom());
            stmt.setString(2, cupom.getValor());
            stmt.setString(3, cupom.isValidade());

            int res = stmt.executeUpdate();
            System.out.println("adicionarCupom.res=" + res);
            return cupom;
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

            String sql = "DELETE FROM CUPOM WHERE id_cupom = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("removerCupomPorId.res=" + res);

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
    public boolean editar(Integer id, Cupom cupom) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CUPOM SET ");
            sql.append(" VALOR = ?,");
            sql.append(" VALIDADE = ?,");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, cupom.getIdCupom());
            stmt.setDouble(2, cupom.getValor());
            stmt.setBoolean(3, cupom.isValidade());

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
    public List<Cupom> listar() throws BancoDeDadosException {
        List<Cupom> cupons = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM CUPOM";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Cupom cupom = new Cupom();
                cupom.setIdCupom(res.getInt("ID_CUPOM"));
                cupom.setValor(res.getString("VALOR"));
                cupom.setValidade(res.getString("VALIDADE"));
                cupons.add(cupom);
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
        return cupons;
    }

}