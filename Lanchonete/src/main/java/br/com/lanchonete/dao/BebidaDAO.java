package br.com.lanchonete.dao;

import br.com.lanchonete.factory.ConnectionFactory;
import br.com.lanchonete.model.Bebida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAO {

    public void create(Bebida bebida) {
        String sql = " INSERT INTO bebida (marca,litro,preco_custo,preco_venda) " +
                " VALUES (?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, bebida.getMarca());
            pstm.setString(2, bebida.getLitro());
            pstm.setDouble(3, bebida.getPreco_custo());
            pstm.setDouble(4, bebida.getPreco_venda());
            pstm.execute();
            System.out.println("--SALVO COM SUCESSO--");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Bebida> read() {
        List<Bebida> bebidas = new ArrayList<Bebida>();
        String sql = "SELECT * FROM bebida";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Bebida bebida = new Bebida();

                bebida.setId(rs.getInt("id"));
                bebida.setMarca(rs.getString("marca"));
                bebida.setLitro(rs.getString("litro"));
                bebida.setPreco_custo(rs.getDouble("preco_custo"));
                bebida.setPreco_venda(rs.getDouble("preco_venda"));
                bebidas.add(bebida);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return bebidas;
    }

    public void update(Bebida bebida) {
        String sql = "UPDATE bebida SET marca = ?, litro = ?, preco_custo = ?, preco_venda = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, bebida.getMarca());
            pstm.setString(2, bebida.getLitro());
            pstm.setDouble(3, bebida.getPreco_custo());
            pstm.setDouble(4, bebida.getPreco_venda());
            pstm.setInt(5, bebida.getId());
            pstm.execute();
            System.out.println("--ALTERADO COM SUCESSO--");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM bebida WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("--DELETADO COM SUCESSO--");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
