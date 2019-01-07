/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.tablemodel;

import java.util.ArrayList;
import javakb.kelas.Omnivora;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author LITTLEnstein
 */
public class TableModelOmnivora extends AbstractTableModel{
    
    private ArrayList<Omnivora> listOmnivora = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listOmnivora.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return listOmnivora.get(rowIndex).getId();
            case 1: return listOmnivora.get(rowIndex).getNama();
            case 2: return listOmnivora.get(rowIndex).getJk();
            case 3: return listOmnivora.get(rowIndex).getJenis();
            case 4: return listOmnivora.get(rowIndex).getHabitat();
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
    
    public void insertOmnivora(Omnivora o){
        listOmnivora.add(o);
        fireTableDataChanged();
    }
    
    public void updateOmnivora(int index, Omnivora o){
        listOmnivora.set(index, o);
        fireTableDataChanged();
    }
    
    public void deleteOmnivora(int index){
        listOmnivora.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(ArrayList<Omnivora> listOmnivora){
        this.listOmnivora = listOmnivora;
        fireTableDataChanged();
    }
    
    public Omnivora getOmnivora(int index){
        return listOmnivora.get(index);
    }
    
    public void clear(){
        listOmnivora.clear();
    }
}
