package Controllers.InterfaceGraphique.ListeMembres;
import Controllers.Common.Personne;
import Controllers.Common.ReseauSocial;

import Controllers.InterfaceGraphique.InterfaceGraphique;
import Controllers.InterfaceGraphique.Membres;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class ListeMembres extends JDialog implements ActionListener {

    private ModeleStatique modele = new ModeleStatique();
    private JTable tableau;

    private JButton                         modifier;
    private JButton                         supprimer;
    private JButton                         ajouter;
    private JButton                         fermer;



    public ListeMembres (InterfaceGraphique _interfaceGraphique) {

        super                               (_interfaceGraphique, "Liste des membres", true);

        setResizable                        (true);
        setBounds                           (600, 300, 500, 500);
        getContentPane().setLayout          (new FlowLayout());


        tableau = new JTable                (modele);


        tableau.setBounds                   (30,40,1200,400);
        JScrollPane sp = new JScrollPane    (tableau);
        getContentPane().add                (sp, BorderLayout.NORTH);

        JPanel boutons = new JPanel         ();

        boutons.add                         (new JButton(new AddAction()));
        boutons.add                         (new JButton(new RemoveAction()));

        getContentPane().add                (boutons, BorderLayout.SOUTH);

        fermer = new JButton                ("Fermer");
        fermer.addActionListener            (this);
        getContentPane().add                (fermer, BorderLayout.SOUTH);

        setVisible                          (true);
    }

    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == fermer) {
            setVisible(false);
        }
    }

    private class AddAction extends AbstractAction {
        private AddAction() {
            super("Ajouter");
        }

        public void actionPerformed(ActionEvent e) {
            modele.addMembre(new Membres("Megan", "Sami", 23));
        }
    }

    private class RemoveAction extends AbstractAction {
        private RemoveAction() {
            super("Supprimmer");
        }

        public void actionPerformed(ActionEvent e) {
            int[] selection = tableau.getSelectedRows();

            for(int i = selection.length - 1; i >= 0; i--){
                modele.removeAmi(selection[i]);
            }
        }
    }
}
