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
/** definition de la piece tour */
public class Tour extends Piece {
    
    /** couleur */
    public Tour(boolean blanc) {
        super(blanc);
    }
    
    /** affichage de la piece dans la grille */
    public void affichage() {
        if (blanc){
            System.out.print("Tb");
        }else{
            System.out.print("Tn");
        }		
    }
    
    /** renvoi vrai si deplacement droit */
    private static Boolean straightPath(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        return !((initialLigne != destinationLigne) && (initialColonne != destinationColonne));
    }
    
    /** deplacement */
    public boolean deplacement(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        return straightPath(initialLigne, initialColonne, destinationLigne, destinationColonne);
    }
    
    public int valeurPiece() {
        return 5;
    }
    
}
