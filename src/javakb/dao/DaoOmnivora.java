/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.dao;

import com.mysql.jdbc.Connection;
import javakb.config.Koneksi;
import javakb.kelas.Omnivora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javakb.service.ServiceOmnivora;
/**
 *
 * @author LITTLEnstein
 */
public class DaoOmnivora implements ServiceOmnivora{
    
    private Connection connection;

    public DaoOmnivora() throws SQLException {
        connection = Koneksi.getConnection();
    }
    @Override
    public void insertOmnivora(Omnivora o) throws SQLException {
        PreparedStatement st = null;
        String sql = "INSERT INTO tbl_omnivora VALUE(?,?,?,?,?)";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, o.getId());
            st.setString(2, o.getNama());
            st.setString(3, o.getJk());
            st.setString(4, o.getJenis());
            st.setString(5, o.getHabitat());
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
    public void updateOmnivora(Omnivora o) throws SQLException {
        PreparedStatement st = null;
        String sql = "UPDATE tbl_omnivora SET nama_binatang=?, jk=?, jenis_binatang=?, habitat=? WHERE id_binatang=?";
        try {
            st = connection.prepareStatement(sql);
            
            st.setString(1, o.getNama());
            st.setString(2, o.getJk());
            st.setString(3, o.getJenis());
            st.setString(4, o.getHabitat());
            st.setString(5, o.getId());
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
    public void deleteOmnivora(Omnivora o) throws SQLException {
        PreparedStatement st = null;
        String sql = "DELETE FROM tbl_omnivora WHERE id_binatang=?";

        try {
            st = connection.prepareCall(sql);
            st.setString(1, o.getId());
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
    public Omnivora getOmnivoraById(String id) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        Omnivora o = null;
        String sql = "SELECT * FROM tbl_omnivora WHERE id_binatang=?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                o = new Omnivora();
                o.setId(rs.getString("id"));
                o.setNama(rs.getString("nama"));
                o.setJk(rs.getString("jk"));
                o.setJenis(rs.getString("jenis"));
                o.setHabitat(rs.getString("habitat"));
            }
            return o;
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
    public ArrayList<Omnivora> getOmnivora() throws SQLException {
        PreparedStatement st = null;
        ArrayList<Omnivora> listOmnivora = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT * FROM tbl_omnivora";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Omnivora o = new Omnivora();
                o.setId(rs.getString("id"));
                o.setNama(rs.getString("nama"));
                o.setJk(rs.getString("jk"));
                o.setJenis(rs.getString("jenis"));
                o.setHabitat(rs.getString("habitat"));
                listOmnivora.add(o);
            }
            return listOmnivora;
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
