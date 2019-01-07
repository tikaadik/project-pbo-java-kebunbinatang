/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.tablemodel;

import java.util.ArrayList;
import javakb.kelas.Herbivora;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class TableModelHerbivora extends AbstractTableModel {
    private ArrayList<Herbivora> listHerbivora = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listHerbivora.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return listHerbivora.get(rowIndex).getId();
            case 1: return listHerbivora.get(rowIndex).getNama();
            case 2: return listHerbivora.get(rowIndex).getJk();
            case 3: return listHerbivora.get(rowIndex).getJenis();
            case 4: return listHerbivora.get(rowIndex).getHabitat();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "KODE";
            case 1: return "Nama";
            case 2: return "Jenis Kelamin";
            case 3: return "Kelompok";
            case 4: return "Habitat";
            default: return null;
        }
    }
    
    public void insertHerbivora(Herbivora k){
        listHerbivora.add(k);
        fireTableDataChanged();
    }
    
    public void updateHerbivora(int index, Herbivora k){
        listHerbivora.set(index, k);
        fireTableDataChanged();
    }
    
    public void deleteHerbivora(int index){
        listHerbivora.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(ArrayList<Herbivora> listHerbivora){
        this.listHerbivora = listHerbivora;
        fireTableDataChanged();
    }
    
    public Herbivora getHerbivora(int index){
        return listHerbivora.get(index);
    }
    
    public void clear(){
        listHerbivora.clear();
    }
}
