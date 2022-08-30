package br.com.lanchonete.dao;

import br.com.lanchonete.factory.ConnectionFactory;
import br.com.lanchonete.model.Lanche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LancheDAO {
    public void create(Lanche lanche) {
        String sql = " INSERT INTO lanche (nome,valor_custo,valor_venda,descricao)  VALUES(?,?,?,?) ";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //Criando a conexao
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, lanche.getNome());
            pstm.setDouble(2, lanche.getValor_custo());
            pstm.setDouble(3, lanche.getValor_venda());
            pstm.setString(4, lanche.getDescricao());
            pstm.execute();
            System.out.println("--SALVO COM SUCESSO---");
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

    public List<Lanche> read() {
        List<Lanche> lanches = new ArrayList<Lanche>();
        String sql = "SELECT * FROM lanche";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Lanche lanche = new Lanche();

                lanche.setId(rs.getInt("id"));
                lanche.setNome(rs.getString("nome"));
                lanche.setValor_custo(rs.getDouble("valor_custo"));
                lanche.setValor_venda(rs.getDouble("valor_venda"));
                lanche.setDescricao(rs.getString("descricao"));
                lanches.add(lanche);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lanches;
    }

    public void update(Lanche lanche) {
        String sql = "UPDATE lanche SET nome = ?, valor_custo = ?, valor_venda = ?,descricao = ? WHERE id = ?";
        // Perguntar usuario qual ele quer alterar, ou se quer alterar todos
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, lanche.getNome());
            pstm.setDouble(2, lanche.getValor_custo());
            pstm.setDouble(3, lanche.getValor_venda());
            pstm.setString(4, lanche.getDescricao());
            pstm.setInt(5, lanche.getId());
            pstm.execute();
            System.out.println("--ATUALIZADO COM SUCESSO--");
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM lanche WHERE id = ?";
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
