package Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CandModel extends AbstractTableModel{
	
    private String[] nomC = {"ENTREPRISE","POSTE","DATE CANDIDATURE", "STATUS"};
    private ArrayList<String[]>  rows = new  ArrayList<String[]>();
    private ArrayList<EtuPostStage> listCand = new ArrayList<EtuPostStage>();
    public CandModel() {

	}

	@Override
	public int getRowCount(){
		return rows.size();
	}

	public ArrayList<EtuPostStage> getListCand() {
		return listCand;
	}

	public void setListOf(ArrayList<EtuPostStage> listOf) {
		this.listCand = listOf;
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
	public void loadCand(ArrayList<EtuPostStage> cands)
	{   
		String status="";
		rows = new  ArrayList<String[]>();
		for(EtuPostStage cand: cands)
		{
			switch(cand.getIsAccept())
			{
			 case 0 :
				 status = "EN ATTENTE";
				 break;
			 case 1:
				 status ="ACCEPTE";
			     break;
			  default :
				  status = "REFUSE";
				  break;
			}
			rows.add(new String[] {cand.getOffre().getEntreprise().getRaisonSociale(),
					cand.getOffre().getDomaineOffre(), String.valueOf(cand.getDatePostule()),status});
	        listCand.add(cand);	     	
		}
		fireTableChanged(null);
	}
	public void removeRow(int rowIndex) {
		 rows.remove(rowIndex);
		 listCand.remove(rowIndex);
		 fireTableRowsDeleted(rowIndex, rowIndex);
	 }

}
