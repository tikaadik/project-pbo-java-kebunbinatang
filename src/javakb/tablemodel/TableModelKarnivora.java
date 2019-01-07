/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.tablemodel;

import java.util.ArrayList;
import javakb.kelas.Karnivora;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Priliyandi
 */
public class TableModelKarnivora extends AbstractTableModel{
    
    private ArrayList<Karnivora> listKarnivora = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listKarnivora.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return listKarnivora.get(rowIndex).getId();
            case 1: return listKarnivora.get(rowIndex).getNama();
            case 2: return listKarnivora.get(rowIndex).getJk();
            case 3: return listKarnivora.get(rowIndex).getJenis();
            case 4: return listKarnivora.get(rowIndex).getHabitat();
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
    
    public void insertKarnivora(Karnivora k){
        listKarnivora.add(k);
        fireTableDataChanged();
    }
    
    public void updateKarnivora(int index, Karnivora k){
        listKarnivora.set(index, k);
        fireTableDataChanged();
    }
    
    public void deleteKarnivora(int index){
        listKarnivora.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(ArrayList<Karnivora> listKarnivora){
        this.listKarnivora = listKarnivora;
        fireTableDataChanged();
    }
    
    public Karnivora getKarnivora(int index){
        return listKarnivora.get(index);
    }
    
    public void clear(){
        listKarnivora.clear();
    }
}
