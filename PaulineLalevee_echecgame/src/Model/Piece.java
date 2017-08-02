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
/** classe abstraite avec les methodes communes a toutes les pieces de l echiquier */
public abstract class Piece {
    
    /** booleen pour savoir si la piece est blanche ou noir */
    boolean blanc;
    
    /** couleur */
    public Piece(boolean blanc) {
	this.blanc = blanc;
    }
    
    /** retourne vrai ou faux avec vrai = la piece est blanche et faux elle est noir */
    public boolean blanc() {
        return blanc;
    }
    
    /** affichage des pieces dans la grille de la console */
    public abstract void affichage();
    
    /** deplacement */
    public abstract boolean deplacement(int initialLigne, int initialColonne, int destinationLigne, int destinationColonne);
    
    public abstract int valeurPiece();

}
