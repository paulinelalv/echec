/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Paulette
 */
/** definition de la piece pion */
public class Pion extends Piece {
    
    /** couleur */
    public Pion(boolean blanc) {
	super(blanc);
    }
    
    /** affichage de la piece dans la grille de la console */
    public void affichage() {
        if (this.blanc) {
            System.out.print("Pb");
	}
	if (!(this.blanc)) {
            System.out.print("Pn");
        }
    }
    
    /** deplacement */
    public boolean deplacement(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        if (this.blanc) {
            return (((initialColonne == destinationColonne) && initialLigne == (destinationLigne + 1)) || ((initialLigne == 6) && (initialColonne == destinationColonne) && (initialLigne == (destinationLigne + 1))) || ((initialLigne == (destinationLigne + 1)) && (Math.abs(initialColonne - destinationColonne) == 1))) && !((initialLigne != destinationLigne) && (initialColonne != destinationColonne)) ;
	}
	else {
            return (((initialColonne == destinationColonne) && initialLigne == (destinationLigne - 1)) || ((initialLigne == 1) && (initialColonne == destinationColonne) && (initialLigne == (destinationLigne - 1))) || ((initialLigne == (destinationLigne - 1)) && (Math.abs(initialColonne - destinationColonne) == 1))) && !((initialLigne != destinationLigne) && (initialColonne != destinationColonne)) ;
	}
    }
    
    public int valeurPiece() {
        return 1;
    }
}
