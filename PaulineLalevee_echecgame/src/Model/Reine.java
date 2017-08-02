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
/** definition de la piece reine */
public class Reine extends Piece {
    
    /** couleur */
    public Reine(boolean blanc) {
        super(blanc);
    }
    
    /** affichage de la piece dans la grille de la console */
    public void affichage() {
        if (blanc){
            System.out.print("rb");
	}else{
            System.out.print("rn");
	}
    }
    
    /** retourne vrai si deplacement diagonal */
    private static Boolean diagonalPath(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        return ((Math.abs(initialLigne - destinationLigne) == Math.abs(initialColonne - destinationColonne)));
    }
    
    /** retourne vrai si deplacement droit */
    private static Boolean straightPath(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        return !((initialLigne != destinationLigne) && (initialColonne != destinationColonne));
    }
    
    /** deplacement dans la grille */
    public boolean deplacement(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        return (diagonalPath(initialLigne, initialColonne, destinationLigne, destinationColonne)) || straightPath(initialLigne, initialColonne, destinationLigne, destinationColonne);
    }
    
    public int valeurPiece() {
        return 9;
    }
    
}
