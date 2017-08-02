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
/** definition de la piece fou */
public class Fou extends Piece {
    
    /** couleur */
    public Fou(boolean blanc) {
        super(blanc);
    }
    
    /** affichage de la piece dans la grille de la console */
    public void affichage() {
        if (blanc) {
            System.out.print("Fb");
        } else {
            System.out.print("Fn");
        }
    }
    
    /** methode qui renvoie vrai si le chemin est diagonal */
    private static Boolean diagonalPath(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        return ((Math.abs(initialLigne - destinationLigne) == Math.abs(initialColonne - destinationColonne)));
    }
    
    /** deplacement de la piece dans la grille par les nouvelles coordonnees */
    public boolean deplacement(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
	return diagonalPath(initialLigne, initialColonne, destinationLigne, destinationColonne);
    }
    
    public int valeurPiece() {
	return 3;
    } 
}
