package Models;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class EtudiantModel extends AbstractTableModel {
         private String[] nomC = {"NOM","DOM ETUDE","NIVEAU"};
	     private ArrayList<String[]>  rows = new  ArrayList<String[]>();
	     private ArrayList<Etudiant> listEt = new ArrayList<Etudiant>();

		@Override
		public int getRowCount(){
			return rows.size();
		}

		public ArrayList<Etudiant> getListEt() {
			return listEt;
		}

		public void setListOf(ArrayList<Etudiant> listOf) {
			this.listEt = listOf;
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
		public void loadEtud(ArrayList<Etudiant> ets)
		{
			rows = new  ArrayList<String[]>();
			for(Etudiant et: ets)
			{
				rows.add(new String[] {et.getNom(),et.getDomEtude(), et.getNivEtude()});
		        listEt.add(et);	     	
			}
			fireTableChanged(null);
		}
		public void removeRow(int rowIndex) {
			 rows.remove(rowIndex);
			 listEt.remove(rowIndex);
			 //fireTableRowsDeleted(rowIndex, rowIndex);
		 }
		public void removeRowAll()
		{
			rows.clear();
			fireTableRowsDeleted(0, rows.size());
		}
		

	}
