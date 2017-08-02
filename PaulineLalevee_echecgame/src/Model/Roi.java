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
/** definition de la piece roi */
public class Roi extends Piece {
    
    /** couleur */
    public Roi(boolean blanc) {
        super(blanc);
    }
    
    /** affichage dans la grille */
    public void affichage() {
        if (blanc) {
            System.out.print("Rb");
        } else {
            System.out.print("Rn");
        }
    }
    
    
    
    /** deplacement */
    public boolean deplacement(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        return Math.abs(destinationLigne - initialLigne) == 1 && Math.abs(destinationColonne - initialColonne) == 0 || Math.abs(destinationLigne - initialLigne) == 1 && Math.abs(destinationColonne - initialColonne) == 1 || Math.abs(destinationLigne - initialLigne) == 0 && Math.abs(destinationColonne - initialColonne) == 1;
    }
    
    //* valeur 0 car le roi ne peut pas etre pris */
    public int valeurPiece() {
        return 0;
    }
}
