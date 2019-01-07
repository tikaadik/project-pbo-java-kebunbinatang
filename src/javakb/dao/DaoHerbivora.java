/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.dao;

import com.mysql.jdbc.Connection;
import javakb.config.Koneksi;
import javakb.kelas.Herbivora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javakb.kelas.Karnivora;
import javakb.service.ServiceHerbivora;

/**
 *
 * @author user
 */
public class DaoHerbivora implements ServiceHerbivora {
    private Connection connection;

    public DaoHerbivora() throws SQLException {
        connection = Koneksi.getConnection();
    }
    @Override
    public void insertHerbivora(Herbivora k) throws SQLException {
        PreparedStatement st = null;
        String sql = "INSERT INTO tbl_herbivora VALUE(?,?,?,?,?)";
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
    public void updateHerbivora(Herbivora k) throws SQLException {
        PreparedStatement st = null;
        String sql = "UPDATE tbl_herbivora SET nama_binatang=?, jk=?, jenis_binatang=?, habitat=? WHERE id_binatang=?";
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
    public void deleteHerbivora(Herbivora k) throws SQLException {
        PreparedStatement st = null;
        String sql = "DELETE FROM tbl_herbivora WHERE id_binatang=?";

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
    public Herbivora getHerbivoraById(String id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        Herbivora k = null;
        String sql = "SELECT * FROM tbl_herbivora WHERE id_binatang=?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                k = new Herbivora();
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
    public ArrayList<Herbivora> getHerbivora() throws SQLException {
        PreparedStatement st = null;
        ArrayList<Herbivora> listHerbivora = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_herbivora";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Herbivora k = new Herbivora();
                k.setId(rs.getString("id"));
                k.setNama(rs.getString("nama"));
                k.setJk(rs.getString("jk"));
                k.setJenis(rs.getString("jenis"));
                k.setHabitat(rs.getString("habitat"));
                listHerbivora.add(k);
            }
            return listHerbivora;
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
