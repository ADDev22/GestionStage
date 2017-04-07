package Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class OffreModel extends AbstractTableModel {
     private String[] nomC = {"LIBELLE","DEBUT","STATUS"};
     private ArrayList<String[]>  rows = new  ArrayList<String[]>();
     private ArrayList<OffreStage> listOf = new ArrayList<OffreStage>();
     public OffreModel() {

	}

	@Override
	public int getRowCount(){
		return rows.size();
	}

	public ArrayList<OffreStage> getListOf() {
		return listOf;
	}

	public void setListOf(ArrayList<OffreStage> listOf) {
		this.listOf = listOf;
	}

	@Override
	public int getColumnCount() {
		return nomC.length;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.nomC[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		      return rows.get(rowIndex)[columnIndex];
	}
	public void loadOffre(ArrayList<OffreStage> ofs)
	{
		String status="";
		rows = new  ArrayList<String[]>();
		for(OffreStage of: ofs)
		{
			switch(of.getIsValide())
			{
			case 0:
				status ="Attente";
				break;
			case 1:
				status ="Validé";
				break;
			default :
				status ="Rejette";
				break;
			}
			rows.add(new String[] {of.getLibelleOffre(),of.getDateDebut(),status});
	        listOf.add(of);	     	
		}
		fireTableChanged(null);
	}
	public void removeRow(int rowIndex) {
		 rows.remove(rowIndex);
		 fireTableRowsDeleted(rowIndex, rowIndex);
	 }
	public void removeRowAll()
	{
		rows.clear();
		listOf.clear();
		fireTableChanged(null);
	}
  
}
