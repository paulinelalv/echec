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
/** definition de la piece cavalier */
public class Cavalier extends Piece {
    
    /** couleur de la piece recuperee dans la classe mere Piece */
    public Cavalier(boolean blanc) {
        super(blanc);
    }
    
    /** affichage de la piece dans la grille dans la console par les lettres Cb et  Cn avec b pour blanc et n pour noir */
    public void affichage() {
        if (blanc){
            System.out.print("Cb");
        }
        else{
            System.out.print("Cn");
        }		
    }
    
    /** methode pour le deplacement en L du cavalier */
    private static Boolean deplacementL(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        return ((Math.abs(initialLigne - destinationLigne) == 2 && Math.abs(initialColonne - destinationColonne) == 1) || (Math.abs(initialLigne - destinationLigne) == 1 && Math.abs(initialColonne - destinationColonne) == 2));
    }
    
    /** methode pour verifier que le deplacement est autorise qui prend les coordonnee de l emplacement actuel de la piece et les coordonnees de son futur emplacement  */
    public boolean deplacement(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne) {
        return deplacementL(initialLigne, initialColonne, destinationLigne, destinationColonne);
    }
    
    /** valeur de la piece, ici 0  */
    public int valeurPiece() {
        return 3;
    }
    
}
