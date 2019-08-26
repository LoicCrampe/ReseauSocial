package Controllers.InterfaceGraphique.ListeMembres;

import Controllers.Common.Club;
import Controllers.Common.Personne;
import Controllers.Common.ReseauSocial;
import Controllers.Common.Sport;
import Controllers.InterfaceGraphique.Membres;
import Controllers.StreamFile;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ModeleStatique extends AbstractTableModel implements java.io.Serializable {

    public static final List<Membres> membres = new ArrayList<Membres>();

    ReseauSocial reseauSocial = new ReseauSocial();
    Vector<Personne> allMembres = reseauSocial.getMembres();

    private final String[] entetes = {"Prénom", "Nom", "Age"};

    public ModeleStatique() {
        super();
//
//        membres.add(new Membres("Alain", "Terrieur", 44));
//        membres.add(new Membres("Marc", "Assin", 32));
//        membres.add(new Membres("Alex", "Terrieur", 44));
//        membres.add(new Membres("Sarah", "Croche", 44));
        }



    public int getRowCount() {
        return membres.size();
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return membres.get(rowIndex).getPrenom();
            case 1:
                return membres.get(rowIndex).getNom();
            case 2:
                return membres.get(rowIndex).getAge();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //Toutes les cellules éditables
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue != null){
            Membres membre = membres.get(rowIndex);

            switch(columnIndex){
                case 0:
                    membre.setPrenom((String)aValue);
                    break;
                case 1:
                    membre.setNom((String)aValue);
                    break;
                case 2:
                    membre.setAge((int)aValue);
                    break;
            }
        }
    }

    public void addMembre(Membres membre) {
        membres.add(membre);

        fireTableRowsInserted(membres.size() -1, membres.size() -1);
        StreamFile.write("membres.ser", (java.awt.List) membres);
    }

    public void removeAmi(int rowIndex) {
        membres.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}
