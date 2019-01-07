/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.service;
   
import javakb.kelas.Omnivora;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author LITTLEnstein
 */
public interface ServiceOmnivora {
    public void insertOmnivora(Omnivora o) throws SQLException;
    public void updateOmnivora(Omnivora o) throws SQLException;
    public void deleteOmnivora(Omnivora o) throws SQLException;
    public Omnivora getOmnivoraById(String id) throws SQLException;
    public ArrayList<Omnivora> getOmnivora() throws SQLException;
}
