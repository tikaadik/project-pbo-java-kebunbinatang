/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.service;

import javakb.kelas.Herbivora;
import java.sql.SQLException;
import java.util.ArrayList;
import javakb.kelas.Karnivora;

/**
 *
 * @author user
 */
public interface ServiceHerbivora {
    public void insertHerbivora(Herbivora k) throws SQLException;
    public void updateHerbivora(Herbivora k) throws SQLException;
    public void deleteHerbivora(Herbivora k) throws SQLException;
    public Herbivora getHerbivoraById(String id) throws SQLException;
    public ArrayList<Herbivora> getHerbivora() throws SQLException;
}
