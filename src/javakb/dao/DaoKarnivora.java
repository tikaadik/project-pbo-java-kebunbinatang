/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.dao;

import com.mysql.jdbc.Connection;
import javakb.config.Koneksi;
import javakb.kelas.Karnivora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javakb.service.ServiceKarnivora;
/**
 *
 * @author Priliyandi
 */
public class DaoKarnivora implements ServiceKarnivora{
    
    private Connection connection;

    public DaoKarnivora() throws SQLException {
        connection = Koneksi.getConnection();
    }
    @Override
    public void insertKarnivora(Karnivora k) throws SQLException {
        PreparedStatement st = null;
        String sql = "INSERT INTO tbl_karnivora VALUE(?,?,?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, k.getId());
            st.setString(2, k.getNama());
            st.setString(3, k.getJk());
            st.setString(4, k.getJenis());
            st.setString(5, k.getHabitat());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }
    
    @Override
    public void updateKarnivora(Karnivora k) throws SQLException {
        PreparedStatement st = null;
        String sql = "UPDATE tbl_karnivora SET nama_binatang=?, jk=?, jenis_binatang=?, habitat=? WHERE id_binatang=?";
        try {
            st = connection.prepareStatement(sql);
            
            st.setString(1, k.getNama());
            st.setString(2, k.getJk());
            st.setString(3, k.getJenis());
            st.setString(4, k.getHabitat());
            st.setString(5, k.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }
    @Override
    public void deleteKarnivora(Karnivora k) throws SQLException {
        PreparedStatement st = null;
        String sql = "DELETE FROM tbl_karnivora WHERE id_binatang=?";

        try {
            st = connection.prepareCall(sql);
            st.setString(1, k.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }
    @Override
    public Karnivora getKarnivoraById(String id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        Karnivora k = null;
        String sql = "SELECT * FROM tbl_karnivora WHERE id_binatang=?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                k = new Karnivora();
                k.setId(rs.getString("id"));
                k.setNama(rs.getString("nama"));
                k.setJk(rs.getString("jk"));
                k.setJenis(rs.getString("jenis"));
                k.setHabitat(rs.getString("habitat"));
            }
            return k;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
    
    @Override
    public ArrayList<Karnivora> getKarnivora() throws SQLException {
        PreparedStatement st = null;
        ArrayList<Karnivora> listKarnivora = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_karnivora";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Karnivora k = new Karnivora();
                k.setId(rs.getString("id"));
                k.setNama(rs.getString("nama"));
                k.setJk(rs.getString("jk"));
                k.setJenis(rs.getString("jenis"));
                k.setHabitat(rs.getString("habitat"));
                listKarnivora.add(k);
            }
            return listKarnivora;
        } catch (SQLException e) {
            throw e;
        } finally {
            if(st != null){
                st.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }
}
