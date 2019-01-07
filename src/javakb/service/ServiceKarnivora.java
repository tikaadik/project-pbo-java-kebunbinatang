/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.service;
   
import javakb.kelas.Karnivora;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author LITTLEnstein
 */
public interface ServiceKarnivora {
    public void insertKarnivora(Karnivora k) throws SQLException;
    public void updateKarnivora(Karnivora k) throws SQLException;
    public void deleteKarnivora(Karnivora k) throws SQLException;
    public Karnivora getKarnivoraById(String id) throws SQLException;
    public ArrayList<Karnivora> getKarnivora() throws SQLException;
}
