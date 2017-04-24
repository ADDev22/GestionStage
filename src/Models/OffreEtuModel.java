package Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class OffreEtuModel extends AbstractTableModel {
	
	     private String[] nomC = {"ENTREPISE","LIBELE","DATE DEBUT", "DUREE"};
	     private ArrayList<String[]>  rows = new  ArrayList<String[]>();
	     private ArrayList<OffreStage> listOf = new ArrayList<OffreStage>();
	     
	     public OffreEtuModel() {
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
			listOf.clear();
			rows = new  ArrayList<String[]>();
			
			if(ofs ==null) {}
			else
			{
			for(OffreStage of: ofs)
			{
                rows.add(new String[] {of.getEntreprise().getRaisonSociale(),  of.getLibelleOffre(), of.getDateDebut(),of.getDureeOffre()});
		        listOf.add(of);	     	
			}
			}
			fireTableChanged(null);
		}
		public void removeRow(int rowIndex) {
			 rows.remove(rowIndex);
			 listOf.remove(rowIndex);
			 fireTableRowsDeleted(rowIndex, rowIndex);
		 }
		

	}
