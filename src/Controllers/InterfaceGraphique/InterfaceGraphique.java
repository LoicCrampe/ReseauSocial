package Controllers.InterfaceGraphique;

import Controllers.InterfaceGraphique.ListeMembres.ListeMembres;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceGraphique extends JFrame implements ActionListener, java.io.Serializable {
    JMenuItem choix1;
    JMenuItem choix2;
    JMenuItem choix3;
    JMenuItem choix4;

    public InterfaceGraphique() {
        super                           ("SocialSports");
        choix1 = new JMenuItem          ("Liste des membres");
        choix2 = new JMenuItem          ("Liste des sports");
        choix3 = new JMenuItem          ("Liste des clubs");
        choix4 = new JMenuItem          ("Quitter");

        choix1.addActionListener        (this);
        choix2.addActionListener        (this);
        choix3.addActionListener        (this);
        choix4.addActionListener        (this);

        JMenu menuMembre = new JMenu    ("Membre");
        JMenu menuSport  = new JMenu    ("Sport");
        JMenu menuClub   = new JMenu    ("Club");
        JMenu menuOption = new JMenu    ("Option");

        menuMembre.add(choix1);
        menuSport.add(choix2);
        menuClub.add(choix3);
        menuOption.add(choix4);

        JMenuBar barreDeMenu = new JMenuBar();
        barreDeMenu.add(menuMembre);
        barreDeMenu.add(menuSport);
        barreDeMenu.add(menuClub);
        barreDeMenu.add(menuOption);

        setJMenuBar(barreDeMenu);

        setResizable(true);

        setBounds(600, 300, // Coordonnees du coin superieur gauche
                800, // largeur
                500); // hauteur

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == choix1) {
            new ListeMembres(this);
        }
        if (e.getSource() == choix2) {
        }
        if (e.getSource() == choix3) {
        }
        if (e.getSource() == choix4) {
            System.exit(0);
        }
    }
}
